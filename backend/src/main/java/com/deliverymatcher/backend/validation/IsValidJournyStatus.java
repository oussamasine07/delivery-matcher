package com.deliverymatcher.backend.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsValidJournyStatusValidator.class)
public @interface IsValidJournyStatus {

    String message() default "allowed statuses : STAND_BY, ON_ROAD, BREAK, ON_STATION, ARRIVED";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
