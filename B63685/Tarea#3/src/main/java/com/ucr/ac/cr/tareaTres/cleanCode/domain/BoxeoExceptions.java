package com.ucr.ac.cr.tareaTres.cleanCode.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BoxeoExceptions extends Exception {

	public BoxeoExceptions() {
		super();
	}

	public BoxeoExceptions(String message) {
		super(message);
	}

	/*
	 * Define Exception Classes in Terms of a Caller’s Needs capítulo 7, página 107
	 */
	public void calculoEquipamiento(int guantes, int cascos) throws BoxeoExceptions {

		Boxeo boxeo = new Boxeo();
		Logger logger = Logger.getLogger("MyLogger");
		int equipamiento = 0;
		try {
			equipamiento = (guantes + cascos) / boxeo.cantidadJugadores();
		} finally {
			logger.log(Level.INFO, "" + equipamiento);
		}
	}
}
