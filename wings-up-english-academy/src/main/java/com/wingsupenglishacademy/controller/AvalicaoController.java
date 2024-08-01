package com.wingsupenglishacademy.controller;


import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvalicaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping(value="/created-avaliacao")
    public ResponseEntity<ResponseAvaliacaDTO> createdAvalicao(@RequestBody RequestAvalicaoDTO avaliacaoDTO){
        return new ResponseEntity<>(avaliacaoService.createdAvalicao(avaliacaoDTO), HttpStatus.CREATED);

    }

    @PostMapping("/salvar")
    public ResponseEntity<AvaliacaoEntity> saveAvalicao (@RequestBody AvaliacaoEntity avaliacaoEntity){
        return new ResponseEntity<>(avaliacaoService.saveAvaliacaoEntity(avaliacaoEntity), HttpStatus.CREATED);
    }
}
