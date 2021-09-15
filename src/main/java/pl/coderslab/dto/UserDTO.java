package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.validator.LoginExistsConstraint;
import pl.coderslab.validator.PasswordsEqualConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@PasswordsEqualConstraint(message = "passwords are not equal")
@LoginExistsConstraint(message = "login is already being used")
public class UserDTO {
    @NotBlank
    private String login;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repassword;
}
