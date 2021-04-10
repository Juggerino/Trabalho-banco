/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Mateus
 */
@Controller

public class AppController {
    
    @Autowired
    private UsuarioServico service;
    
    @RequestMapping("/")
    public String viewHomePage(Model model){
       List<Usuario>listUsuario = service.listAll();
       model.addAttribute("listUsuario",listUsuario);
       
       return "index";
    }
    
    @RequestMapping("/new")
    public String showNewContPage(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        
        return "cadastro";  
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUsuario(@ModelAttribute("usuario")Usuario usuario){
    
        service.save(usuario);
        
        return "redirect:/";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
    