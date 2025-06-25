package AllSpringSecurityInOne.AllSpringSecurityInOne.jwt;

import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
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

    @Value("${jwt.security}")
    private String secreteKey;

    public SecretKey generateSecretKey(){
        return Keys.hmacShaKeyFor(secreteKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateAccessToken(UserEntity user){

        return Jwts.builder()
                .subject(String.valueOf(user.getId()))
                .claim("email",user.getEmail())
                .claim("roles", Set.of("ADMIN","USER"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(generateSecretKey())
                .compact();

    }

    public String generateRefreshToken(UserEntity user) {
        return Jwts.builder()
                .subject(String.valueOf(user.getId()))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*60*24*30*6))
                .signWith(generateSecretKey())
                .compact();
    }

    public Integer getUserIdFromToken(String token){

        Claims claims =  Jwts.parser()
                .verifyWith(generateSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Integer.valueOf(claims.getSubject());

    }



}
