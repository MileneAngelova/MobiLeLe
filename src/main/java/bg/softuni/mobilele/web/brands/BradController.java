package bg.softuni.mobilele.web.brands;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BradController {
    @GetMapping("/brands/all")
    public String getAllBrands() {
        return "brands";
    }
}
