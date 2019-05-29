package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

public class UsuarioAdmin extends Usuario{

	public UsuarioAdmin(int id, String avatar, String nombreUsuario, int cantidadMensajes, String hash)
			throws UsuarioException {
		super(id, avatar);
		// TODO Auto-generated constructor stub
	}

}
