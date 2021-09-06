package pl.coderslab.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
@NoArgsConstructor
@Getter
@Setter
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apiId;
    private String title;
    @Column(length = 1024)
    private String description;

    @ManyToOne
    private CrewMember director;
    @ManyToOne
    private CrewMember writer;


}
