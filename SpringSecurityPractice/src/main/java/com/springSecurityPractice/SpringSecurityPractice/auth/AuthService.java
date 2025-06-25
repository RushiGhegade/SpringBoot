package com.springSecurityPractice.SpringSecurityPractice.auth;

import com.springSecurityPractice.SpringSecurityPractice.dto.LoginDTO;
import com.springSecurityPractice.SpringSecurityPractice.entity.UserEntity;
import com.springSecurityPractice.SpringSecurityPractice.jwt.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public String loginUser(LoginDTO loginDTO) {



        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword())
        );

        UserEntity user =  (UserEntity) authentication.getPrincipal();

        return jwtService.generateToken(user);

    }

}
