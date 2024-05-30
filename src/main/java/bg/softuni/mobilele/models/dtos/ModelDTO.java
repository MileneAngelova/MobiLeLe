package bg.softuni.mobilele.models.dtos;

public class ModelDTO {
    private Long id;
    private String name;

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
}
