package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.QuoteData;
import pl.coderslab.model.Question;
import pl.coderslab.model.CurrentQuiz;
import pl.coderslab.model.Quote;
import pl.coderslab.repository.QuoteRepository;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class QuoteService {
    QuoteRepository quoteRepository;
    CharacterService characterService;

    @Transactional
    public void save(QuoteData quoteData) {
        if (!quoteRepository.existsQuoteByApiId(quoteData.get_id())) {
            Quote quote = new Quote();
            quote.setApiId(quoteData.get_id());
            quote.setContent(quoteData.getContent());
            quote.setCharacter(characterService.findByApiId(quoteData.getCharacter().get_id()));
            quoteRepository.save(quote);
        }
    }

    public List<Quote> findRandom(int numberOfQuestions) {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.size() > numberOfQuestions) {
            Collections.shuffle(quotes);
            return quotes.subList(0, numberOfQuestions);
        }
        return quotes;

    }


    public CurrentQuiz makeQuiz(int numberOfQuestions) {
        List<Quote> quotes = this.findRandom(numberOfQuestions);
        CurrentQuiz currentQuiz = new CurrentQuiz();
        currentQuiz.setPath("/quiz/quotes");
        for (Quote quote : quotes) {
            Question question = new Question(quote.getContent());
            question.addAnswer(quote.getCharacter().getFullName(), true);
            currentQuiz.addQuestion(question);
        }
        return currentQuiz;
    }
}
