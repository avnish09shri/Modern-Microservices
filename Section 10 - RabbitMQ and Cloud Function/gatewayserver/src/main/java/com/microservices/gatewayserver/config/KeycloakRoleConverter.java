package com.microservices.gatewayserver.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realm_access = (Map<String, Object>) source.getClaims().get("realm_access");
        if(Objects.isNull(realm_access) || realm_access.isEmpty()) {
            return new ArrayList<>();
        }

        return ((List<String>) realm_access.get("roles")).stream().map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
