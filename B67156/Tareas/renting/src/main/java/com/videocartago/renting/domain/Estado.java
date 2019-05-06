package com.videocartago.renting.domain;

public interface Estado {
	
	enum EstadoEnum{
		Rentada,
		Disponible
		
	}
	
	public EstadoEnum definirEstado();

}
