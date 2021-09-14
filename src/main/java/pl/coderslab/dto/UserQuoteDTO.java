package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.model.Character;

@Getter
@Setter
@ToString
public class UserQuoteDTO {
    private String content;
    private Character character;
}
