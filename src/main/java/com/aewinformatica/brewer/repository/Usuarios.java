package com.aewinformatica.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aewinformatica.brewer.model.Usuario;
import com.aewinformatica.brewer.repository.helper.usuario.UsuariosQueries;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);
	public List<Usuario> findByCodigoIn(Long[] codigos);
}
