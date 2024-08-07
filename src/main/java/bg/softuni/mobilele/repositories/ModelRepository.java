package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByName(String name);
//    List<Model> findAllByBrand(String name);
}
