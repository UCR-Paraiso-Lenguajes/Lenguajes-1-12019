package com.videocartago.renting.domain;


public class Rentada implements Estado{

	
	@Override
	public EstadoEnum definirEstado() {
		return EstadoEnum.Rentada;
	}

	
}
