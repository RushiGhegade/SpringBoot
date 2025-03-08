package com.CollageManagementSystem.CollageManagementSystem.Service;

import com.CollageManagementSystem.CollageManagementSystem.DTO.StudentDTO;
import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import com.CollageManagementSystem.CollageManagementSystem.Entity.StudentEntity;
import com.CollageManagementSystem.CollageManagementSystem.Repository.ProfessorRepository;
import com.CollageManagementSystem.CollageManagementSystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private ProfessorRepository professorRepository;

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    // GetAllStudent
    public List<StudentDTO> getAllUser(){

         List<StudentEntity> allUsers = studentRepository.findAll();

         return allUsers.stream().map(
                 user -> modelMapper.map(user,StudentDTO.class)
         ).toList();

    }

    // addStudent
    public StudentDTO addStudent(StudentDTO studentDTO){

        StudentEntity studentEntity = modelMapper.map(studentDTO,StudentEntity.class);

        StudentEntity save =  studentRepository.save(studentEntity);

        return modelMapper.map(save,StudentDTO.class);
    }


    public StudentDTO assignProfessorToStudent(int stdId,int proId){

        StudentEntity studentEntity = studentRepository.findById(stdId).orElseThrow(()-> new NoSuchElementException());
        ProfessorEntity professorEntity = professorRepository.findById(proId).orElseThrow(()-> new NoSuchElementException());

        List<StudentEntity> list = professorEntity.getStudents();
        list.add(studentEntity);
        professorEntity.setStudents(list);
        professorRepository.save(professorEntity);

        List<ProfessorEntity> professorEntityList =  studentEntity.getProfessors();
        professorEntityList.add(professorEntity);
        studentEntity.setProfessors(professorEntityList);

        return modelMapper.map(studentRepository.save(studentEntity),StudentDTO.class);

    }

}
