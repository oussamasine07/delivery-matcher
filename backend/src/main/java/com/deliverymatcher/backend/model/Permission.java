package com.deliverymatcher.backend.model;

public enum Permission {

    DRIVER_READ("driver:read"),
    DRIVER_CREATE("driver:create"),
    DRIVER_UPDATE("driver:update"),
    DRIVER_DELETE("driver:delete"),
    SENDER_READ("sender:read"),
    SENDER_CREATE("sender:create"),
    SENDER_UPDATE("sender:update"),
    SENDER_DELETE("sender:delete"),
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete");

    private final String permission;

    Permission (
            String permission
    ) {
        this.permission = permission;
    }




}
