package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.CurrentQuiz;

import javax.servlet.http.HttpSession;

@Service
public class QuizService {
    public void checkAnswer(HttpSession session, String answer){
        CurrentQuiz currentQuiz =(CurrentQuiz)session.getAttribute("currentQuiz");
        currentQuiz.checkAnswer(answer);
    }
    public void nextQuestion(HttpSession session){
        CurrentQuiz currentQuiz =(CurrentQuiz)session.getAttribute("currentQuiz");
        currentQuiz.nextQuestion();
    }
}
