package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.FranquiaEntity;
import com.wingsupenglishacademy.repository.FranquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiaService {

    @Autowired
    private FranquiaRepository franquiaRepository;

    public FranquiaRepository save(FranquiaEntity franquiaEntity) {return (FranquiaRepository) franquiaRepository.save(franquiaEntity);}

    public List<FranquiaEntity> findAll() {return franquiaRepository.findAll();}

    public FranquiaRepository findById(Long id) {return franquiaRepository;}

    public void delete(FranquiaEntity franquiaEntity) {franquiaRepository.delete(franquiaEntity);}

    public FranquiaRepository update(Long id, FranquiaEntity franquiaEntity) { return (FranquiaRepository) franquiaRepository.save(franquiaEntity);
    }
}
