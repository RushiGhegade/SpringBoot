package com.SpringSecurityexample.SpringSecurityexample.service;

import com.SpringSecurityexample.SpringSecurityexample.dto.UserDTO;
import com.SpringSecurityexample.SpringSecurityexample.entity.UserEntity;
import com.SpringSecurityexample.SpringSecurityexample.exception.ResourceNotFoundException;
import com.SpringSecurityexample.SpringSecurityexample.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO getUserById(int id) {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("user Not found for this id "+id)
        );

        return modelMapper.map(userEntity,UserDTO.class);

    }

    public List<UserDTO> getAllUsers() {

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities
                .stream()
                .map(
                        user-> modelMapper.map(user,UserDTO.class)
                ).toList();

    }

    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
        UserEntity saveUser =  userRepository.save(userEntity);
        return modelMapper.map(saveUser,UserDTO.class);
    }
}
