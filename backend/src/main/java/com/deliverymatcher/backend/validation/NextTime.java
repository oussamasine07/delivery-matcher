package com.deliverymatcher.backend.validation;


import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NextTime {
    String message() default "Please enter a valid time that is current time or later.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
