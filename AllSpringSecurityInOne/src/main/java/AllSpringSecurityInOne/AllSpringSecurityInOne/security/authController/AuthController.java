package AllSpringSecurityInOne.AllSpringSecurityInOne.security.authController;
import AllSpringSecurityInOne.AllSpringSecurityInOne.response.ApiResponse;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.LoginDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.LoginResponseDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.SignupDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.UserDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService.AuthService;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private UserService userService;
    private AuthService authService;


    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping(path = "/signUp")
    public  ResponseEntity<ApiResponse> signUp(@RequestBody SignupDTO signupDTO) {
        UserDTO userDTO =  userService.signUp(signupDTO);
        return ResponseEntity.ok(new ApiResponse<>(userDTO));
    }

    @PostMapping(path = "/login")
    public  ResponseEntity<ApiResponse> login(@RequestBody LoginDTO loginDTO , HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) {

        LoginResponseDTO token =  authService.login(loginDTO);

        Cookie cookie = new Cookie("refreshToken", token.getRefreshToken());

        cookie.setHttpOnly(true);

        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok(new ApiResponse<>(token));

    }

    @PostMapping(path = "/refreshToken")
    public ResponseEntity<ApiResponse> refreshToken(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){

        String refreshToken = Arrays.stream(httpServletRequest.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(
                        ()->new AuthenticationServiceException("Refresh Token Not found inside cookies")
                );

        LoginResponseDTO loginResponseDTO =  authService.refreshToken(refreshToken);

        return ResponseEntity.ok(new ApiResponse(loginResponseDTO));


    }
}
