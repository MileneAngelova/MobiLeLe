package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.config.ForexApiConfig;
import bg.softuni.mobilele.config.RestConfig;
import bg.softuni.mobilele.models.dtos.ExRatesDTO;
import bg.softuni.mobilele.models.entities.ExRateEntity;
import bg.softuni.mobilele.repositories.ExRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExRateService {
    private final Logger LOGGER = LoggerFactory.getLogger(ExRateService.class);
    private final ExRateRepository exRateRepository;
    private final ForexApiConfig forexApiConfig;
    private final RestConfig restConfig;
    private final RestClient restClient;

    public ExRateService(ExRateRepository exRateRepository, ForexApiConfig forexApiConfig, RestConfig restConfig, RestClient restClient) {
        this.exRateRepository = exRateRepository;
        this.forexApiConfig = forexApiConfig;
        this.restConfig = restConfig;
        this.restClient = restClient;
    }

    public boolean hasInitialisedExRates() {
        return exRateRepository.count() > 0;
    }

    public ExRatesDTO fetchExRatesRates() {
        return restClient.get().uri(forexApiConfig.getUrl(), forexApiConfig.getKey())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ExRatesDTO.class);

    }

    public void updateRates(ExRatesDTO exRatesDTO) {
        LOGGER.info("Updating {} rates.", exRatesDTO.getRates().size());

        if (!forexApiConfig.getBase().equals(exRatesDTO.getBase())) {
            throw new IllegalArgumentException("The exchange rates that should be updated are not based on "
                    + forexApiConfig.getBase() + "but rather on " + exRatesDTO.getBase());
        }

        exRatesDTO.getRates().forEach((currency, rate) -> {
            ExRateEntity exRateEntity = exRateRepository.findByCurrency(currency)
                    .orElseGet(() -> new ExRateEntity()
                            .setRate(rate)
                            .setCurrency(currency));
            exRateEntity.setRate(rate);
            exRateRepository.save(exRateEntity);
        });
    }

//    Optional<BigDecimal> findExRate(String from, String to) {
//        if (Objects.equals(from, to)) {
//            return Optional.of(BigDecimal.ONE);
//        }
//// USD/BGN = x
//// USD/EUR = y
//
//        // USD = x * BGN
//        // USD = y * EUR
//        Optional<BigDecimal> fromOpt = forexApiConfig.getBase().equals(from) ?
//                Optional.of(BigDecimal.ONE) :
//                exRateRepository.findByCurrency(to)
//                        .map(ExRateEntity::getRate);
//        if (fromOpt.isEmpty() || toOpt.isEmpty()) {
//            return Optional.empty();
//        } else {
//            return Optional.of(toOpt.get().devide(from.get(), 2, RoundingMode.HALF_DOWN));
//        }
//        return Optional.empty();
//    }
//
//    BigDecimal convert(String from, String to, BigDecimal amount) {
//
//    }
}
