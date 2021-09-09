package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.CrewMember;
import pl.coderslab.service.CrewMemberService;
import pl.coderslab.service.EpisodeService;
import pl.coderslab.service.QuizService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/quiz/directors")
@AllArgsConstructor
public class DirectorsQuizController {
    private EpisodeService episodeService;
    private CrewMemberService crewMemberService;
    private QuizService quizService;
    private static int NUMBER_OF_QUESTIONS = 5;

    @ModelAttribute("crew")
    public Collection<CrewMember> crew(){
        return this.crewMemberService.findAll();
    }

    @RequestMapping("")
    public String quotes(HttpSession session) {
        if (session.getAttribute("currentQuiz") == null) {
            session.setAttribute("currentQuiz", episodeService.makeDirectorsQuiz(NUMBER_OF_QUESTIONS));
        }else {
            quizService.nextQuestion(session);
        }
        return "whodirectedit";
    }

    @RequestMapping("/endQuiz")
    public String result(HttpSession session){
        session.removeAttribute("currentQuiz");
        return "redirect:/";
    }

    @PostMapping("")
    public String checkAnswer(HttpSession session, @RequestParam String answer) {
        quizService.checkAnswer(session,answer);
        return "directorResult";
    }

}
