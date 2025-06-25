package com.laibraryManagement.LaibraryManagementProject.controller;

import com.laibraryManagement.LaibraryManagementProject.advice.ApiResponse;
import com.laibraryManagement.LaibraryManagementProject.dto.BookDTO;
import com.laibraryManagement.LaibraryManagementProject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "book")
public class BookController {

    BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(path = "test")
    public ResponseEntity<ApiResponse<String>> testServer(){
        return ResponseEntity.ok(new ApiResponse<>("Server Tested Sucessfully"));
    }

    @GetMapping(path = "getbooks")
    public ResponseEntity<ApiResponse<List<BookDTO>>> getAllBookes(){
        return ResponseEntity.ok(new ApiResponse<>(service.getBook()));
    }

    @PostMapping(path = "addbooks")
    public ResponseEntity<ApiResponse<BookDTO>> addBooks(@RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(new ApiResponse<>(service.addBook(bookDTO)));
    }

    @GetMapping(path = "findById/{id}")
    public  ResponseEntity<ApiResponse<BookDTO>> findById(@PathVariable int id){
        return ResponseEntity.ok(new ApiResponse<>(service.addBook(service.findById(id))));
    }

    @PutMapping("updateUser/{id}")
    public  ResponseEntity<ApiResponse<BookDTO>> updateUser(@PathVariable int id, @RequestBody Map<String, Object> update) {
        return ResponseEntity.ok(new ApiResponse<>(service.updateUser(update, id)));
    }

    @DeleteMapping("removeBook/{id}")
    public ResponseEntity<ApiResponse<BookDTO>> removeBook(@PathVariable int id){
        return ResponseEntity.ok(new ApiResponse<>(service.removeBook(id)));
    }
}
