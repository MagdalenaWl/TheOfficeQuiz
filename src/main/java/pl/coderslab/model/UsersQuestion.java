package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name = "users_question")
public class UsersQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private char correctAnswer;
}
