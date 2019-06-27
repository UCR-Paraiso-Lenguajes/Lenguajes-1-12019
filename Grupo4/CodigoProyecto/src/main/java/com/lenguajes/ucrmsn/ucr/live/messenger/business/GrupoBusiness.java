package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;

@Service
public class GrupoBusiness {

	@Transactional
	public Usuario create(Usuario usuario) {
		
		if (usuario == null) 
			throw new RuntimeException("El usuario es requerido");
		if (usuario.getNombreUsuario() == null) 
			throw new RuntimeException("El nombre de usuario es requerido");
		if (usuario.getListaRoles().isEmpty())
			throw new RuntimeException("El rol es requerido");
		return usuario;
	}
}
