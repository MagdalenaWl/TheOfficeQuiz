package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserQuestionDTO;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.model.Question;
import pl.coderslab.model.UsersAnswer;
import pl.coderslab.model.UsersQuestion;
import pl.coderslab.repository.UsersAnswerRepository;
import pl.coderslab.repository.UsersQuestionRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersQuestionService {
    UsersQuestionRepository usersQuestionRepository;
    UsersAnswerRepository usersAnswerRepository;

    @Transactional
    public void save(UserQuestionDTO userQuestionDTO) {
        UsersQuestion usersQuestion = new UsersQuestion();
        usersQuestion.setQuestion(userQuestionDTO.getQuestion());
        usersQuestion.setApproved(false);
        usersQuestionRepository.save(usersQuestion);
        UsersAnswer correct = new UsersAnswer();
        correct.setAnswer(userQuestionDTO.getCorrectAnswer());
        correct.setQuestion(usersQuestion);
        correct.setTrue(true);
        usersAnswerRepository.save(correct);
        for (String answer : userQuestionDTO.getAnswers()) {
            UsersAnswer inCorrect = new UsersAnswer();
            inCorrect.setAnswer(answer);
            inCorrect.setQuestion(usersQuestion);
            inCorrect.setTrue(false);
            usersAnswerRepository.save(inCorrect);
        }
    }


    public List<UsersQuestion> findAllByApproved(boolean approved) {
        return usersQuestionRepository.findAllByApproved(approved);
    }

    public List<UsersQuestion> findRandom(int numberOfQuestions) {
        List<UsersQuestion> questions = this.findAllByApproved(true);
        if (questions.size() > numberOfQuestions) {
            Collections.shuffle(questions);
            return questions.subList(0, numberOfQuestions);
        }
        return questions;
    }


    public CurrentQuiz makeQuiz(int numberOfQuestions) {
        List<UsersQuestion> questions = this.findRandom(numberOfQuestions);
        CurrentQuiz currentQuiz = new CurrentQuiz();
        currentQuiz.setPath("/quiz/question");
        for (UsersQuestion userQuestion : questions) {
            currentQuiz.addQuestion(this.makeQuestion(userQuestion));
        }
        return currentQuiz;
    }

    public Question makeQuestion(UsersQuestion userQuestion) {
        Question question = new Question(userQuestion.getQuestion());
        question.setId(userQuestion.getId());
        List<UsersAnswer> answers = usersAnswerRepository.findAllByQuestion(userQuestion);
        Collections.shuffle(answers);
        for (UsersAnswer answer : answers) {
            question.addAnswer(answer.getAnswer(), answer.isTrue());
        }
        return question;
    }

    public List<Question> findAllNotApproved() {
        return this.findAllByApproved(false).stream()
                .map(usersQuestion -> this.makeQuestion(usersQuestion))
                .collect(Collectors.toList());
    }

    public void approve(Long id) {
        UsersQuestion usersQuestion = usersQuestionRepository.findById(id).get();
        if (usersQuestion != null) {
            usersQuestion.setApproved(true);
            usersQuestionRepository.save(usersQuestion);
        }
    }
}
