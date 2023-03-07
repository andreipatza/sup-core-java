package com.sup.core.authentication.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sup.core.authentication.model.JwtPrincipal;
import com.sup.core.authentication.model.TokenResolver;

import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityHelper {

    private SecurityHelper() {
    }

    public static JwtPrincipal getPrincipal() {
        return (JwtPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void setAuthenticationUsingJwt(String jwtToken) {
        Authentication authentication = SpringContextHelper.getBean(TokenResolver.class).resolve(jwtToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
