package com.ucr.ac.cr.tareaTres.cleanCode.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Boxeo implements Deporte{

	private int idBoxeo;
	private int cantidadJugadores;
	private String nombreJugador;
	private String apellidosJugador;
	private int edadJugador;
	private String reglasDelJuego;
	private int tamañoRing;
	

	/*
	Abstraction, capítulo 6, pagina 93
	
	En este caso se implemento deporte a boxeo. Una mala práctica hubiera sido no hacer una interface.
	Entonces en el caso de querer crear otro deporte (ejemplo football) se necesitaría repetir los 
	metodos, ya que todos comparten los mismos, por lo que lo correcto es implementar una interface.
	 
	 Nota: Esta clase sirve perfectamente para mostrar el ejemplo, sin embargo, se utlizará para
	 ejemplos posteriores.
	 */
	
	
	public Boxeo(int idBoxeo, int cantidadJugadores, String nombreJugador, String apellidosJugador, int edadJugador,
			String reglasDelJuego) {
		
		if(cantidadJugadores <= 0) throw new RuntimeException("La cantidad de jugadores debe ser mayor a 0.");
		if(nombreJugador == null || nombreJugador.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidosJugador == null || apellidosJugador.trim().equals("")) throw new RuntimeException("Los apellidos son requeridos");
		
		this.cantidadJugadores = cantidadJugadores;
		this.nombreJugador = nombreJugador;
		this.apellidosJugador = apellidosJugador;
		this.edadJugador = edadJugador;
		this.reglasDelJuego = reglasDelJuego;
		this.idBoxeo = idBoxeo;
		
		
	}
	
	public Boxeo() {
		
	}

	public String getNombreJugador() {
		
		return nombreJugador;
	}


	public String apellidosJugador() {
		
		return apellidosJugador;
	}


	public int cantidadJugadores() {
		
		return cantidadJugadores;
	}


	public int edadJugador() {
		
		return edadJugador;
	}
	
	public String reglasDelJuego() {
		
		return reglasDelJuego;
	}
	
	
	public int idDeporte() {
		return idBoxeo;
	}

	public int getTamañoRing() {
		return tamañoRing;
	}

	/*
	 Data Transfer Objects
	 Capítulo 6, page 100
	 */
	public void setTamañoRing(int tamañoRing) {
		
		if(cantidadJugadores <= 0) throw new RuntimeException("No se admiten numeros negativos.");
		
		this.tamañoRing = tamañoRing;
	}

	public ArrayList<Integer> listaAsientosEspectadores(ArrayList<Integer> asientos) {
		/*
		 Don’t Return Null capítulo 7 página 110
		 */
		//En este caso se retornó un nulo al implementar el método, si no se corrige puede ser un problema después
		if(asientos == null) {
			return null;
		}
		else {
			return asientos;
		}
	}

	
	
	
}
