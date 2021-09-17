package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserQuestionDTO;
import pl.coderslab.dto.UserQuoteDTO;
import pl.coderslab.model.Character;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.QuoteService;
import pl.coderslab.service.UsersQuestionService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/add")
public class NewQuestionsController {
    private CharacterService characterService;
    private QuoteService quoteService;
    private UsersQuestionService usersQuestionService;

    @ModelAttribute("characters")
    public Collection<Character> characters() {
        return this.characterService.findAll();
    }

    @RequestMapping("/quote")
    public String register(Model model) {
        model.addAttribute("userQuoteDTO", new UserQuoteDTO());
        return "userQuote";
    }

    @PostMapping("/quote")
    public String create(@Valid UserQuoteDTO userQuoteDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "userQuote";
        }
        quoteService.save(userQuoteDTO);
        return "redirect:/";
    }

    @RequestMapping("/approve")
    public String forApprove(Model model) {
        model.addAttribute("quotesToApprove", quoteService.findAllByApproved(false));
        model.addAttribute("usersQuestionsToApprove", usersQuestionService.findAllNotApproved());
        return "forApproval";
    }

    @RequestMapping("/approve/quote/{id}")
    public String quoteApprove(@PathVariable Long id) {
        quoteService.approve(id);
        return "redirect:/add/approve";
    }

    @RequestMapping("/approve/question/{id}")
    public String questionApprove(@PathVariable Long id) {
        usersQuestionService.approve(id);
        return "redirect:/add/approve";
    }


    @RequestMapping("/question")
    public String addQuestion(Model model) {
        model.addAttribute("userQuestionDTO", new UserQuestionDTO());
        return "userQuestion";
    }

    @PostMapping("/question")
    public String saveQuestion(@Valid UserQuestionDTO userQuestionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "userQuestion";
        }
        usersQuestionService.save(userQuestionDTO);
        return "redirect:/";
    }

}
