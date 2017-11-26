package com.aewinformatica.brewer.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aewinformatica.brewer.model.Usuario;
import com.aewinformatica.brewer.repository.Usuarios;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	Usuarios usuarios;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		Optional<Usuario> usuarioOptional = usuarios.porEmailEAtivo(email);
		
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario e /ou Senha Incorretos"));
		return new UsuarioSistema(usuario, getPermissoes(usuario));
	}
	
	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		List<String> permissoes = usuarios.permissoes(usuario);
		permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
		
		return authorities;
	}

}