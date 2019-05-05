package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Grupo {
	private int id;
	private String nombre;
	private int numeroParticipantes;
	private int cantidadMensajes;
	private ArrayList<Usuario> listaMiembros;
	private Stack listaMensajes;
	private Usuario administrador;
	private Usuario dueno;
	
	public Grupo(int id, String nombre, int numeroParticipantes, int cantidadMensajes, Usuario administrador,
			Usuario dueno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroParticipantes = numeroParticipantes;
		this.cantidadMensajes = cantidadMensajes;
		this.administrador = administrador;
		this.dueno = dueno;
		listaMiembros=new ArrayList<Usuario>();
		listaMensajes=new Stack<Mensaje>();
	}
	public boolean nuevoMiembro(Usuario usuario) {
		listaMiembros.add(usuario);
		return true;
	}
	public void eliminarMiembro(Usuario usuario) {
		listaMiembros.remove(usuario);
	}
	public boolean promoverMiembro(Usuario usuario) {
		Rol rol=new Rol(1,"Administrador");
		usuario.nuevoRol(rol);
		return true;
	}
	public boolean mandarMensaje(Mensaje mensaje) {
		listaMensajes.add(mensaje);
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}
	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
	public int getCantidadMensajes() {
		return cantidadMensajes;
	}
	public void setCantidadMensajes(int cantidadMensajes) {
		this.cantidadMensajes = cantidadMensajes;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaMiembros;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaMiembros = listaUsuarios;
	}
	public Stack getListaMensajes() {
		return listaMensajes;
	}
	public void setListaMensajes(Stack listaMensajes) {
		this.listaMensajes = listaMensajes;
	}
	public Usuario getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}
	public Usuario getDueno() {
		return dueno;
	}
	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}
	
}
