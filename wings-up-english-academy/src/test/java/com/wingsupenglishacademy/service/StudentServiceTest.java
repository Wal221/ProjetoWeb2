package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.StudentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class StudentServiceTest {

    @Mock
    private StudentService studentService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Estudante criado com sucesso")
    void createdStudentCase1() {
//        StudentEntity student = new StudentEntity(1L,"teste","email@gmail","1234","2345",8.1);
//
//        StudentEntity studentAux = studentService.createdStudent(student);
//
//        assertEquals(studentAux.getId(),student.getId());
//        assertEquals(studentAux.getName(),student.getName());
//        assertEquals(studentAux.getEmail(),student.getEmail());
//        assertEquals(studentAux.getId(),student.getId());


    }
}