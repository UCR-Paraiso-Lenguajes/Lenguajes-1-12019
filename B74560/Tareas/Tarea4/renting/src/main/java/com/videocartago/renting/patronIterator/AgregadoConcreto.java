package com.videocartago.renting.patronIterator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class AgregadoConcreto implements Agregado {

	protected Vector<String> datosPelicula = new Vector<String>();
	private int posicion_actual = 0;

	public AgregadoConcreto() {
	}

	@Override
	public Iterador getIterador() {
		return new IteradorConcreto(this);
	}

	public String obtenerFechaActual() {

		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy");
		return " Fecha: " + hourFormat.format(date);

	}

	public String obtenerHoraActual() {

		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		return " Hora: " + hourFormat.format(date);

	}

	public void llenarIterador(String estadoPelicula, String nombrePelicula) {

		this.datosPelicula.add(posicion_actual,
				new String(estadoPelicula + ' ' + nombrePelicula + ' ' + obtenerHoraActual() + obtenerFechaActual()));
		posicion_actual++;

	}
}
