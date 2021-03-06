package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.model.User;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class QuizService {
    private UserService userService;

    public void checkAnswer(HttpSession session, String answer) {
        CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
        currentQuiz.setCurrentCorrect(currentQuiz.getCurrentCorrectAnswer().equals(answer));
        if (currentQuiz.isCurrentCorrect()) {
            currentQuiz.setPoints(currentQuiz.getPoints() + 1);
        }
        currentQuiz.setAlreadyChecked(true);
    }

    public void nextQuestion(HttpSession session) {
        CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
        currentQuiz.setCurrentQuestionIndex(currentQuiz.getCurrentQuestionIndex() + 1);
        currentQuiz.setAlreadyChecked(false);
    }

    public void endQuiz(HttpSession session) {
        User loggedUser = userService.findLoggedInUser();
        if (loggedUser != null) {
            CurrentQuiz currentQuiz = (CurrentQuiz) session.getAttribute("currentQuiz");
            userService.updatePoints(loggedUser, currentQuiz.getPoints());
        }
        session.removeAttribute("currentQuiz");
    }

}
