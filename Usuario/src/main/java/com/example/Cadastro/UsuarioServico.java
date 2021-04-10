/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Mateus
 */
@Service
@Transactional

public class UsuarioServico {
    
    
    @Autowired
    private UsuarioRepositorio user;
    
    public List<Usuario> listAll(){
        return user.findAll();
    }
    
    public void save(Usuario usuario){
        user.save(usuario);
    }
    
    public Usuario get(long id_usuario){
        return user.findById(id_usuario).get();
    }
    
    public void delete(long id_usuario){
        user.deleteById(id_usuario);
    }
    
}

