package com.videocartago.renting.patronIterator;

public class IteradorConcreto implements Iterador {

	private AgregadoConcreto agregado;
	private int posicion_actual = 0;

	public IteradorConcreto(AgregadoConcreto agregado) {

		this.agregado = agregado;

	}

	@Override
	public Object primero() {

		Object obj = null;

		if (this.agregado.datosPelicula.isEmpty() == false) {
			this.posicion_actual = 0;
			obj = this.agregado.datosPelicula.firstElement();
		}

		return obj;
	}

	@Override
	public Object siguiente() {

		Object obj = null;

		if ((this.posicion_actual) < this.agregado.datosPelicula.size()) {
			obj = this.agregado.datosPelicula.elementAt(this.posicion_actual);
			this.posicion_actual = this.posicion_actual + 1;
		}

		return obj;
	}

	@Override
	public boolean hayMas() {

		boolean condicion = false;

		if (this.posicion_actual < (this.agregado.datosPelicula.size())) {
			condicion = true;
		}

		return condicion;
	}

	@Override
	public Object actual() {

		Object obj = null;

		if (this.posicion_actual < this.agregado.datosPelicula.size()) {
			obj = this.agregado.datosPelicula.elementAt(this.posicion_actual);
		}

		return obj;
	}

	@Override
	public Object lista() {

		Object obj = null;

		obj = "Lista: " + this.agregado.datosPelicula.toString() + "\n";

		return obj;
	}
}