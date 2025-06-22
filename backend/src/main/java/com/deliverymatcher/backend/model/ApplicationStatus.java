package com.deliverymatcher.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApplicationStatus {

    STAND_BY,
    ACCEPTED,
    REFUSED;

    @JsonCreator
    public static ApplicationStatus fromString (String value) {
        try {
            return ApplicationStatus.valueOf(value.toUpperCase());
        }
        catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String getValue() {
        return name();
    }

}
