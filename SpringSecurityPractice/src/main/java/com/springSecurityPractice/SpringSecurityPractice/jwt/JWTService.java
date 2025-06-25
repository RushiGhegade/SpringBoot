package com.springSecurityPractice.SpringSecurityPractice.jwt;

import com.springSecurityPractice.SpringSecurityPractice.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

@Service
public class JWTService {

    @Value("${jwt.secreteKey}")
    private String JwtsecreteKey;

    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(JwtsecreteKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserEntity user){

        return Jwts
                .builder()
                .subject(String.valueOf(user.getId()))
                .claim("email",user.getEmail())
                .claim("roles", Set.of("ADMIN","USER"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(getSecretKey())
                .compact();

    }

    public int getUserIdFromToken(String token){

        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Integer.valueOf(claims.getSubject());

    }

}
