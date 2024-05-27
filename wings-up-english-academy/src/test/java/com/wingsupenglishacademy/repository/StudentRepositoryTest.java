package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.StudentEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@ActiveProfiles("test")
//iindicando que o arquivo de conexão de bd vai ser o de teste no caso o do H2 e não o da pasta raiz
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;
    /**
     * Antes de valida se existe um aluno no meu banco de dados eu preciso inseri-lo
     * visto que o cenario  de sucesso da minha aplicação existe um aluno que pode ser adicionado.
     *
     */
    @Test
    @DisplayName("Retorna o sucesso de uma  busca de um usuario por ID") //
    void findByStudent() {
       StudentEntity student = new StudentEntity(null,"Walmir", "teste@gmail.com", "629991212","2032321", 8.1);

       //student.setId(id);
       StudentEntity studentAux = this.createdStudent(student);
       Optional<StudentEntity>  result = studentRepository.findById(studentAux.getId());

       //Com isso ja vou conseguir verificar se a um estudante presente
        assertThat(result.isPresent()).isTrue();



    }

     /*
       Metodo auxilar do meu teste findByStudent
      */
     private StudentEntity createdStudent(StudentEntity student ){
         // essa não e a malhor forma de se fazer
         this.entityManager.persist(student);

        return student;
     }
}