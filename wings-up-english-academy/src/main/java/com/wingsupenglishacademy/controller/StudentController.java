package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "{id}")
    public ResponseEntity<StudentEntity> getStudentById(@RequestParam Long id) {
        return new ResponseEntity<>(  studentService.findByIdStudent(id), HttpStatus.OK);
    }
   


    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        return new ResponseEntity<>(studentService.createdStudent(student), HttpStatus.CREATED);
    }


    @PutMapping(value = "update")
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity student) {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<StudentEntity> deleteStudent(@RequestParam Long id) {
        StudentEntity student = studentService.findByIdStudent(id);
        if(student != null) {
            studentService.deleteStudent(student);
        }
         return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.findAllStudent());
    }


}
