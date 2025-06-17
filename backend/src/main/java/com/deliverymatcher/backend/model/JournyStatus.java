package com.deliverymatcher.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JournyStatus {

    STAND_BY,
    ON_ROAD,
    BREAK,
    ON_STATION,
    ARRIVED;

    @JsonCreator
    public static JournyStatus fromString (String value) {
        try {
            return JournyStatus.valueOf(value.toUpperCase());
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
