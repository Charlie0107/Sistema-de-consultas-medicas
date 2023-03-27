package com.ulsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ulsa.dto.UsuarioRegistroDTO;
import com.ulsa.security.UserService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    
    private UserService userService;

    public RegistroUsuarioController(UserService userService){
        super();
        this.userService = userService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        userService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
