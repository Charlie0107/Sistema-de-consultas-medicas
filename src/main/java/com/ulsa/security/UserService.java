package com.ulsa.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ulsa.dto.UsuarioRegistroDTO;
import com.ulsa.entity.Usuario;

public interface UserService extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();
    
}
