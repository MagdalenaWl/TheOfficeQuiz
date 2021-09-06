package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.QuoteData;
import pl.coderslab.model.Quote;
import pl.coderslab.repository.QuoteRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class QuoteService {
    QuoteRepository quoteRepository;
    CharacterService characterService;
    @Transactional
    public void save(QuoteData quoteData){
        if(!quoteRepository.existsQuoteByApiId(quoteData.get_id())){
            Quote quote = new Quote();
            quote.setApiId(quoteData.get_id());
            quote.setContent(quoteData.getContent());
            quote.setCharacter(characterService.findByApiId(quoteData.getCharacter().get_id()));
            quoteRepository.save(quote);
        }
    }
}
