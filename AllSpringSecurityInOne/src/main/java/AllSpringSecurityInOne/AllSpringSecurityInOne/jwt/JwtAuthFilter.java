package AllSpringSecurityInOne.AllSpringSecurityInOne.jwt;

import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService.AuthService;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            String header = request.getHeader("Authorization");

            if (header == null || !header.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = header.split("Bearer")[1].trim();

            Integer uid = jwtService.getUserIdFromToken(token);

            if (uid != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserEntity user = userService.getUserFromId(uid);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, null);

                SecurityContextHolder.getContext().setAuthentication(authentication);

                authentication.setDetails(
                        new WebAuthenticationDetails(request)
                );


            }

            filterChain.doFilter(request, response);
        }catch (Exception e){

            handlerExceptionResolver.resolveException(request,response,null,e);

        }
    }
}
