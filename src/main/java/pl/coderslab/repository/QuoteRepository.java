package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Quote;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    boolean existsQuoteByApiId(String apiId);

    List<Quote> findAll();

    List<Quote> findAllByApproved(boolean approved);

    Quote findFirstByContent(String content);

    boolean existsByContent(String content);

}
