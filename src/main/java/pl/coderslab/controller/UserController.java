package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {
    UserService userService;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/register")
    public String register(@Valid UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/details")
    public String details(Model model) {
        User user = userService.findLoggedInUser();
        model.addAttribute("loggedUser", user);
        model.addAttribute("played", userService.playedThisMonth(user));
        return "details";
    }


}
