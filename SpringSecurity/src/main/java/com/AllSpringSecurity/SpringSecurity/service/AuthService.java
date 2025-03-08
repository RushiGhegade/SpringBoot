package com.AllSpringSecurity.SpringSecurity.service;

import com.AllSpringSecurity.SpringSecurity.auth.LoginDto;
import com.AllSpringSecurity.SpringSecurity.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String loginUser(LoginDto loginDto){

        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

        UserEntity user = (UserEntity) authentication.getPrincipal();

        return jwtService.generateUserToken(user);

    }

}
