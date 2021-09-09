package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.login=:login")
    User findFirstByLogin(String login);

}
