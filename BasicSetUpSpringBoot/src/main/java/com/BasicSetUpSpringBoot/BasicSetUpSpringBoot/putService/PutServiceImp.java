package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.putService;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Dto.PutDTO;
import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity.putEntity;
import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Repository.PutRepository;
import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PutServiceImp implements PutService {

    private final PutRepository putRepository;
    private final ModelMapper modelMapper;

    public PutServiceImp(PutRepository putRepository, ModelMapper modelMapper) {
        this.putRepository = putRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<PutDTO> getAllUser() {

        List<putEntity> getdata = putRepository.findAll();

        return getdata.stream().map(
                user-> modelMapper.map(user,PutDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public PutDTO createUser(PutDTO putDTO) {

        putEntity getdata = modelMapper.map(putDTO,putEntity.class);

        putEntity addUser =  putRepository.save(getdata);

        return modelMapper.map(addUser,PutDTO.class);
    }

    @Override
    public PutDTO findUserById(int id) {
        putEntity get = putRepository.findById(id).orElseThrow (()-> new ResourceNotFoundException("Id Not Found "+id));

        return modelMapper.map(get,PutDTO.class);
    }


}
