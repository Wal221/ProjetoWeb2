package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.ClassEntity;
import com.wingsupenglishacademy.model.StudentEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ClassRepositoryTest {

    @Autowired
    ClassRepository repository;

    @Autowired
    EntityManager entityManager;


    @Test
    @DisplayName("Teste de adicionar turma com sucesso")
    void classFindById(){

    }


    private ClassEntity createdClass(ClassEntity entity){
        entityManager.persist(entity);
        return entity;

    }
}
