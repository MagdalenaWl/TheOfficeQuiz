package pl.coderslab.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;
    RoleService roleService;
    public void save(UserDTO userDTO){
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
    public User findByLogin(String login){

        User user= userRepository.findFirstByLogin(login);
        user.getRoles().size();
        return user;
    }
}
