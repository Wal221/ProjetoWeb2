package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.Enum.EnglishLevel;
import com.wingsupenglishacademy.model.TurmaEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class TurmaRepositoryTest {

    @Autowired
    TurmaRepository repository;

    @Autowired
    EntityManager entityManager;


    @Test
    @DisplayName("Teste de adicionar turma com sucesso")
    void classFindByIdCase1(){
      TurmaEntity turmaEntity = new TurmaEntity(null,new Date(), EnglishLevel.BASICO, "Livro", null,null);
      this.createdClass(turmaEntity);
      Optional<TurmaEntity> classEntityOptional = repository.findById(turmaEntity.getId());
      assertThat(classEntityOptional.isPresent()).isTrue();

    }


    private TurmaEntity createdClass(TurmaEntity entity){
        entityManager.persist(entity);
        return entity;

    }
}
