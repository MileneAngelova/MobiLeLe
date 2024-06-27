package bg.softuni.mobilele.init;

import bg.softuni.mobilele.serveces.ExRateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateInitializer implements CommandLineRunner {
    private final ExRateService exRateService;

    public ExchangeRateInitializer(ExRateService exRateService) {
        this.exRateService = exRateService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!exRateService.hasInitialisedExRates()) {
            exRateService.updateRates(exRateService.fetchExRatesRates());
        }
    }
}
