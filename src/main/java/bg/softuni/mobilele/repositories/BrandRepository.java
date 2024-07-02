package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.models.dtos.ModelDTO;
import bg.softuni.mobilele.models.entities.Brand;
import bg.softuni.mobilele.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
