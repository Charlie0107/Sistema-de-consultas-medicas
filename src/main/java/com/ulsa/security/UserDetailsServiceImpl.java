package com.ulsa.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulsa.dto.UsuarioRegistroDTO;
import com.ulsa.entity.Rol;
import com.ulsa.entity.Usuario;
import com.ulsa.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
	
			Usuario usuario = new Usuario(registroDTO.getNombre(),
			registroDTO.getApellido(),registroDTO.getEmail(),
			registroDTO.getPassword(),Arrays.asList(new Rol("USER_ROL")));
			return usuarioRepository.save(usuario);
	}


	
	/*
	public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.getUsuarioByEmail(email);
		if(usuario == null){
            throw new UsernameNotFoundException("No se pudo encontrar el usuario");
        }
		return new MyUserDetails(usuario);
	}
	*/

}
