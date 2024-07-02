package bg.softuni.mobilele.web.brands;

import bg.softuni.mobilele.models.dtos.BrandDTO;
import bg.softuni.mobilele.models.dtos.ModelDTO;
import bg.softuni.mobilele.serveces.BrandService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("brandModel")
    public BrandDTO brandDTO() {
        return new BrandDTO();
    }

    @GetMapping("/brands/all")
    public String getAllBrands(Model model) {
        List<BrandDTO> allBrands = this.brandService.allBrands();
        List<ModelDTO> allModels = this.brandService.getModels();

        model.addAttribute("allBrands", allBrands);
        model.addAttribute("allModels", allModels);

        return "brands";
    }
}
