package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;

import java.math.BigDecimal;

public class AllOffersDTO {
    private Long id;
    private int year;
    private String brand;
    private String model;
    private int mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String image;

    public AllOffersDTO(Long id, int year, String brand, String model, int mileage, BigDecimal price, EngineEnum engine, TransmissionEnum transmission, String image) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.engine = engine;
        this.transmission = transmission;
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public AllOffersDTO setYear(int year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public AllOffersDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AllOffersDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AllOffersDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public AllOffersDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public AllOffersDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AllOffersDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AllOffersDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AllOffersDTO setImage(String image) {
        this.image = image;
        return this;
    }
}
