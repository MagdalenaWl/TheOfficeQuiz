package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
@Getter
@Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apiId;
    @Column(length = 1024)
    String content;

    @ManyToOne
    Character character;
}
