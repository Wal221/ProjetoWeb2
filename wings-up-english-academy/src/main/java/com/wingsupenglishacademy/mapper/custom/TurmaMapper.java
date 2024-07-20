package com.wingsupenglishacademy.mapper.custom;


import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.TurmaEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaMapper {

    public ResponseTurmaDTO convertEntityForDTO(TurmaEntity turmaEntity) {
        ResponseTurmaDTO turma = new ResponseTurmaDTO();
        List<String> students = new ArrayList<>();
        turma.setId(turmaEntity.getId());
        turma.setClassSchedule(turmaEntity.getclassSchedule());
        turma.setProfessor(turmaEntity.getTeacher().getName());
        turma.setEnglishLevel(turmaEntity.getEnglishLevel());

        for (AlunoEntity aluno : turmaEntity.getStudents()) {
            students.add(aluno.getName());
        }
        turma.setStudents(students);
        return turma;
    }

}
