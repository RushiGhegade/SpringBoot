package com.springSecurityPractice.SpringSecurityPractice.controller;

import com.springSecurityPractice.SpringSecurityPractice.auth.AuthService;
import com.springSecurityPractice.SpringSecurityPractice.dto.LoginDTO;
import com.springSecurityPractice.SpringSecurityPractice.dto.SignUpDTO;
import com.springSecurityPractice.SpringSecurityPractice.dto.UserDTO;
import com.springSecurityPractice.SpringSecurityPractice.responseHandler.ApiResponse;
import com.springSecurityPractice.SpringSecurityPractice.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/signUp")
    public UserDTO SignUpUser(@RequestBody SignUpDTO signUpDTO){

        return userService.signUpUser(signUpDTO);

    }

    @PostMapping(path = "/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDTO loginDTO, HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){

        String token =  authService.loginUser(loginDTO);

        Cookie cookie = new Cookie("token",token);

        cookie.setHttpOnly(true);

        httpServletResponse.addCookie(cookie);

        return ResponseEntity.ok(new ApiResponse(token));
    }

}
