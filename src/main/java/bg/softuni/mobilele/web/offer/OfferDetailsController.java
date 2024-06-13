package bg.softuni.mobilele.web.offer;

import bg.softuni.mobilele.serveces.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfferDetailsController {
    private final OfferService offerService;

    public OfferDetailsController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("offerDetails", this.offerService.getOfferDetails(id));

        return "details";
    }

    @DeleteMapping("/offers/delete/{id}")
    public String deleteOffer(@PathVariable("id") Long id) {
        this.offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }
}
