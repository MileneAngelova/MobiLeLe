package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.AddOfferDTO;
import bg.softuni.mobilele.models.dtos.OfferDetailsDTO;
import bg.softuni.mobilele.models.entities.Model;
import bg.softuni.mobilele.models.entities.Offer;
import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.models.mapper.OfferMapper;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, CurrentUser currentUser, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer newOffer = offerMapper.addOfferDtoToOffer(addOfferDTO);
        User seller = userRepository.findByEmail(currentUser.getEmail()).orElseThrow();
        Model model = this.modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);
        offerRepository.save(newOffer);
    }

    public OfferDetailsDTO getOfferDetails(Long id) {
   return this.offerRepository.findById(id)
            .map(OfferService::toOfferDetails)
           .orElseThrow();
    }

    private static OfferDetailsDTO toOfferDetails(Offer offer) {
        return new OfferDetailsDTO(offer.getId(), offer.getDescription(), offer.getMileage(),
                offer.getEngine());
    }
}
