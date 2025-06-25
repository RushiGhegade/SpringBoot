package AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService;

import AllSpringSecurityInOne.AllSpringSecurityInOne.jwt.JwtService;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.LoginDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),loginDTO.getPassword()
                )
        );

        UserEntity user = (UserEntity) authentication.getPrincipal();

        String accessToken =  jwtService.generateAccessToken(user);
        String refreshToken =  jwtService.generateRefreshToken(user);

        return new LoginResponseDTO(accessToken,refreshToken);
    }

    public LoginResponseDTO refreshToken(String refreshToken) {

        int uid = jwtService.getUserIdFromToken(refreshToken);

        UserEntity user = userService.getUserFromId(uid);

        String accessToken = jwtService.generateAccessToken(user);

        return new LoginResponseDTO(accessToken,refreshToken);
    }
}
