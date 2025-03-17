package com.SpringSecurityexample.SpringSecurityexample.controller;

import com.SpringSecurityexample.SpringSecurityexample.dto.LoginDTO;
import com.SpringSecurityexample.SpringSecurityexample.dto.SignUpDTO;
import com.SpringSecurityexample.SpringSecurityexample.dto.SignUpUserDTO;
import com.SpringSecurityexample.SpringSecurityexample.globalresponsehandeler.ResponseApi;
import com.SpringSecurityexample.SpringSecurityexample.repository.LoginUserRepository;
import com.SpringSecurityexample.SpringSecurityexample.service.JwtService;
import com.SpringSecurityexample.SpringSecurityexample.service.LoginUserService;
import com.SpringSecurityexample.SpringSecurityexample.service.authService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private authService authservice;


    @PostMapping(path = "login")
    public ResponseEntity<ResponseApi<String>> loginUser(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response){



        String token =  authservice.loginUser(loginDTO);

        Cookie cookie = new Cookie("token",token);

        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        return ResponseEntity.ok(new ResponseApi<>(token));

    }

    @PostMapping(path = "signUp")
    public ResponseEntity<ResponseApi<SignUpUserDTO>> signUpUser(@RequestBody SignUpDTO signUpDTO){

        SignUpUserDTO signUpUserDTO = loginUserService.signUpUser(signUpDTO);

        return ResponseEntity.ok(new ResponseApi<>(signUpUserDTO));

    }

}
