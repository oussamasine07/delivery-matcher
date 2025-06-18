package com.deliverymatcher.backend.validation;

import com.deliverymatcher.backend.model.JournyStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsValidJournyStatusValidator implements ConstraintValidator<IsValidJournyStatus, JournyStatus> {
    @Override
    public boolean isValid(JournyStatus journyStatus, ConstraintValidatorContext constraintValidatorContext) {
        if ( journyStatus == null ) return true;

        return journyStatus == JournyStatus.ON_ROAD
                || journyStatus == JournyStatus.STAND_BY
                || journyStatus == JournyStatus.BREAK
                || journyStatus == JournyStatus.ON_STATION
                || journyStatus == JournyStatus.ARRIVED;
    }
}
