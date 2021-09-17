package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.UsersQuestion;

import java.util.List;

@Repository
public interface UsersQuestionRepository extends JpaRepository<UsersQuestion, Long> {

    List<UsersQuestion> findAllByApproved(boolean approved);
}
