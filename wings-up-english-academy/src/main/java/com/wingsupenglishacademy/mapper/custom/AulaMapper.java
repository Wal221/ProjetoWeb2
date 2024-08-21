package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.requests.RequestAulaDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAulaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.AulaEntity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AulaMapper {


    public AulaEntity parserDTOForEntity(RequestAulaDTO aulaDTO) {
        AulaEntity aulaEntity = new AulaEntity();

        aulaEntity.setDiaAula(aulaDTO.getDiaAula());
        aulaEntity.setHoraAula(aulaDTO.getHoraAula());
        aulaEntity.setPresenca(aulaDTO.getPresenca());
        aulaEntity.setTopicosAbordados(aulaDTO.getTopicosAbordados());


        return aulaEntity;
    }

    public ResponseAulaDTO convertEntityForDTO(AulaEntity aulaEntity) {
        ResponseAulaDTO aula = new ResponseAulaDTO();
        List<String> students = new ArrayList<>();
        aula.setDiaAula(aulaEntity.getDiaAula());
        aula.setTopicosAbordados(aulaEntity.getTopicosAbordados());

        aula.setStudents(students);
        return aula;
    }

}
