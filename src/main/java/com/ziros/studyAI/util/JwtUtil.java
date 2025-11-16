package com.ziros.studyAI.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "minha-chave-secreta-super-longa-para-jwt-com-32-bytes";
    private final long EXPIRATION_MS = 1000 * 60 * 60 * 10; // 10 horas
    Key hmacKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email, Long userId) {
        return Jwts.builder()
                .claim("id", userId)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(hmacKey)
                .compact();
    }
}
