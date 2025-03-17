package com.SpringSecurityexample.SpringSecurityexample.controller;

import com.SpringSecurityexample.SpringSecurityexample.dto.UserDTO;
import com.SpringSecurityexample.SpringSecurityexample.globalresponsehandeler.ResponseApi;
import com.SpringSecurityexample.SpringSecurityexample.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ResponseApi<String>> TestServer(){
        return ResponseEntity.ok(new ResponseApi<>("User Path test Successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){

        UserDTO userDTO =  userService.getUserById(id);

        return ResponseEntity.ok(userDTO);

    }

    @GetMapping(path = "/getAll")
    public ResponseEntity< List<UserDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());

    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<UserDTO> addUser( @RequestBody UserDTO userDTO){

        UserDTO userDTO1 = userService.addUser(userDTO);

        return ResponseEntity.ok(userDTO1);

    }

}
