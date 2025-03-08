package com.CollageManagementSystem.CollageManagementSystem.Controller;

import com.CollageManagementSystem.CollageManagementSystem.DTO.AdmissionRecordDTO;
import com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend.ApiResponse;
import com.CollageManagementSystem.CollageManagementSystem.Service.AdmissionRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "AdmissionRecord/")
public class AdmissionRecordController {

    private AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }


    @PostMapping(path = "Student/{id}")
    ResponseEntity<ApiResponse> getAdmission(@PathVariable int id){
        AdmissionRecordDTO  result = admissionRecordService.getAdmission(id);

        return new ResponseEntity<>(new ApiResponse(result),HttpStatus.ACCEPTED);

    }

    @GetMapping
    ResponseEntity<ApiResponse> getAllAdmissionDetailed(){

        List<AdmissionRecordDTO> result =  admissionRecordService.getAllAdmissionDetailed();

        return  new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);

    }
}
