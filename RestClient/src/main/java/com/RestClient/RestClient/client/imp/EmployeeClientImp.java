package com.RestClient.RestClient.client.imp;


import com.RestClient.RestClient.Dto.PutDTO;

import com.RestClient.RestClient.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
@ToString
public class EmployeeClientImp implements EmployeeClient {
    @Autowired
    private RestClient restClient;

    @Override
    public List<PutDTO> getAllUser(){

        try {

            return restClient.get()
                    .uri("Employee")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<PutDTO>>() {
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PutDTO createUser(PutDTO putDTO){

        try{

            return restClient.post()
                    .uri("Employee/addUser")
                    .body(putDTO)
                    .retrieve()
                    .body(PutDTO.class);

        }catch (Exception exception){
            throw new RuntimeException(exception);
        }

    }

    @Override
    public PutDTO getUserById(int id){
        try{
            return restClient.get()
                    .uri("Employee/{id}",id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        System.out.println("-----------------"+new String(response.getBody().readAllBytes()));
                        throw  new RuntimeException("this id  Not Present in db");
                    }))
                    .body(PutDTO.class);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public PutDTO updateUserById(int id,PutDTO putDTO){
        try{

            return restClient.put()
                    .uri("Employee/Update/{id}",id)
                    .body(putDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println("-----------------"+new String(res.getBody().readAllBytes()));
                        throw  new RuntimeException("this id  Not Present in db");
                    }).body(PutDTO.class);
        }catch(Exception e){
            throw new RuntimeException("User Not Found");
        }
    }

//    @Override
//    public List<PutDTO> getRevision(int id){
//        try{
//             return restClient.get()
//                    .uri("admin/{id}",id)
//                    .retrieve()
//                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
//                        System.out.println(new String(response.getBody().readAllBytes()));
//                        throw  new RuntimeException("this id  Not Present in db");
//                    }))
//                    .body(new ParameterizedTypeReference<List<putEntity>>() {
//                    });
//        }catch (Exception e){
//            throw  new RuntimeException(e);
//        }
//    }

}
