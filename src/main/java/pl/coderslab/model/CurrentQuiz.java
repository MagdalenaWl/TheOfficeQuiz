package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CurrentQuiz {
    private List<Question> questions = new ArrayList<>();
    private int points = 0;
    private int currentQuestionIndex = 0;
    private boolean currentCorrect;
    private String path;
    private boolean alreadyChecked = false;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getCurrentQuestion() {
        return questions.get(currentQuestionIndex).getQuestion();
    }

    public String getCurrentCorrectAnswer() {
        return questions.get(currentQuestionIndex).getTrueAnswer();
    }

    public int getSize() {
        return questions.size();
    }
}
