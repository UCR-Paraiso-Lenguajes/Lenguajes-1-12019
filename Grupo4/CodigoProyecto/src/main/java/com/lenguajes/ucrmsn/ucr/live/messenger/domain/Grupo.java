package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.MensajeException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.RolException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

public class Grupo {
	private int id;
	private static int cont=0;

	private String nombre;
	private int numeroParticipantes;
	private int cantidadMensajes;
	private ArrayList<Usuario> listaMiembros;
	private SynchronousQueue<Mensaje> listaMensajes;
	private Usuario administrador;
	private Usuario dueno;
	
	public Grupo( String nombre, int numeroParticipantes, int cantidadMensajes, Usuario administrador,
			Usuario dueno)throws GrupoException {
		super();
		if (nombre==null && administrador==null && dueno==null) {
			throw new GrupoException("El Grupo esta vacio");
		}
		cont=cont+1;

		this.id = cont;
		this.nombre = nombre;
		this.numeroParticipantes = numeroParticipantes;
		this.cantidadMensajes = cantidadMensajes;
		this.administrador = administrador;
		this.dueno = dueno;
		listaMiembros=new ArrayList<Usuario>();
		listaMensajes=new SynchronousQueue<Mensaje>();
	}
	
	public boolean nuevoMiembro(Usuario usuario) throws UsuarioException {
		if (listaMiembros.contains(usuario)) {
			throw new UsuarioException("El usuario ya existe en el grupo.");		
		}else 
			listaMiembros.add(usuario);
		
		return true;

	}
	public void eliminarMiembro(Usuario usuario) throws UsuarioException {
		if (!listaMiembros.contains(usuario)) {
			throw new UsuarioException("El usuario no existe");		
		}else 
		listaMiembros.remove(usuario);
	}
	public boolean promoverMiembro(Usuario usuario) throws UsuarioException, RolException {
		if (!listaMiembros.contains(usuario)) {
			throw new UsuarioException("El usuario no existe");		
		}else {
		Rol rol=new Rol(1,"Administrador");
		usuario.nuevoRol(rol);
		}
		return true;
	}
	public boolean mandarMensaje(Mensaje mensaje) {
		if (mensaje.getContenido().equals(null)) {
			throw new RuntimeException("Mensaje Vacio");		
		}else {
		try {
		
			listaMensajes.put(mensaje);
		} catch (InterruptedException e) {
			throw new MensajeException("Error al mandar mensaje");
		}
		}
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
	public SynchronousQueue getListaMensajes() {
		return listaMensajes;
	}
	public void setListaMensajes(SynchronousQueue listaMensajes) {
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
