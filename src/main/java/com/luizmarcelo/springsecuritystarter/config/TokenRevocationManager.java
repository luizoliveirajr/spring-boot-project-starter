package com.luizmarcelo.springsecuritystarter.config;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TokenRevocationManager {
    private Set<String> revokedTokens = new HashSet<>();
    public void revokeToken(String refreshToken) {
        revokedTokens.add(refreshToken);
    }

    public boolean isTokenRevoked(String refreshToken) {
        return revokedTokens.contains(refreshToken);
    }

    public void clearExpiredTokens() {
        // Implemente a lógica para limpar tokens expirados do conjunto
        // Você pode usar uma tarefa agendada ou um método separado para limpar periodicamente o conjunto
    }
}
