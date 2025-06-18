package com.deliverymatcher.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalTime;

public class NextTimeValidator implements ConstraintValidator<NextTime, LocalTime> {
    @Override
    public boolean isValid(LocalTime localTime, ConstraintValidatorContext constraintValidatorContext) {
        LocalTime currentTime = LocalTime.now();
        return !localTime.isBefore(currentTime);
    }
}
