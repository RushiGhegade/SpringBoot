package com.springSecurityPractice.SpringSecurityPractice.service;

import com.springSecurityPractice.SpringSecurityPractice.Repository.UserRepository;
import com.springSecurityPractice.SpringSecurityPractice.dto.LoginDTO;
import com.springSecurityPractice.SpringSecurityPractice.dto.SignUpDTO;
import com.springSecurityPractice.SpringSecurityPractice.dto.UserDTO;
import com.springSecurityPractice.SpringSecurityPractice.entity.UserEntity;
import com.springSecurityPractice.SpringSecurityPractice.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(
                ()-> new ResourceNotFoundException("User Not found with this email "+username)
        );
    }

    public UserEntity getUserById(int id){
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not found with this id "+id)
        );
    }

    public UserDTO signUpUser(SignUpDTO signUpDTO) {

        Optional<UserEntity> user1 =  userRepository.findByEmail(signUpDTO.getEmail());

        if(user1.isPresent()){
            throw new ResourceNotFoundException("User is Already Exit with this email "+signUpDTO.getUserName());
        }

        UserEntity user = modelMapper.map(signUpDTO,UserEntity.class);

        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));

        UserEntity userEntity = userRepository.save(user);

        return modelMapper.map(userEntity,UserDTO.class);

    }


}
