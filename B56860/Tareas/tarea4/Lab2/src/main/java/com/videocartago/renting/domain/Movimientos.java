package com.videocartago.renting.domain;

import java.util.*;

public class Movimientos implements Iterator<Pelicula>{

	private Date date;
	private String estado;
	private Pelicula pelicula;
	private List<Movimientos> movs;
	private int pos;
	
	public Movimientos(Pelicula peli) {
		if(peli == null) throw new RuntimeException("La pelicula no puede ser vacía");
		this.date = new Date();
		this.estado = peli.getEstado();
		this.pelicula = peli;
	}
	
	@Override
	public boolean hasNext() {
		return pos+1 == movs.size();
	}

	@Override
	public Pelicula next() {
		Pelicula peli = movs.get(pos).pelicula;
		pos++;
		return peli;
	}


	
}
