package com.CollageManagementSystem.CollageManagementSystem.Service;

import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import com.CollageManagementSystem.CollageManagementSystem.Repository.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    private ModelMapper modelMapper;

    public ProfessorService(ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProfessorDTO> getAllProfessor(){

        List<ProfessorEntity> getAll = professorRepository.findAll();

        return getAll
                .stream()
                .map(
                        user->modelMapper.map(user,ProfessorDTO.class)
                ).toList();

    }

    public ProfessorDTO addProfessor(ProfessorDTO professorDTO){

        ProfessorEntity professorEntity = modelMapper.map(professorDTO,ProfessorEntity.class);

        ProfessorEntity professor = professorRepository.save(professorEntity);

        return modelMapper.map(professor,ProfessorDTO.class);

    }
}
