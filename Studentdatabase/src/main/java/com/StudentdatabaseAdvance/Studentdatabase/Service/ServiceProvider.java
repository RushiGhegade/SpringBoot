package com.StudentdatabaseAdvance.Studentdatabase.Service;
import com.StudentdatabaseAdvance.Studentdatabase.StudentDTO.StudentDTO;
import com.StudentdatabaseAdvance.Studentdatabase.StudentEntity.StudentEntity;
import com.StudentdatabaseAdvance.Studentdatabase.StudentRepository.StudentRepository;
import com.StudentdatabaseAdvance.Studentdatabase.advice.ApiError;
import com.StudentdatabaseAdvance.Studentdatabase.advice.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceProvider {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;


    public ServiceProvider(StudentRepository studentRepository,ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper=modelMapper;
    }


    public String StudentTestDb() {
        return "DataBase Initialize Sucessfully";
    }

    public boolean checkIdExits(Integer id){
        return studentRepository.existsById(id);
    }


    public Optional<StudentDTO> getUserById(Integer id) {

        return studentRepository.findById(id).map(studentEntity -> modelMapper.map(studentEntity,StudentDTO.class));

    }

    public List<StudentDTO> getAllUser() {

        return studentRepository.findAll().stream().map(
                studentEntity -> modelMapper.map(studentEntity,StudentDTO.class)
        ).collect(Collectors.toList());

    }

    public StudentDTO addUser(StudentDTO studentDTO) {

        StudentEntity studentEntity = modelMapper.map(studentDTO,StudentEntity.class);

        StudentEntity studentDTO1 = studentRepository.save(studentEntity);

        return modelMapper.map(studentDTO1,StudentDTO.class);

    }

    public ResponseEntity<StudentDTO> updateData(Integer id,StudentDTO studentDTO) {

        if(!studentRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        StudentEntity studentEntity = studentRepository.findById(id).get();

        studentEntity.setName(studentDTO.getName());

        StudentEntity st=  studentRepository.save(studentEntity);

        return ResponseEntity.ok(modelMapper.map(st,StudentDTO.class));

    }


    public ResponseEntity<StudentDTO> updatedataSpecific(Integer id, Map<String, Object> studentInfo) {

            if(!studentRepository.existsById(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            StudentEntity studentEntity =  studentRepository.findById(id).get();

            studentInfo.forEach(
                    (key,value)->{

                       Field filed =  ReflectionUtils.findRequiredField(StudentEntity.class,key);

                       filed.setAccessible(true);

                       ReflectionUtils.setField(filed,studentEntity,value);

                    }
            );

            return ResponseEntity.ok(modelMapper.map(studentRepository.save(studentEntity),StudentDTO.class));

    }
}
