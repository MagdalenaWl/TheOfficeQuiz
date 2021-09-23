package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login=:login")
    User findFirstByLogin(String login);

    @Query(value = "SELECT * FROM users u WHERE last_game>=:start ORDER BY points_in_month/games_in_month DESC LIMIT 10", nativeQuery = true)
    List<User> findBest(LocalDate start);

    boolean existsByLogin(String login);
}
