package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.EngineEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OfferDetailsDTO {
    private Long id;
    private String description;
    @Positive
    private int mileage;
    @NotNull
    private EngineEnum engineEnum;

    public OfferDetailsDTO(Long id, String description, int mileage, EngineEnum engine) {
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDetailsDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineEnum getEngineEnum() {
        return engineEnum;
    }

    public OfferDetailsDTO setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
        return this;
    }
}
