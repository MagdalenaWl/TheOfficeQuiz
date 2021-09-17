package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.UsersAnswer;
import pl.coderslab.model.UsersQuestion;

import java.util.List;

@Repository
public interface UsersAnswerRepository extends JpaRepository<UsersAnswer, Long> {

    List<UsersAnswer> findAllByQuestion(UsersQuestion question);

}
