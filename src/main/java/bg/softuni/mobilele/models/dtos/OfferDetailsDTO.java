package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OfferDetailsDTO {
    private Long id;
    private int year;
    private String brand;
    private String model;
    private int mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String sellerName;
    private String image;
    private List<String> currencies;

    public OfferDetailsDTO() {
    }

    public OfferDetailsDTO(Long id, int year, String brand, String model, int mileage, BigDecimal price, EngineEnum engine, TransmissionEnum transmission, LocalDateTime created, LocalDateTime modified, String sellerName, String image, List<String> allSupportedCurrencies) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.engine = engine;
        this.transmission = transmission;
        this.created = created;
        this.modified = modified;
        this.sellerName = sellerName;
        this.image = image;
        this.currencies = allSupportedCurrencies;
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailsDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDetailsDTO setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDetailsDTO setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getSeller() {
        return sellerName;
    }

    public OfferDetailsDTO setSeller(String seller) {
        this.sellerName = seller;
        return this;
    }
    public int getMileage() {
        return mileage;
    }
    public OfferDetailsDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }
    public int getYear() {
        return year;
    }
    public OfferDetailsDTO setYear(int year) {
        this.year = year;
        return this;
    }
    public String getBrand() {
        return brand;
    }
    public OfferDetailsDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public String getModel() {
        return model;
    }
    public OfferDetailsDTO setModel(String model) {
        this.model = model;
        return this;
    }
    public String getImage() {
        return image;
    }
    public OfferDetailsDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public OfferDetailsDTO setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }
}
