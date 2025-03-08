package com.CollageManagementSystem.CollageManagementSystem.Service;

import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.SubjectDTO;
import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import com.CollageManagementSystem.CollageManagementSystem.Entity.SubjectEntity;
import com.CollageManagementSystem.CollageManagementSystem.Repository.ProfessorRepository;
import com.CollageManagementSystem.CollageManagementSystem.Repository.StudentRepository;
import com.CollageManagementSystem.CollageManagementSystem.Repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;
    private ProfessorRepository professorRepository;
    private ModelMapper modelMapper;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }

    public List<SubjectDTO> getAllsubject(){

        List<SubjectEntity> getAll = subjectRepository.findAll();

        return getAll
                .stream()
                .map(
                        user->modelMapper.map(user,SubjectDTO.class)
                ).toList();

    }

    public SubjectDTO addSubject(SubjectDTO subjectDTO){

        SubjectEntity subjectEntity = modelMapper.map(subjectDTO,SubjectEntity.class);

        SubjectEntity professor = subjectRepository.save(subjectEntity);

        return modelMapper.map(professor,SubjectDTO.class);

    }

    public SubjectDTO  assignProfessorToSubject(int subId,int proId){

        ProfessorEntity professorEntity = professorRepository.findById(proId).orElseThrow(()-> new NoSuchElementException());

        SubjectEntity subjectEntity = subjectRepository.findById(subId).orElseThrow(()-> new NoSuchElementException());

        subjectEntity.setProfessor(professorEntity);

        List<SubjectEntity> list = professorEntity.getSubjects();
        list.add(subjectEntity);

        professorEntity.setSubjects(list);

        professorRepository.save(professorEntity);

        return modelMapper.map(subjectRepository.save(subjectEntity),SubjectDTO.class);
    }
}
