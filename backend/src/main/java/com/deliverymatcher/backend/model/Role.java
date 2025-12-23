package com.deliverymatcher.backend.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.deliverymatcher.backend.model.Permission.*;

public enum Role {

    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    DRIVER_READ,
                    DRIVER_CREATE,
                    DRIVER_UPDATE,
                    DRIVER_DELETE,
                    SENDER_CREATE,
                    SENDER_READ,
                    SENDER_UPDATE,
                    SENDER_DELETE
            )
    ),
    SENDER(
            Set.of(
                    SENDER_CREATE,
                    SENDER_READ,
                    SENDER_UPDATE,
                    SENDER_DELETE
            )
    ),
    DRIVER(
            Set.of(
                    SENDER_CREATE,
                    SENDER_READ,
                    SENDER_UPDATE,
                    SENDER_DELETE
            )
    );

    private final Set<Permission> permissions;

    Role (
            final Set<Permission> permissions
    ) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities () {
        var permissions =  getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
