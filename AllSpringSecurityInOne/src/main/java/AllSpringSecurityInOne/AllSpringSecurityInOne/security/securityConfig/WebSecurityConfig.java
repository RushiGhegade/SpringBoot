package AllSpringSecurityInOne.AllSpringSecurityInOne.security.securityConfig;

import AllSpringSecurityInOne.AllSpringSecurityInOne.jwt.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {


    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private Oauth2SuccessHandler oauth2SuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                auth->auth
                        .requestMatchers("/auth/**","/home.html").permitAll()
                        .anyRequest().authenticated()
        ).csrf(csrf-> csrf.disable())
                .sessionManagement(ses->ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(
                        outh2login->outh2login
                                .failureUrl("/login?error=true")
                                .successHandler(oauth2SuccessHandler)

                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
// .oauth2Login(oauth->oauth
//                        .failureUrl("/login?error=true"))
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();

    }



}
