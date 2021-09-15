package pl.coderslab.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.BestUsers;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;
    RoleService roleService;

    public void save(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        user.setGames(0);
        user.setGamesInMonth(0);
        user.setPoints(0);
        user.setPointsInMonth(0);
        user.addRole(roleService.findByName("USER"));
        userRepository.save(user);

    }

    @Transactional
    public User findByLogin(String login) {

        User user = userRepository.findFirstByLogin(login);
        user.getRoles().size();
        return user;
    }

    public boolean loginExists(String login) {
        return userRepository.existsByLogin(login);
    }

    public void updatePoints(User user, int points) {
        user.setPoints(user.getPoints() + points);
        user.setGames(user.getGames() + 1);
        if (user.getLastGame() == null) {
            user.setPointsInMonth(points);
            user.setGamesInMonth(1);
        } else if (user.getLastGame().getMonth().equals(LocalDate.now().getMonth())) {
            user.setPointsInMonth(user.getPointsInMonth() + points);
            user.setGamesInMonth(user.getGamesInMonth() + 1);
        } else {
            user.setPointsInMonth(points);
            user.setGamesInMonth(1);
        }
        user.setLastGame(LocalDate.now());
        userRepository.save(user);
    }

    public List<BestUsers> findBest() {
        List<User> users = userRepository.findBest(LocalDate.now().withDayOfMonth(1));
        return users.stream()
                .map(user -> new BestUsers(user.getLogin(), user.getMonthAvg()))
                .collect(Collectors.toList());
    }

    public User findLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String login = ((UserDetails) principal).getUsername();
            return this.findByLogin(login);
        }
        return null;
    }

    public boolean playedThisMonth(User user) {
        if (user.getLastGame() == null) {
            return false;
        }
        return !user.getLastGame().isBefore(LocalDate.now().withDayOfMonth(1));
    }

}
