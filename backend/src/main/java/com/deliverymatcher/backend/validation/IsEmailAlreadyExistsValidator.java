package com.deliverymatcher.backend.validation;

import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class IsEmailAlreadyExistsValidator implements ConstraintValidator<IsEmailAlreadyExists, Object> {

    private final UserService userService;

    public IsEmailAlreadyExistsValidator (
            final UserService userService
    ) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        try {
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl( obj );
            String type = (String) beanWrapper.getPropertyValue("type");
            String email = (String) beanWrapper.getPropertyValue("email");

            User found = null;

            switch (type) {
                case "sender":
                    found = userService.findSenderByEmail( email );
                    break;
                case "driver":
                    found = userService.findDriverByEmail( email );
                    break;
                case "admin":
                    found = userService.findAdminByEmail( email );
                    break;
                default:
                    return true;
            }

            return found == null;
        }
        catch (Exception e) {
            return true;
        }
    }
}









