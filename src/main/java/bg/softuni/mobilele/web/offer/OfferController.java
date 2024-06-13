package bg.softuni.mobilele.web.offer;

import bg.softuni.mobilele.models.dtos.AddOfferDTO;
import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.serveces.BrandService;
import bg.softuni.mobilele.serveces.OfferService;
import bg.softuni.mobilele.serveces.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("offers")
public class OfferController {
    private final OfferService offerService;
    private final BrandService brandService;
    private final UserService userService;

    public OfferController(OfferService offerService, BrandService brandService, UserService userService) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.userService = userService;
    }

    @ModelAttribute("engineTypes")
    public EngineEnum[] allEngineTypes() {
        return EngineEnum.values();
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        model.addAttribute("allOffers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model, UserLoginDTO userLoginDTO) {
        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());
//        if (!this.userService.isLoggedIn(userLoginDTO)) {
//            return "redirect:/";
//        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, UserLoginDTO userLoginDTO) {
//        if (!this.userService.isLoggedIn(userLoginDTO)) {
//            return "redirect:/";
//        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);

            return "redirect:/offers/add";
        }
        this.offerService.addOffer(addOfferModel);
        return "redirect:/offers/all";
    }
}
