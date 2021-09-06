package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
    boolean existsQuoteByApiId(String apiId);

}
