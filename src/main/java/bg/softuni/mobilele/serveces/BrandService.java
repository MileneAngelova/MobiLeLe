package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.BrandDTO;
import bg.softuni.mobilele.models.dtos.ModelDTO;
import bg.softuni.mobilele.models.entities.Brand;
import bg.softuni.mobilele.models.entities.Model;
import bg.softuni.mobilele.repositories.BrandRepository;
import bg.softuni.mobilele.repositories.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandService(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    public List<BrandDTO> getAllBrands() {
       return this.brandRepository.findAll().stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(Brand brand) {
        List<ModelDTO> models = brand.getModels()
                .stream().map(this::mapModel).toList();

        return new BrandDTO().setModels(models).setName(brand.getName());
    }

    private ModelDTO mapModel(Model model) {
        return new ModelDTO().setId(model.getId())
                .setName(model.getName())
                .setCategory(model.getCategory())
                .setStartYear(model.getStartYear())
                .setEndYear(model.getEndYear())
                .setImageUrl(model.getImageUrl());
    }
}
