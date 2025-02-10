package com.PracticeSpringBoot.Practice.PracticeController;

import com.PracticeSpringBoot.Practice.Advice.ApiError;
import com.PracticeSpringBoot.Practice.Advice.ApiResponse;
import com.PracticeSpringBoot.Practice.PracticeDTO.PracticeDTO;
import com.PracticeSpringBoot.Practice.PracticeService.PracticeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Practice")
public class PracticeController {

    private PracticeService practiceService;

    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @GetMapping(path = "/Test")
    public ResponseEntity<ApiResponse> TestServer() {
        return ResponseEntity.ok(new ApiResponse<>(practiceService.TestServer()));
    }

    @GetMapping(path = "/GetUserById/{id}")
    public ResponseEntity<ApiResponse> GetUserById(@PathVariable int id){

        PracticeDTO practiceDTO = practiceService.GetUserById(id).orElseThrow(
                NullPointerException::new
        );
        return ResponseEntity.ok(new ApiResponse<>(practiceDTO));
    }

    @GetMapping(path = "/GetAllUser")
    public ResponseEntity<ApiResponse> getAllUser(){

        List<PracticeDTO> practiceDTOList = practiceService.getAllUser();

        return ResponseEntity.ok(new ApiResponse<>(practiceService));

    }

    @PostMapping("/AddUser")
    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody PracticeDTO practiceDTO){
        PracticeDTO practiceDTO1 = practiceService.addUser(practiceDTO);
//        System.out.println("--------------------"+practiceDTO1.getName());
        return ResponseEntity.ok(new ApiResponse<>(practiceDTO1));
    }

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable int id, @RequestBody PracticeDTO practiceDTO){
        PracticeDTO practiceDTO1 = practiceService.updateUser(id,practiceDTO);
//        System.out.println("--------------------"+practiceDTO1.getName());
        return ResponseEntity.ok(new ApiResponse<>(practiceDTO1));
    }

    @PatchMapping("/UpdateSpecificField/{id}")
    public ResponseEntity<ApiResponse> UpdateSpecificField(@PathVariable Integer id , @RequestBody Map<String,Object> map){

        PracticeDTO practiceDTO = practiceService.UpdateSpecificField(id,map);

        return ResponseEntity.ok(new ApiResponse<>(practiceDTO));

    }

}
