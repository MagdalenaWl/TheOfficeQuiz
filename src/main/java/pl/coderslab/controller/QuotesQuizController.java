package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Character;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.QuizService;
import pl.coderslab.service.QuoteService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/quiz/quotes")
@AllArgsConstructor
@Slf4j
public class QuotesQuizController {
    private QuoteService quoteService;
    private CharacterService characterService;
    private QuizService quizService;
    private UserService userService;
    private static int NUMBER_OF_QUESTIONS = 5;

    @ModelAttribute("characters")
    public Collection<Character> characters(){ return this.characterService.findAll();}

    @RequestMapping("")
    public String quotes(HttpSession session) {
        if (session.getAttribute("currentQuiz") == null) {
            session.setAttribute("currentQuiz", quoteService.makeQuiz(NUMBER_OF_QUESTIONS));
        }else {
            quizService.nextQuestion(session);
        }
        return "whosaidit";
    }

    @RequestMapping("/endQuiz")
    public String result(HttpSession session){
        quizService.endQuiz(session);
        return "redirect:/";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String checkAnswer(HttpSession session, @RequestParam String answer) {
        quizService.checkAnswer(session,answer);
        return "quoteResult";
    }

}
