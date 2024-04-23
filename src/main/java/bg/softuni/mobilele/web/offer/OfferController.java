package bg.softuni.mobilele.web.offer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {
    @GetMapping("/offers/all")
    public String getAllOffers() {
        return "offers";
    }
}
