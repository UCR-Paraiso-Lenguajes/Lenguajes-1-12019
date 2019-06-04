package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.sql.Date;
import java.util.ArrayList;

public class Metricas {
	
	private static Metricas metricas;
	
	
	private int cantidadRooms;
	private int cantidadUsuarios;
	private int promedioUsuariosGrupo;
	private Date fechaUltimoMensaje;
	private Date fechaPrimerLogin;
	private	Usuario usuarioMasMensajes;
	private Mensaje mensajeLargo;
	private Grupo ultimoGrupo;
	private Grupo grupoMasMensajes;
	
	private Metricas() {
		
	}

	public static Metricas getInstancia() {
		metricas = new Metricas();
		return metricas;
	}
	
	public Metricas(int cantidadRooms, int cantidadUsuarios, int promedioUsuariosGrupo, Date fechaUltimoMensaje,
			Date fechaPrimerLogin, Usuario usuarioMasMensajes, Mensaje mensajeLargo, Grupo ultimoGrupo,
			Grupo grupoMasMensajes) {
		super();
		this.cantidadRooms = cantidadRooms;
		this.cantidadUsuarios = cantidadUsuarios;
		this.promedioUsuariosGrupo = promedioUsuariosGrupo;
		this.fechaUltimoMensaje = fechaUltimoMensaje;
		this.fechaPrimerLogin = fechaPrimerLogin;
		this.usuarioMasMensajes = usuarioMasMensajes;
		this.mensajeLargo = mensajeLargo;
		this.ultimoGrupo = ultimoGrupo;
		this.grupoMasMensajes = grupoMasMensajes;
	}
	
	public int getCantidadRooms() {
		return cantidadRooms;
	}

	public int getCantidadUsuarios() {
		return cantidadUsuarios;
	}

	public int getPromedioUsuariosGrupo() {
		return promedioUsuariosGrupo;
	}

	public Date getFechaUltimoMensaje() {
		return fechaUltimoMensaje;
	}

	public Date getFechaPrimerLogin() {
		return fechaPrimerLogin;
	}

	public Usuario getUsuarioMasMensajes() {
		return usuarioMasMensajes;
	}

	public Mensaje getMensajeLargo() {
		return mensajeLargo;
	}

	public Grupo getUltimoGrupo() {
		return ultimoGrupo;
	}

	public Grupo getGrupoMasMensajes() {
		return grupoMasMensajes;
	}

	public void cantidadRooms() {
		cantidadRooms=cantidadRooms+1;
	}
	public void cantidadUsuarios() {
		cantidadUsuarios=cantidadUsuarios+1;
	}
	public void promedioUsuariosGrupo() {
		
	}
	public void  fechaPrimerLogin(Date fecha) {
		if (fechaPrimerLogin.compareTo(fecha)>0) {
			fechaPrimerLogin=fecha;
		}
	}
	public void  fechaUltimoMensaje(Date fecha) {
		if (fechaUltimoMensaje.compareTo(fecha)<0) {
			fechaUltimoMensaje=fecha;
		}
	}
	public void usuarioMasMensajes(Usuario usuario) {
		if (usuarioMasMensajes.getCantidadMensajes()<usuario.getCantidadMensajes()) {
			usuarioMasMensajes=usuario;
		}
	}
	public void mensajeLargo(Mensaje mensaje) {
	if (mensajeLargo.getContenido().length()<mensaje.getContenido().length()) {
		mensajeLargo=mensaje;
	}
	}
	public void ultimoGrupo(Grupo grupo) {
		ultimoGrupo=grupo;
	}
	public void grupoMasMensajes(Grupo grupo) {
		if (grupoMasMensajes.getCantidadMensajes()<grupo.getCantidadMensajes()) {
			grupoMasMensajes=grupo;
		}
	}
	
}
