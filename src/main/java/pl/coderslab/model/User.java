package pl.coderslab.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private int games;
    private int points;
    private LocalDate lastGame;
    private int gamesInMonth;
    private int pointsInMonth;
}
