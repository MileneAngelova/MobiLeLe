package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class AddOfferDTO {
    @NotNull
    @Positive
    private Long modelId;

    @Positive
    @NotNull(message = "This field can not be empty")
    private BigDecimal price;

    @NotNull(message = "This field can not be empty")
    private EngineEnum engine;

    @NotNull(message = "This field can not be empty")
    private TransmissionEnum transmission;

    @NotNull(message = "This field can not be empty")
    @Min(1990)
    private Integer year;

    @Positive
    private int mileage;

    private String description;

    private String imageUrl;

    public AddOfferDTO() {
    }


    public Long getModelId() {
        return modelId;
    }

    public AddOfferDTO setModel(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public AddOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AddOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public AddOfferDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public AddOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "AddOfferDTO{" +
                "modelId=" + modelId +
                ", price=" + price +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", year=" + year +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                ", url='" + imageUrl + '\'' +
                '}';
    }
}
