package com.ziros.studyAI.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "studyAIsecret123";
    private final long EXPIRATION_MS = 1000 * 60 * 60 * 10; // 10 horas

    public String generateToken(String email, Long userId) {
        return Jwts.builder()
                .claim("id", userId)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
