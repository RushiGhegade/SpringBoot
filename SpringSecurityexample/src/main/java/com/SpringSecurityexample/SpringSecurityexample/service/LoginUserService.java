package com.SpringSecurityexample.SpringSecurityexample.service;

import com.SpringSecurityexample.SpringSecurityexample.dto.LoginDTO;
import com.SpringSecurityexample.SpringSecurityexample.dto.SignUpDTO;
import com.SpringSecurityexample.SpringSecurityexample.dto.SignUpUserDTO;
import com.SpringSecurityexample.SpringSecurityexample.entity.LoginUserEntity;
import com.SpringSecurityexample.SpringSecurityexample.exception.ResourceNotFoundException;
import com.SpringSecurityexample.SpringSecurityexample.repository.LoginUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService implements UserDetailsService {

    @Autowired
    private LoginUserRepository loginUserRepository;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginUserRepository.findByEmail(username).orElseThrow(
                ()-> new ResourceNotFoundException("Username not found "+username)
        );
    }

    public LoginUserEntity findUserById(int id){

        return loginUserRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Username not found "+id)
        );

    }



    public SignUpUserDTO signUpUser(SignUpDTO signUpDTO) {

        Optional<LoginUserEntity> loginUserEntity = loginUserRepository.findByEmail(signUpDTO.getEmail());

        if(loginUserEntity.isPresent()){

            throw new BadCredentialsException("User With this email already exits "+signUpDTO.getEmail());

        }

        LoginUserEntity user = modelMapper.map(signUpDTO,LoginUserEntity.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return modelMapper.map(loginUserRepository.save(user),SignUpUserDTO.class);

    }
}
