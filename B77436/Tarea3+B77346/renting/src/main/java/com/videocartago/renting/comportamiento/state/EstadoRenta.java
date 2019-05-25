package com.videocartago.renting.comportamiento.state;

public class EstadoRenta extends EstadoPeliculas {

	@Override
	public boolean rentar() {
		return true;
	}

	@Override
	public boolean devolver() {	
		return false;
	}

}
