package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.coderslab.model.CurrentQuiz;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class QuizService {
    private UserService userService;

    public void checkAnswer(HttpSession session, String answer){
        CurrentQuiz currentQuiz =(CurrentQuiz)session.getAttribute("currentQuiz");
        currentQuiz.checkAnswer(answer);
    }
    public void nextQuestion(HttpSession session){
        CurrentQuiz currentQuiz =(CurrentQuiz)session.getAttribute("currentQuiz");
        currentQuiz.nextQuestion();
    }

    public void endQuiz(HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String login = ((UserDetails) principal).getUsername();
            CurrentQuiz currentQuiz =(CurrentQuiz)session.getAttribute("currentQuiz");

            userService.updatePoints(login,currentQuiz.getPoints());

        }
        session.removeAttribute("currentQuiz");

    }

}
