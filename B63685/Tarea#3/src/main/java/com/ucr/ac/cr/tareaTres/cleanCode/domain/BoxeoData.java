package com.ucr.ac.cr.tareaTres.cleanCode.domain;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoxeoData {

	private ArrayList<Boxeo> boxeos;
	private ArrayList<String> contrincantes;
	private ArrayList<String> equipamientos;

	public BoxeoData(ArrayList boxeos) {

		if (boxeos == null)
			throw new RuntimeException("No puede ser nulo, debe agregar un campeonato de boxeo");

		if (contrincantes == null)
			throw new RuntimeException("contrincantes no puede ser nulo");

		this.boxeos = boxeos;
	}
	/*
	 * 
	 * Data/Object Anti-symmetric, Capítulo 6, Página 95
	 */

	// Orientado a objetos

	public void agregarBoxeador(Boxeo boxeo) {

		if (boxeo == null)
			throw new RuntimeException("El nombre no debe ser nulo.");

		else {
			boxeos.add(boxeo);
		}

	}

	/*
	 * Data Structures En este caso se irían agregando uno por uno lo jugadores, lo
	 * que expone los datos como se menciona en el libro. (capítulo 6, página 96,
	 * parrafo 2)
	 */
	public String agregaBoxeador() {

		int idBoxeo = 1;
		int cantidadJugadores = 10;
		String nombreJugador = "Alfonso";
		String apellidosJugador = "Jiménez";
		int edadJugador = 22;
		String reglasDelJuego = "No se permiten golpes bajos.";

		return " " + idBoxeo + " " + cantidadJugadores + " " + nombreJugador + apellidosJugador + " " + edadJugador
				+ " " + reglasDelJuego;

	}

	/*
	 * The law of demeter capítulo 6, página 97
	 */
	// Incorrecto
	public boolean compruebaNombre(boolean validaNombre) {

		Boxeo boxeo = new Boxeo();

		validaNombre = boxeo.getNombreJugador().trim().equals("");
		return validaNombre;

	}

	// Correcto
	/*
	 * Tomado de: Capítulo 6, Página 98
	 */
	public boolean validaNombre(boolean nombreValidado) {

		Boxeo boxeo = new Boxeo();

		String nombreBoxeador = boxeo.getNombreJugador();
		String quitaEspacios = nombreBoxeador.trim();
		nombreValidado = quitaEspacios.equals("");

		return nombreValidado;
	}

	/*
	 * Use Exceptions Rather Than Return Codes and Write Your Try-Catch-Finally
	 * Statement First Capítulo 7, página 104-105 En este caso se puede arrojar una
	 * exception si se pone null en alguno de los nombres
	 */

	public void agregarContrincantes(String contrincanteUno, String contrincanteDos) {

		Logger logger = Logger.getLogger("MyLogger");
		contrincanteUno = null;
		boolean sonElMismo = false;
		try {

			if (contrincanteUno.equals(contrincanteDos)) {

				logger.log(Level.INFO, "Los contrincantes tienen el mismo nombre");
			}

		} catch (Exception e) {
			logger.log(Level.WARNING, "ERROR, se insertó un nulo");
		} finally {
			logger.log(Level.INFO, "Contrincante Uno" + contrincanteUno + "ContrincanteDos" + contrincanteDos);
		}

	}

	// UseUncheckedExceptions capitulo 7, página 106
	public void uncheckedExceptions() {

		Logger logger = Logger.getLogger("MyLogger");
		int x = 0;
		int y = 10;
		int z = y / x;
		logger.log(Level.INFO, "" + z);
	}

	/*
	 * Provide Context with Exceptions capítulo 7, página 107
	 */
	public void calculoEquipoDeBoxeo(int guantes, int cascos) {

		Boxeo boxeo = new Boxeo();
		Logger logger = Logger.getLogger("MyLogger");
		int equipamiento = 0;
		try {
			equipamiento = (guantes + cascos) / boxeo.cantidadJugadores();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Se ha realizado una división entre 0!!!");
		} finally {
			logger.log(Level.INFO, "" + equipamiento);
		}

	}
	/*
	 * Don’t Pass Null capítulo 7, página 111 En este caso si se le inserta un nulo
	 * daría un NullPointerException
	 */

	public void agregarEquipamiento(String equipamiento) {

		equipamientos.add(equipamiento);

		

	}

}
