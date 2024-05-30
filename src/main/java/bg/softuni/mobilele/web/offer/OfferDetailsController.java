package bg.softuni.mobilele.web.offer;

import bg.softuni.mobilele.serveces.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferDetailsController {
    private final OfferService offerService;

    public OfferDetailsController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("offerDetails", this.offerService.getOfferDetails(id));

        return "details";
    }
}
