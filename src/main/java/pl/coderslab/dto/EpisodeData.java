package pl.coderslab.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.model.CrewMember;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeData {
    private String _id;
    private String title;
    private String description;
    private CrewMemberData director;
    private CrewMemberData writer;


}
