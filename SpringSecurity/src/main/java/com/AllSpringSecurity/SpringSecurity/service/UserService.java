package com.AllSpringSecurity.SpringSecurity.service;

import com.AllSpringSecurity.SpringSecurity.auth.SignUpDto;
import com.AllSpringSecurity.SpringSecurity.auth.UserDto;
import com.AllSpringSecurity.SpringSecurity.entity.UserEntity;
import com.AllSpringSecurity.SpringSecurity.exception.ResourceNotFoundException;
import com.AllSpringSecurity.SpringSecurity.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;

    }

    //    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
//        this.authenticationManager = authenticationManager;
//        this.jwtService = jwtService;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User with Email "+username+" Not Found"));
    }

    // find User By UserId
    public UserEntity getUserById(int id){

        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id "+id+" Not Found"));

    }


    // SignUp

    public UserDto signUpUser(SignUpDto signUpDto){


        Optional<UserEntity> user = userRepository.findByEmail(signUpDto.getEmail());

        if(user.isPresent()){
            System.out.println("Not Reach here");
            new ResourceNotFoundException("User with Email "+signUpDto.getEmail()+" Already present");
        }

        UserEntity userEntity = modelMapper.map(signUpDto,UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        return  modelMapper.map(userRepository.save(userEntity),UserDto.class);

    }

    // Login
    // We canot create login methos here it create a cicular dependency


}
