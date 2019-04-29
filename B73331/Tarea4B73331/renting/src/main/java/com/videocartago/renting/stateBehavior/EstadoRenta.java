package com.videocartago.renting.stateBehavior;

public class EstadoRenta extends EstadoPelicula{

	@Override
	public boolean rentar() {
		return false;
	}

	@Override
	public boolean devolver() {
		return true;
	}

}
