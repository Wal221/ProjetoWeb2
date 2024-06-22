package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.model.TeacherEntity;
import com.wingsupenglishacademy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService TeacherService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherEntity> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(  TeacherService.getTeacherById(id), HttpStatus.OK);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<TeacherEntity> createStudent(@RequestBody TeacherEntity teacher) {
        return new ResponseEntity<>(TeacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<TeacherEntity> updateStudent(@RequestBody TeacherEntity student) {
        return new ResponseEntity<>(TeacherService.updateTeacher(student), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<TeacherEntity> deleteStudent(@PathVariable Long id) {
        TeacherEntity student = TeacherService.getTeacherById(id);
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
