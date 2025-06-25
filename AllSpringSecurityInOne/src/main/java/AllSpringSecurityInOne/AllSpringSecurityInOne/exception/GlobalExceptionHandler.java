package AllSpringSecurityInOne.AllSpringSecurityInOne.exception;

import AllSpringSecurityInOne.AllSpringSecurityInOne.response.ApiResponse;
import io.jsonwebtoken.JwtException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelResourceNotFoundException(ResourceNotFoundException exception){

        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);

        ApiResponse apiResponse = new ApiResponse(apiError);

        return  new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handelException(Exception exception){
        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        ApiResponse apiResponse = new ApiResponse(apiError);

        return  new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse> handelJwtException(JwtException exception){
        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        ApiResponse apiResponse = new ApiResponse(apiError);

        return  new ResponseEntity<>(apiResponse,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> handelAuthenticationException(AuthenticationException exception){
        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.UNAUTHORIZED);

        ApiResponse apiResponse = new ApiResponse(apiError);

        return  new ResponseEntity<>(apiResponse,HttpStatus.UNAUTHORIZED);
    }
}
