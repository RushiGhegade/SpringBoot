package com.RestClient.RestClient.client;

import com.RestClient.RestClient.Dto.PutDTO;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeClient  {

    List<PutDTO> getAllUser();

    PutDTO createUser(PutDTO putDTO);

    PutDTO getUserById(int id);

    PutDTO updateUserById(int id,PutDTO putDTO);

//    List<putEntity> getRevision(int id);


}
