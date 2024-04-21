package bg.softuni.mobilele.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
     @Column(nullable = false)
     private String name;

     @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private List<Model> models = new ArrayList<>();

     public Brand() {
     }

     public String getName() {
          return name;
     }

     public Brand setName(String name) {
          this.name = name;
          return this;
     }

     public List<Model> getModels() {
          return models;
     }

     public Brand setModels(List<Model> models) {
          this.models = models;
          return this;
     }

     @Override
     public String toString() {
          return "Brand{" +
                  "name='" + name + '\'' +
                  ", models=" + models +
                  '}';
     }
}
