package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Question {
    private String question;
    private List<Answer> answers = new ArrayList<>();


    public void addAnswer(String answer, boolean isTrue) {
        answers.add(new Answer(answer, isTrue));
    }

    public Question(String question) {
        this.question = question;
    }

    public String getTrueAnswer() {
        return answers.stream().filter(answer -> answer.isTrue()).findFirst().get().getAnswer();
    }
}
