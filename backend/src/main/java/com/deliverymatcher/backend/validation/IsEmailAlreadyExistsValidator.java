package com.deliverymatcher.backend.validation;

import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class IsEmailAlreadyExistsValidator implements ConstraintValidator<IsEmailAlreadyExists, String> {

    private final UserService userService;

    public IsEmailAlreadyExistsValidator (
            final UserService userService
    ) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        User found = userService.findUserByEmail( email );
        return found == null;
//        try {
//            BeanWrapperImpl beanWrapper = new BeanWrapperImpl( obj );
//            String type = (String) beanWrapper.getPropertyValue("type");
//            String email = (String) beanWrapper.getPropertyValue("email");
//
//            System.out.println(email);
//
//            User found = userService.findUserByEmail( email );
//
//            switch (type) {
//                case "sender":
//                    found = userService.findSenderByEmail( email );
//                    break;
//                case "driver":
//                    found = userService.findDriverByEmail( email );
//                    break;
//                case "admin":
//                    found = userService.findAdminByEmail( email );
//                    break;
//                default:
//                    return true;
//            }
//
//            return found == null;
//        }
//        catch (Exception e) {
//            return true;
//        }
    }
}









