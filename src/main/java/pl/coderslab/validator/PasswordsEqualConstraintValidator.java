package pl.coderslab.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.coderslab.dto.UserDTO;

public class PasswordsEqualConstraintValidator implements
        ConstraintValidator<PasswordsEqualConstraint, Object> {

    @Override
    public void initialize(PasswordsEqualConstraint arg0) {
    }

    @Override
    public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
        UserDTO user = (UserDTO) candidate;
        return user.getPassword().equals(user.getRepassword());
    }
}