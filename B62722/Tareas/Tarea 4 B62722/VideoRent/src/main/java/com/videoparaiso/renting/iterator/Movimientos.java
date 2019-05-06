package com.videoparaiso.renting.iterator;

import com.videoparaiso.renting.domain.EstadoPelicula;
import com.videoparaiso.renting.domain.Pelicula;

public class Movimientos {

	private int fecha;
	private EstadoPelicula estado;
	private Pelicula pelicula;

	public Movimientos(int fecha, EstadoPelicula estado, Pelicula pelicula) {
		this.fecha = fecha;
		this.estado = estado;
		this.pelicula = pelicula;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public EstadoPelicula getEstado() {
		return estado;
	}

	public void setEstado(EstadoPelicula estado) {
		this.estado = estado;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
}
