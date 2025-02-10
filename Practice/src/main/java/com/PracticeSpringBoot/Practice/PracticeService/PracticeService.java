package com.PracticeSpringBoot.Practice.PracticeService;

import com.PracticeSpringBoot.Practice.Config.ModelMapperPractice;
import com.PracticeSpringBoot.Practice.Entity.PracticeEntity;
import com.PracticeSpringBoot.Practice.PracticeDTO.PracticeDTO;
import com.PracticeSpringBoot.Practice.Repository.PracticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PracticeService {

    private PracticeRepository practiceRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PracticeService(PracticeRepository practiceRepository, ModelMapper modelMapperPractice) {
        this.practiceRepository = practiceRepository;
        this.modelMapper = modelMapperPractice;
    }

    public PracticeService(){

    }

    public PracticeDTO UpdateSpecificField(Integer id, Map<String,Object> map) {

         PracticeEntity practiceEntity =  practiceRepository.findById(id).orElseThrow(NullPointerException::new);

        map.forEach(
                (Key,value)->{
                    Field field= ReflectionUtils.findRequiredField(PracticeEntity.class,Key);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field,practiceEntity,value);
                }
        );

        return modelMapper.map(practiceRepository.save(practiceEntity),PracticeDTO.class);

    }

    // For Testing the Server
    public String TestServer() {
        return "Server Tested Sucessfully";
    }

    // Find User By Id
    public Optional<PracticeDTO> GetUserById(int id) {
        Optional<PracticeEntity> practiceEntity =  practiceRepository.findById(id);

        return practiceEntity.map(value->modelMapper.map(value,PracticeDTO.class));

    }

    public List<PracticeDTO> getAllUser() {

         List<PracticeEntity> practiceEntities = practiceRepository.findAll();

         return practiceEntities.stream().map(
                 value->modelMapper.map(value,PracticeDTO.class)
         ).collect(Collectors.toList());

    }

    public PracticeDTO addUser(PracticeDTO practiceDTO) {

        PracticeEntity practiceEntity =modelMapper.map(practiceDTO,PracticeEntity.class);

        PracticeEntity practiceEntity1 =  practiceRepository.save(practiceEntity);

        return modelMapper.map(practiceEntity1,PracticeDTO.class);
    }

    public PracticeDTO updateUser(int id,PracticeDTO practiceDTO) {


        PracticeEntity practiceEntity = practiceRepository.findById(id).orElseThrow(NullPointerException::new);

        int originalId = practiceEntity.getId();

         modelMapper.map(practiceDTO,practiceEntity);

         practiceEntity.setId(originalId);

        PracticeEntity practiceEntity1 =  practiceRepository.save(practiceEntity);

        return modelMapper.map(practiceEntity1,PracticeDTO.class);

    }


}
