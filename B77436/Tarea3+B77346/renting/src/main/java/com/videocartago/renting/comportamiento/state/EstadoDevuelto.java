package com.videocartago.renting.comportamiento.state;

public class EstadoDevuelto extends EstadoPeliculas {

	@Override
	public boolean rentar() {
		return false;
	}

	@Override
	public boolean devolver() {
		return true;
	}

}
