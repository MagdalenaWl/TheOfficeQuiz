package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CurrentQuiz {
    private List<Question> questions=new ArrayList<>();
    private int points=0;
    private int currentQuestionIndex=0;
    boolean currentCorrect;

    public void addQuestion(Question question){
        questions.add(question);
    }
    public void nextQuestion(){
        currentQuestionIndex+=1;
    }
    public void checkAnswer(String answer){
        this.currentCorrect =this.getCurrentCorrectAnswer().equals(answer);
        if(this.currentCorrect){
            points+=1;
        }
    }
    public String getCurrentQuestion(){
        return questions.get(currentQuestionIndex).getQuestion();
    }
    public String getCurrentCorrectAnswer(){
        return questions.get(currentQuestionIndex).getTrueAnswer();
    }
}
