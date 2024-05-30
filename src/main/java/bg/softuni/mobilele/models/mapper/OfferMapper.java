package bg.softuni.mobilele.models.mapper;

import bg.softuni.mobilele.models.dtos.AddOfferDTO;
import bg.softuni.mobilele.models.entities.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {
    Offer addOfferDtoToOffer(AddOfferDTO addOfferDTO);
}
