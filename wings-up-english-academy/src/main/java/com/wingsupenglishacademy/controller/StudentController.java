package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.StudentDTO;
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
    public ResponseEntity<StudentDTO> getStudentByI(@PathVariable Long id) {
      StudentEntity saved = studentService.findByIdStudent(id);
        StudentDTO  studentDTO = new StudentDTO(saved);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);

    }
   


    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {

        // nessas primeira etapa eu converto um studentDTO para um studanteEntity
        var entity = DozerMapper.parseObject(student, StudentEntity.class);
         studentService.createdStudent(entity);
         // Apos salva, como preciso retorna um studantDTO realizo a conversão novamente
        var entityDTO = DozerMapper.parseObject(entity, StudentDTO.class);
        return new ResponseEntity<>(entityDTO, HttpStatus.CREATED);
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
