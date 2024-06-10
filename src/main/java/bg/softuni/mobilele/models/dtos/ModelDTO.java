package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.CategoryEnum;

import java.time.LocalDate;

public class ModelDTO {
    private Long id;
    private String name;
    private CategoryEnum category;
    private Long startYear;
    private Long endYear;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ModelDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelDTO setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public Long getStartYear() {
        return startYear;
    }

    public ModelDTO setStartYear(Long startYear) {
        this.startYear = startYear;
        return this;
    }

    public Long getEndYear() {
        return endYear;
    }

    public ModelDTO setEndYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
