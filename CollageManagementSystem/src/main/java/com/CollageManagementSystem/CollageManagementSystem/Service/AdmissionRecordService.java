package com.CollageManagementSystem.CollageManagementSystem.Service;

import com.CollageManagementSystem.CollageManagementSystem.DTO.AdmissionRecordDTO;
import com.CollageManagementSystem.CollageManagementSystem.Entity.AdmissionRecordEntity;
import com.CollageManagementSystem.CollageManagementSystem.Entity.StudentEntity;
import com.CollageManagementSystem.CollageManagementSystem.Repository.AdmissionRecordRepository;
import com.CollageManagementSystem.CollageManagementSystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AdmissionRecordService {

    private AdmissionRecordRepository admissionRecordRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;


    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository, ModelMapper modelMapper) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public AdmissionRecordDTO getAdmission(int id){

        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException());

        AdmissionRecordEntity admissionRecordEntity = new AdmissionRecordEntity();

        admissionRecordEntity.setFees(60000.00);
        admissionRecordEntity.setStudent(studentEntity);

        return modelMapper.map(admissionRecordRepository.save(admissionRecordEntity),AdmissionRecordDTO.class);

    }

    public List<AdmissionRecordDTO> getAllAdmissionDetailed(){

        List<AdmissionRecordEntity> admissionRecordEntities = admissionRecordRepository.findAll();

        System.out.println("---------------------------- "+admissionRecordEntities);

        return admissionRecordEntities
                .stream()
                .map(user->modelMapper.map(user,AdmissionRecordDTO.class))
                .toList();


    }
}
