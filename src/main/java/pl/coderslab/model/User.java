package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;
    private int games;
    private int points;
    private LocalDate lastGame;
    private int gamesInMonth;
    private int pointsInMonth;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public String getAvg() {
        if (this.games == 0) {
            return "0";
        }
        return String.format("%.2f", (double) this.points / this.games);
    }

    public String getMonthAvg() {
        return String.format("%.2f", (double) this.pointsInMonth / this.gamesInMonth);
    }


}
