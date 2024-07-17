package com.wingsupenglishacademy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class AlunoServiceTest {

    @Mock
    private AlunoService alunoService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Estudante criado com sucesso")
    void createdStudentCase1() {
//        AlunoEntity student = new AlunoEntity(1L,"teste","email@gmail","1234","2345",8.1);
//
//        AlunoEntity studentAux = studentService.createdStudent(student);
//
//        assertEquals(studentAux.getId(),student.getId());
//        assertEquals(studentAux.getName(),student.getName());
//        assertEquals(studentAux.getEmail(),student.getEmail());
//        assertEquals(studentAux.getId(),student.getId());


    }
}