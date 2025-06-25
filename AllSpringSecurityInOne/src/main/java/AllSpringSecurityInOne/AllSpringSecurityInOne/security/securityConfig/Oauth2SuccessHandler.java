package AllSpringSecurityInOne.AllSpringSecurityInOne.security.securityConfig;

import AllSpringSecurityInOne.AllSpringSecurityInOne.jwt.JwtService;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userRepository.UserRepository;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.CollationKey;
@Component
public class Oauth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Value("${deploy.env}")
    private String deployEnv;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
            DefaultOAuth2User oAuth2User = (DefaultOAuth2User) token.getPrincipal();

            String email = oAuth2User.getAttribute("email");
            if (email == null) {
                throw new ServletException("Email not found in OAuth2 user attributes");
            }

            UserEntity user = userService.loadUserByEmail(email).orElse(null);

            if (user == null) {
                UserEntity newUser = new UserEntity(oAuth2User.getAttribute("name"), email);
//                newUser.setRoles("ROLE_USER"); // Set default role
                user = userRepository.save(newUser);
            }

            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);

            Cookie cookie = new Cookie("refreshToken", refreshToken);
            cookie.setHttpOnly(true);
            cookie.setSecure("PRODUCTION".equals(deployEnv));
            response.addCookie(cookie);

            String frontendUrl = "http://localhost:8080/home.html?token=" + accessToken;
            getRedirectStrategy().sendRedirect(request, response, frontendUrl);
        } catch (Exception e) {
            throw new ServletException("Error during OAuth2 success handling", e);
        }
    }
}
