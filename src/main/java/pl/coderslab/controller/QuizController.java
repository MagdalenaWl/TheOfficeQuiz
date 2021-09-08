package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Character;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.service.CharacterService;
import pl.coderslab.service.QuizService;
import pl.coderslab.service.QuoteService;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/quiz")
@AllArgsConstructor
@Slf4j
public class QuizController {
    private QuoteService quoteService;
    private CharacterService characterService;
    private QuizService quizService;
    private static int NUMBER_OF_QUESTIONS = 10;

    @ModelAttribute("characters")
    public Collection<Character> characters(){ return this.characterService.findAll();}

    @RequestMapping("/quotes")
    public String quotes(HttpSession session) {
        if (session.getAttribute("currentQuiz") == null) {
            session.setAttribute("currentQuiz", quoteService.makeQuiz(NUMBER_OF_QUESTIONS));
        }else {
            quizService.nextQuestion(session);
        }
        return "whosaidit";
    }

    @RequestMapping("/quotes/endQuiz")
    public String result(HttpSession session){
        session.removeAttribute("currentQuiz");
        return "home";
    }

    @PostMapping("/quotes")
    public String checkAnswer(HttpSession session, @RequestParam String answer) {
        quizService.checkAnswer(session,answer);
        return "partialResult";
    }

}
