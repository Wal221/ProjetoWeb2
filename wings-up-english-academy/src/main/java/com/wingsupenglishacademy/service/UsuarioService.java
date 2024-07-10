package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.UsuarioEntity;
import com.wingsupenglishacademy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll(){return usuarioRepository.findAll();}

    public UsuarioEntity findById(Long id){return usuarioRepository.findById(id).get();}

    public UsuarioEntity save(UsuarioEntity usuarioEntity){return usuarioRepository.save(usuarioEntity);}

    public UsuarioEntity update(UsuarioEntity usuarioEntity){return usuarioRepository.save(usuarioEntity);}

    public void delete(Long id){usuarioRepository.deleteById(id);}


}
