package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.putService;


import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Dto.PutDTO;
import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity.putEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PutService {

    List<PutDTO> getAllUser();

    PutDTO createUser(PutDTO putDTO);

    PutDTO findUserById(int id);

    PutDTO updateUser(int id,PutDTO putDTO);

}
