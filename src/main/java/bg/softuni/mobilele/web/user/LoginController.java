package bg.softuni.mobilele.web.user;

import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.serveces.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class LoginController {
//    private final UserService userService;

//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }

    @ModelAttribute("loginModel")
    public UserLoginDTO loginUser() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO) {
//        if (this.userService.isLoggedIn()) {
//            return "redirect:/offers/all";
//        }
        return "auth-login";
    }

    @GetMapping("/login-error")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("auth-login");
        modelAndView.addObject("loginError", true);
        modelAndView.addObject("loginModel", new UserRegisterDTO());

        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (this.userService.isLoggedIn()) {
//            return "redirect:/";
//        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginModel", loginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel", bindingResult);
            redirectAttributes.addFlashAttribute("login-error", true);
            return "redirect:/users/login";
        }
//        boolean success = userService.login(loginModel);

//        if (!success) {
//            redirectAttributes.addFlashAttribute("loginError", true);
//
//            return "redirect:/users/login";
//        }
        return "redirect:/offers/all";
    }

    @GetMapping("/logout")
    public String logout() {
//        userService.logout();
        return "redirect:/";
    }
}
