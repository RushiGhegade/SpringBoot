package com.SpringSecurityexample.SpringSecurityexample.service;

import com.SpringSecurityexample.SpringSecurityexample.entity.LoginUserEntity;
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
    private String  securityKey;

    private SecretKey getSecreteKey(){
        return Keys.hmacShaKeyFor(securityKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(LoginUserEntity user){
        return Jwts
                .builder()
                .subject(String.valueOf(user.getId()))
                .claim("email",user.getEmail())
                .claim("roles", Set.of("ADMIN","USER"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(getSecreteKey())
                .compact();
    }

    public Integer getUserIdFromToken(String token){

        Claims claims = Jwts
                .parser()
                .verifyWith(getSecreteKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Integer.valueOf(claims.getSubject());
    }


}
