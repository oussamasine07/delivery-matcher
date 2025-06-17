package com.deliverymatcher.backend.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface UserType {

    String message() default "invalid user type, only DRIVER OR SENDER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
