package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.UserService;

@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("best",userService.findBest());
        return "home";
    }
}
