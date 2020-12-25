package com.mapsa.model;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER, ADMIN, VIP;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
