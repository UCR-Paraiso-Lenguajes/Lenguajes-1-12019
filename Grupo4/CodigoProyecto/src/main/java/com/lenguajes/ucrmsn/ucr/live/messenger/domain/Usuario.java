package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.awt.Image;
import java.util.ArrayList;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

public class Usuario {
	private int id;
	private static int cont=0;
	private String hash;
	private String avatar;
	private String nombreUsuario;
	private ArrayList<Rol> listaRoles;
	private int cantidadMensajes;
	private ArrayList<Grupo> listaGrupos;
	
	
	public Usuario(String hash) throws UsuarioException {
		super();
		cont=cont+1;
		this.id = cont;
		this.cantidadMensajes = 0;
		listaRoles=new ArrayList<Rol>();
		listaGrupos=new ArrayList<Grupo>();
		this.hash=hash;
	}
	
	public Usuario( String hash, String avatar, String nombreUsuario, ArrayList<Rol> listaRoles,
			int cantidadMensajes, ArrayList<Grupo> listaGrupos) {
		super();
		cont=cont+1;
		this.id = cont;
		this.hash = hash;
		this.avatar = avatar;
		this.nombreUsuario = nombreUsuario;
		this.listaRoles = listaRoles;
		this.cantidadMensajes = cantidadMensajes;
		this.listaGrupos = listaGrupos;
	}

	public void nuevoRol(Rol rol) {
		if (!listaRoles.contains(rol)) {
			listaRoles.add(rol);
		}
		throw new RuntimeException("El Usuario ya tiene el rol");		

	}
	public void nuevoGrupo(Grupo grupo) {
		if (!listaGrupos.contains(grupo)) {
			listaGrupos.add(grupo);
		}else {
			throw new RuntimeException("El Usuario ya esta en el grupo");		
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public ArrayList<Rol> getListaRoles() {
		return listaRoles;
	}
	public void setListaRoles(ArrayList<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}
	public int getCantidadMensajes() {
		return cantidadMensajes;
	}
	public void setCantidadMensajes(int cantidadMensajes) {
		this.cantidadMensajes = cantidadMensajes;
	}
	public ArrayList<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(ArrayList<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
}
