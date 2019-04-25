package com.videocartago.renting.domain;


public class Disponible implements Estado{

	@Override
	public EstadoEnum definirEstado() {
		return EstadoEnum.Disponible;	
	}


}
