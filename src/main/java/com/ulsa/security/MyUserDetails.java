package com.ulsa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ulsa.entity.Rol;
import com.ulsa.entity.Usuario;

public class MyUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	public MyUserDetails(Usuario usuario) {
		this.usuario=usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Rol> roles = usuario.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Rol rol : roles){
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return usuario.isEnabled();
	}

}
