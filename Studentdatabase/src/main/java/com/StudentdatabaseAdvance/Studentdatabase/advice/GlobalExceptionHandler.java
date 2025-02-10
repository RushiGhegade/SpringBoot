package com.StudentdatabaseAdvance.Studentdatabase.advice;
import com.StudentdatabaseAdvance.Studentdatabase.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelexception(ResourceNotFoundException exception){

        ApiError apierror = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
//        return new ResponseEntity<>(apierror,HttpStatus.NOT_FOUND);

        return buildErrorResponse(apierror);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handelAllException(Exception e){

        ApiError apierror = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message("Internal Server Error").build();

        return buildErrorResponse(apierror);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handelMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // because of these below line it show all exception come  that why it not proficient
        //ApiError apiError = ApiError.builder().status(HttpStatus.METHOD_NOT_ALLOWED).message(e.getMessage()).build();

        // Make Proficient

        List<String> getdata = e.getBindingResult().getAllErrors().stream().map((error)->error.getDefaultMessage()).collect(Collectors.toList());

        ApiError apierror = ApiError.builder().status(HttpStatus.BAD_REQUEST).message(getdata.toString()).build();

        return buildErrorResponse(apierror);

    }

    private ResponseEntity<ApiResponse> buildErrorResponse(ApiError apiError){

        return new ResponseEntity<>(new ApiResponse(apiError),apiError.getStatus());

    }

}
