package com.TODOSpringBoot.TODOTASK.Service;

import com.TODOSpringBoot.TODOTASK.DTO.ToDoDTO;
import com.TODOSpringBoot.TODOTASK.Entity.TodoEntity;
import com.TODOSpringBoot.TODOTASK.Repository.ToDoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;
    private ModelMapper modelMapper;

    public ToDoService(ToDoRepository toDoRepository,ModelMapper modelMapper){
        this.toDoRepository=toDoRepository;
        this.modelMapper=modelMapper;
    }


    public ToDoDTO findById(Integer id) {

        TodoEntity todoEntity = toDoRepository.findById(id).orElse(null);

        return modelMapper.map(todoEntity,ToDoDTO.class);
    }

    public List<ToDoDTO> findAll() {
        List<TodoEntity> todoEntities = toDoRepository.findAll();

        return todoEntities.stream().map(todoEntity -> modelMapper.map(todoEntity,ToDoDTO.class)).collect(Collectors.toList());
    }

    public ToDoDTO save(ToDoDTO toDoDTO) {

        TodoEntity todo = modelMapper.map(toDoDTO,TodoEntity.class);

        TodoEntity todoEntity = toDoRepository.save(todo);

        return modelMapper.map(todoEntity,ToDoDTO.class);

    }

    public ToDoDTO deletebyid(Integer id) {

        TodoEntity todoEntity = toDoRepository.findById(id).orElse(null);

        toDoRepository.deleteById(id);
        return modelMapper.map(todoEntity,ToDoDTO.class);
    }

    public ToDoDTO updateUser(Integer id,ToDoDTO obj) {
        TodoEntity todoEntity =  toDoRepository.findById(id).orElse(null);



       //todoEntity;

        todoEntity.setName(obj.getName());
        todoEntity.setDiscription(obj.getDiscription());
        todoEntity.setDate(obj.getDate());
        todoEntity.setCompleted(obj.getIsCompleted());

        TodoEntity todoEntity1 =  toDoRepository.save(todoEntity);

        return modelMapper.map(todoEntity1,ToDoDTO.class);
    }
}
