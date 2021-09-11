package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Character;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.QuizService;
import pl.coderslab.service.QuoteService;

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
    private static int NUMBER_OF_QUESTIONS = 5;

    @ModelAttribute("characters")
    public Collection<Character> characters() {
        return this.characterService.findAll();
    }

    @RequestMapping("")
    public String quotes(HttpSession session) {
        if (session.getAttribute("currentQuiz") == null) {
            session.setAttribute("currentQuiz", quoteService.makeQuiz(NUMBER_OF_QUESTIONS));
        }
        return "whosaidit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkAnswer(HttpSession session, @RequestParam String answer) {
        quizService.checkAnswer(session, answer);
        return "quoteResult";
    }

    @RequestMapping("/endQuiz")
    public String end(HttpSession session) {
        quizService.endQuiz(session);
        return "redirect:/";
    }

    @RequestMapping("/confirmation")
    public String confirmation() {
        return "confirmation";
    }

    @PostMapping("/confirmation")
    public String confirmation(HttpSession session, @RequestParam String confirm) {
        if (confirm.equalsIgnoreCase("y")) {
            return "redirect:/quiz/quotes/endQuiz";
        }
        CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
        if (currentQuiz.isAlreadyChecked()) {
            return "redirect:/quiz/quotes/next";
        }
        return "redirect:/quiz/quotes";
    }

    @RequestMapping(value = "/next")
    public String nextQuestion(HttpSession session) {
        quizService.nextQuestion(session);
        return "redirect:/quiz/quotes";
    }

}
