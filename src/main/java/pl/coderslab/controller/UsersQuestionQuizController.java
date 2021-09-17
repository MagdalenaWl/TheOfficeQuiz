package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.service.QuizService;
import pl.coderslab.service.UsersQuestionService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/quiz/question")
@AllArgsConstructor
@Slf4j
public class UsersQuestionQuizController {
    private UsersQuestionService usersQuestionService;
    private QuizService quizService;
    private static int NUMBER_OF_QUESTIONS = 5;

    @RequestMapping("")
    public String quotes(HttpSession session) {
        if (session.getAttribute("currentQuiz") == null) {
            session.setAttribute("currentQuiz", usersQuestionService.makeQuiz(NUMBER_OF_QUESTIONS));
        }
        return "usersQuestionQuiz";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkAnswer(HttpSession session, @RequestParam String answer) {
        quizService.checkAnswer(session, answer);
        return "questionsResult";
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
            return "redirect:/quiz/question/endQuiz";
        }
        CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
        if (currentQuiz.isAlreadyChecked()) {
            return "redirect:/quiz/question/next";
        }
        return "redirect:/quiz/question";
    }

    @RequestMapping(value = "/next")
    public String nextQuestion(HttpSession session) {
        quizService.nextQuestion(session);
        return "redirect:/quiz/question";
    }

}
