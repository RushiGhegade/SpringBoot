package com.Homework.Homework.Controller;

import com.Homework.Homework.HomeWorkDTO.homeworkDTO;
import com.Homework.Homework.ServiceRepository.ServiceRepo;
import com.Homework.Homework.config.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/HomeWork")
public class HomeworkController {

    private ServiceRepo serviceRepo;

    public HomeworkController(ServiceRepo serviceRepo) {
        System.out.println("In Controller Constructor");
        this.serviceRepo = serviceRepo;
    }

    @GetMapping("/Test")
    public ResponseEntity<ApiResponse<String>> testServer() {
        String response = serviceRepo.TestServer();
        ApiResponse<String> apiResponse = new ApiResponse<>("Server test successful", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/GetUserById/{id}")
    public ResponseEntity<ApiResponse<homeworkDTO>> GetUserById(@PathVariable Integer id) {
        homeworkDTO user = serviceRepo.GetUserById(id);
        ApiResponse<homeworkDTO> apiResponse = new ApiResponse<>("User retrieved successfully", user);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/GetAppUser")
    public ResponseEntity<ApiResponse<List<homeworkDTO>>> findAllUser() {
        List<homeworkDTO> users = serviceRepo.getAllUser();
        ApiResponse<List<homeworkDTO>> apiResponse = new ApiResponse<>("All users retrieved successfully", users);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(name = "/AddUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<homeworkDTO>> addUser(@RequestBody @Valid homeworkDTO obj) {
        homeworkDTO addedUser = serviceRepo.addUser(obj);
        ApiResponse<homeworkDTO> apiResponse = new ApiResponse<>("User added successfully", addedUser);
        return ResponseEntity.ok(apiResponse);
    }
}