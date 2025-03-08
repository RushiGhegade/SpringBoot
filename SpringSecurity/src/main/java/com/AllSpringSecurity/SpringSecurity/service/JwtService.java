package com.AllSpringSecurity.SpringSecurity.service;

import com.AllSpringSecurity.SpringSecurity.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

@Service
public class JwtService {

    @Value("${jwt.secreteKey}")
    private String jwtSecurityKey;


    public SecretKey getSecurityKey(){
        return Keys.hmacShaKeyFor(jwtSecurityKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateUserToken(UserEntity user){

        return Jwts
                .builder()
                .subject(String.valueOf(user.getId()))
                .claim("email",user.getEmail())
                .claim("roles", Set.of("ADMIN","USER"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 1000*120))
                .signWith(getSecurityKey())
                .compact();

    }


    public Integer generateUserIdFromToken(String token){

        Claims claims =   Jwts
                .parser()
                .verifyWith(getSecurityKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return  Integer.valueOf(claims.getSubject());

    }

}
