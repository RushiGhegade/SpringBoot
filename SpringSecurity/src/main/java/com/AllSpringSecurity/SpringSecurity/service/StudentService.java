package com.AllSpringSecurity.SpringSecurity.service;

import com.AllSpringSecurity.SpringSecurity.entity.StudentEntity;
import com.AllSpringSecurity.SpringSecurity.repository.StudentRepo;
import com.AllSpringSecurity.SpringSecurity.studentdto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo ;
    private ModelMapper modelMapper;

    public StudentService(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    public List<StudentDTO> getUserInfo() {

        List<StudentEntity> studentEntity =  studentRepo.findAll();

        return studentEntity
                .stream()
                .map(
                        student ->modelMapper.map(student,StudentDTO.class)
                ).toList();
    }

    public StudentDTO addUser(StudentDTO studentDTO) {

        StudentEntity studentEntity = modelMapper.map(studentDTO,StudentEntity.class);

        return modelMapper.map(studentRepo.save(studentEntity),StudentDTO.class);

    }
}
