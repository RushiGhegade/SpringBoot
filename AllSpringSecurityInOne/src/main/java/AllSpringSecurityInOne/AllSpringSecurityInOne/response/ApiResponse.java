package AllSpringSecurityInOne.AllSpringSecurityInOne.response;

import AllSpringSecurityInOne.AllSpringSecurityInOne.exception.ApiError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private LocalDateTime localDateTime;

    private T response;

    private ApiError apiError;

    public ApiResponse(){

        localDateTime= LocalDateTime.now();

    }

    public ApiResponse(T response) {
        this();
        this.response = response;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
