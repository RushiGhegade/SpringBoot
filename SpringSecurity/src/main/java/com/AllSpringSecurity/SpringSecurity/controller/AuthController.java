package com.AllSpringSecurity.SpringSecurity.controller;

import com.AllSpringSecurity.SpringSecurity.auth.LoginDto;
import com.AllSpringSecurity.SpringSecurity.auth.SignUpDto;
import com.AllSpringSecurity.SpringSecurity.auth.UserDto;
import com.AllSpringSecurity.SpringSecurity.service.AuthService;
import com.AllSpringSecurity.SpringSecurity.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<String> testServer(){
        return ResponseEntity.ok("Auth Request Tested");
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        System.out.println(signUpDto.getName());
        return ResponseEntity.ok(userService.signUpUser(signUpDto));

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto , HttpServletRequest request , HttpServletResponse response){

        String token =  authService.loginUser(loginDto);

        // create A Cookie
        Cookie cookie = new Cookie("token",token);

        // Set a cookie
        cookie.setHttpOnly(true);

        // Send Back to Frontend Cookie
        response.addCookie(cookie);

         return ResponseEntity.ok(token);

    }

}
