package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
public class UserQuestionDTO {
    @NotBlank
    private String question;
    @NotBlank
    private String correctAnswer;
    @NotEmpty
    private List<@NotBlank String> answers;
}
