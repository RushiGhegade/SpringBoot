package com.SpringSecurityexample.SpringSecurityexample.service;

import com.SpringSecurityexample.SpringSecurityexample.dto.LoginDTO;
import com.SpringSecurityexample.SpringSecurityexample.entity.LoginUserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.management.remote.JMXAuthenticator;

@Service
public class authService {

    private JwtService jwtService;
    private AuthenticationManager authenticationManager;


    public authService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String loginUser(LoginDTO loginDTO) {

        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),loginDTO.getPassword()
                )
        );

        LoginUserEntity loginUserEntity =(LoginUserEntity) authentication.getPrincipal();

        return jwtService.generateToken(loginUserEntity);

    }

}
