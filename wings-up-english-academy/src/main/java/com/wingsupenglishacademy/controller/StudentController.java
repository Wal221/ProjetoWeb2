package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.RequestStudentDTO;
import com.wingsupenglishacademy.DTO.ResponseStudentDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
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

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
//        return new ResponseEntity<>(  studentService.findByIdStudent(id), HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RequestStudentDTO> getStudentByI(@PathVariable Long id) {
      StudentEntity saved = studentService.findByIdStudent(id);
        RequestStudentDTO requestStudentDTO = new RequestStudentDTO(saved);
        return new ResponseEntity<>(requestStudentDTO, HttpStatus.OK);

    }
   


    @PostMapping(value = "/created")
    public ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody RequestStudentDTO studentDTO) {

        return new ResponseEntity<>(studentService.createdStudent(studentDTO), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
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
