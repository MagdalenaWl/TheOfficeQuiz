package pl.coderslab.validator;


import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class LoginExistsConstraintValidator implements
        ConstraintValidator<LoginExistsConstraint, Object> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(LoginExistsConstraint arg0) {
    }

    @Override
    public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
        UserDTO user = (UserDTO) candidate;
        return !userService.loginExists(user.getLogin());
    }
}