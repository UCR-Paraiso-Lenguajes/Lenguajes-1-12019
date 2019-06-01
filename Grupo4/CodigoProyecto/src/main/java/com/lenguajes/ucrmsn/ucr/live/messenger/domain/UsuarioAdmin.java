package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

public class UsuarioAdmin extends Usuario{

	public UsuarioAdmin(String hash, String avatar, String nombreUsuario, ArrayList<Rol> listaRoles,
			int cantidadMensajes, ArrayList<Grupo> listaGrupos) {
		super(hash, avatar, nombreUsuario, listaRoles, cantidadMensajes, listaGrupos);
		// TODO Auto-generated constructor stub
	}

	


}
