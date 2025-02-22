package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.controller;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity.putEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/admin")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/{id}")
    List<putEntity> getRevision(@PathVariable int id){

        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = auditReader.getRevisions(putEntity.class,id);

        return revisions
                .stream()
                .map(revNo->auditReader.find(putEntity.class,id,revNo)).collect(Collectors.toList());

    }

}
