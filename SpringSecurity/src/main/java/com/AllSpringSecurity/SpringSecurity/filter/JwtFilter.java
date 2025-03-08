package com.AllSpringSecurity.SpringSecurity.filter;

import com.AllSpringSecurity.SpringSecurity.entity.UserEntity;
import com.AllSpringSecurity.SpringSecurity.repository.UserRepository;
import com.AllSpringSecurity.SpringSecurity.service.JwtService;
import com.AllSpringSecurity.SpringSecurity.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component

public class JwtFilter extends OncePerRequestFilter {

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

            // Fetch The Header from request
            final String requestTokenHeader = request.getHeader("Authorization");

            // if header is null or header doesn't contain Bearer first name then it null because each token start with bearer name
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
                // if null then end this filter and pass to next userNamePasswordFilter they authenticate then according them
                // do filter pass request to next filter
                filterChain.doFilter(request, response);
            }

            // if not null  then fetch the only token because in header token is present in the form [Bearer token] we need only token
            String token = requestTokenHeader.split("Bearer")[1];   // After split token present index 1 - 0 index is having space only

            System.out.println(token.trim() + "-----------------------------------------------");

            // Now find id from token using this method service class
            int userId = jwtService.generateUserIdFromToken(token.trim());

            // Now we get Id We have to fetch the User using id from table
            UserEntity user = userService.getUserById(userId);

            // Till Now we get user now we need Authentication Object that store on the context so to make Authentication object
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);

            // we can also add more details about user in that like
            usernamePasswordAuthenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            // Now to set SecurityContextHolder this object
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


            // now user work get complete we put authentication object till security context now we go next
            // filter userNamePasswordFilter this filter check 1st Security context if it have already object then it skip
            // this return store security Context object back
            filterChain.doFilter(request, response);
        }catch (Exception ex){
            handlerExceptionResolver.resolveException(request,response,null,ex);
        }

    }
}
