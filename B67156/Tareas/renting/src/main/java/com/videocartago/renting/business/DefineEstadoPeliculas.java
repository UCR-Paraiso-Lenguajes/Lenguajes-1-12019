package com.videocartago.renting.business;

import com.videocartago.renting.domain.Estado;

public class DefineEstadoPeliculas {
	
	private Estado estado;
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String definirEstado() {
		return estado.definirEstado();
	}

}
