package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.RequestTeacherDTO;
import com.wingsupenglishacademy.DTO.ResponseTeacherDTO;
import com.wingsupenglishacademy.model.TeacherEntity;
import com.wingsupenglishacademy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService TeacherService;

    @GetMapping(value = "/DTO/{id}")
    public ResponseEntity<ResponseTeacherDTO> findTeacherByIdDTO(@PathVariable Long id) {
        return new ResponseEntity<>(  TeacherService.findByIdTeacher(id), HttpStatus.OK);
    }


    @PostMapping(value = "/create-professor")
    public ResponseEntity<ResponseTeacherDTO> createTeacher(@RequestBody RequestTeacherDTO teacher) {
        return new ResponseEntity<>(TeacherService.createdTeacher(teacher), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<TeacherEntity> updateTeacher(@RequestBody TeacherEntity student) {
        return new ResponseEntity<>(TeacherService.updateTeacher(student), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<ResponseTeacherDTO> deleteTeacher(@PathVariable Long id) {
        ResponseTeacherDTO student = TeacherService.findByIdTeacher(id);
        if(student != null) {
            TeacherService.deleteTeacher(id);
        }
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/teaches")
    public ResponseEntity<List<TeacherEntity>> getAllStudents() {
        return ResponseEntity.ok().body(TeacherService.getAllTeachers());
    }


}
