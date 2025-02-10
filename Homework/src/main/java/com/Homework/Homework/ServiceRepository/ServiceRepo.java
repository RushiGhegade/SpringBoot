package com.Homework.Homework.ServiceRepository;
import com.Homework.Homework.Entity.HomeWorkEntity;
import com.Homework.Homework.HomeWorkDTO.homeworkDTO;
import com.Homework.Homework.Repository.HomeWorkRepository;
import lombok.EqualsAndHashCode;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServiceRepo {

    private HomeWorkRepository homeWorkRepository;
    private ModelMapper modelMapper;

    public ServiceRepo(HomeWorkRepository homeWorkRepository,ModelMapper modelMapper) {
        System.out.println("in service Repo");
        this.homeWorkRepository = homeWorkRepository;
        this.modelMapper=modelMapper;
    }
    boolean isIdExits (int id){
        return homeWorkRepository.existsById(id);
    }

    public homeworkDTO GetUserById(Integer id) {
        if(!isIdExits(id)){
            return null;
        }
        HomeWorkEntity homeWorkEntity = homeWorkRepository.findById(id).get();
        return modelMapper.map(homeWorkEntity , homeworkDTO.class);
    }


    public List<homeworkDTO> getAllUser() {

        List<HomeWorkEntity> list =  homeWorkRepository.findAll();

        return list.stream().map((value)-> modelMapper.map(value,homeworkDTO.class)).collect(Collectors.toList());

    }

    public homeworkDTO addUser(homeworkDTO obj) {

        HomeWorkEntity homeWorkEntity1 =  modelMapper.map(obj,HomeWorkEntity.class);

        HomeWorkEntity adduser = homeWorkRepository.save(homeWorkEntity1);

        return modelMapper.map(adduser,homeworkDTO.class);

    }

    public String TestServer() {
        return "Server Test Sucessfully";
    }
}
