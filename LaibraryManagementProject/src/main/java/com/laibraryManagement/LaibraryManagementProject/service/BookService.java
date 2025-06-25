package com.laibraryManagement.LaibraryManagementProject.service;
import com.laibraryManagement.LaibraryManagementProject.dto.BookDTO;
import com.laibraryManagement.LaibraryManagementProject.entity.BookEntity;
import com.laibraryManagement.LaibraryManagementProject.exception_handling.ResourceNotFoundException;
import com.laibraryManagement.LaibraryManagementProject.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.List;
import  java.util.*;

@Service
public class BookService {

    BookRepository repository;

    @Autowired
    ModelMapper modelMapper;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDTO> getBook() {
        List<BookEntity> books =  repository.findAll();
        return books.stream()
                .map(x-> modelMapper.map(x,BookDTO.class) ).toList();
    }

    public BookDTO addBook(BookDTO bookDTO) {

        BookEntity entity = modelMapper.map(bookDTO,BookEntity.class);
        BookEntity save =  repository.save(entity);
//        System.out.println("Reach 1");
        return modelMapper.map(save,BookDTO.class);

    }

    public BookDTO findById(int id) {

        BookEntity book  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not Found With These ID")
        );
        return modelMapper.map(book,BookDTO.class);
    }

    public BookDTO updateUser(Map<String,Object> update,int id) {

        BookEntity book  = repository .findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not Found With These ID")
        );

        update.forEach(
                (field,value) -> {
                    Field updateField = ReflectionUtils.findRequiredField(
                            BookEntity.class,field
                    );
                    updateField.setAccessible(true);

                    ReflectionUtils.setField(updateField,book,value);
                }
        );
        return modelMapper.map(repository.save(book),BookDTO.class);
    }

    public BookDTO removeBook(int id) {

        BookEntity book = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not found with these id")
        );

        repository.deleteById(id);

        return modelMapper.map(book,BookDTO.class);

    }
}
