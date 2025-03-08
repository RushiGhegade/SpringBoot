package com.AllSpringSecurity.SpringSecurity.config;

import com.AllSpringSecurity.SpringSecurity.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //.requestMatchers("/student").hasRole("ADMIN")  // in these only Admin have Acess of /student route not other user how is different role  can not access it
        //                .formLogin(Customizer.withDefaults());
        httpSecurity
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/student", "/auth/**").permitAll()         // it all without login only this route
                                                .anyRequest().authenticated()  // it says that each request without request matcher authenticate
                )
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessionCofig -> sessionCofig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        // this not allow authentication to all request
//        httpSecurity
//                .authorizeHttpRequests(
//                        auth ->
//                                auth.anyRequest().permitAll() // Allow all requests
//                )
//                .csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


     //  Here We Create a User SignUp so we dont need manually create a user

//    @Bean
//    UserDetailsService createInMemoryUser(){
//        UserDetails user1 = User
//                .withUsername("Rushi")
//                .password(passwordEncoder().encode("Rushi@123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User
//                .withUsername("Rutik")
//                .password(passwordEncoder().encode("Rutik@123"))
//                .roles("USER")
//                .build();
//
////        System.out.println(UserDetails);
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }




}
