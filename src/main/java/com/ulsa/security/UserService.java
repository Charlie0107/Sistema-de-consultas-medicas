package com.ulsa.security;

import com.ulsa.dto.UsuarioRegistroDTO;
import com.ulsa.entity.Usuario;

public interface UserService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
}
