package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.AddOfferDTO;
import bg.softuni.mobilele.models.dtos.BrandDTO;
import bg.softuni.mobilele.models.dtos.OfferDetailsDTO;
import bg.softuni.mobilele.models.dtos.AllOffersDTO;
import bg.softuni.mobilele.models.entities.Model;
import bg.softuni.mobilele.models.entities.Offer;
import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.models.mapper.OfferMapper;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
//import bg.softuni.mobilele.user.CurrentUser;
import bg.softuni.mobilele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
//    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;
    private final ModelMapper modelMapper;
    private final ExRateService exRateService;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository,
//                        CurrentUser currentUser
            OfferMapper offerMapper, ModelMapper modelMapper, ExRateService exRateService) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
//        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
        this.modelMapper = modelMapper;
        this.exRateService = exRateService;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer newOffer = offerMapper.addOfferDtoToOffer(addOfferDTO);
//        UserEntity seller = userRepository.findByEmail(currentUser.getEmail()).orElse(null);
//        System.out.println(currentUser.getEmail() + " " + currentUser.getName());
        Model model = this.modelRepository.findById(addOfferDTO.getModelId()).orElse(null);

//        newOffer.setSeller(seller);
        newOffer.setModel(model);
        offerRepository.save(newOffer);
    }

    public OfferDetailsDTO getOfferDetails(Long id) {
        return this.offerRepository.findById(id)
                .map(this::toOfferDetails)
                .orElse(null);
    }



    private OfferDetailsDTO toOfferDetails(Offer offer) {
        return new OfferDetailsDTO(offer.getId(), offer.getYear(), offer.getModel().getBrand().getName(), offer.getModel().getName(), offer.getMileage(), offer.getPrice(),
                offer.getEngine(), offer.getTransmission(), offer.getCreated(), offer.getModified(),
                String.format(offer.getSeller().getFirstName() + "  " + offer.getSeller().getLastName()),
                offer.getImageUrl(),
                exRateService.allSupportedCurrencies());
    }

    public List<AllOffersDTO> getAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(OfferService::toAllOffersDTO)
                .toList();
    }

    private static AllOffersDTO toAllOffersDTO(Offer offer) {
        return new AllOffersDTO(offer.getId(), offer.getYear(), offer.getModel().getBrand().getName(),
                offer.getModel().getName(), offer.getMileage(), offer.getPrice(), offer.getEngine(),
                offer.getTransmission(), offer.getImageUrl());
    }

    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }
}
