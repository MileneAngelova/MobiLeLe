package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.EngineEnum;

public class OfferSummaryDTO {
    private Long id;
    private String description;
    private int mileage;

    private EngineEnum engine;

    public OfferSummaryDTO(Long id, String description, int mileage, EngineEnum engine) {
        this.id = id;
        this.description = description;
        this.mileage = mileage;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public OfferSummaryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSummaryDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }
}
