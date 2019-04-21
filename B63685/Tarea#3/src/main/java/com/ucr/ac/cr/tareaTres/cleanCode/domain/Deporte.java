package com.ucr.ac.cr.tareaTres.cleanCode.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Deporte {

	public String getNombreJugador();

	public String apellidosJugador();

	public int cantidadJugadores();

	public int edadJugador();

	public String reglasDelJuego();

	public int idDeporte();

	public ArrayList<Integer> listaAsientosEspectadores(ArrayList<Integer> asientos);

}
