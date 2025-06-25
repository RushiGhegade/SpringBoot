package AllSpringSecurityInOne.AllSpringSecurityInOne.exception;

import org.springframework.http.HttpStatus;

public class ApiError {



    private String  Error;
    private HttpStatus httpStatus;

    public ApiError() {
    }

    public ApiError(String error, HttpStatus httpStatus) {
        Error = error;
        this.httpStatus = httpStatus;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
