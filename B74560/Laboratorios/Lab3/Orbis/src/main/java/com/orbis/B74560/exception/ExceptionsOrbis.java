package com.orbis.B74560.exception;

@SuppressWarnings("serial")
public class ExceptionsOrbis extends NumberFormatException {

	public ExceptionsOrbis() {
		super();
	}

	public ExceptionsOrbis(String s) {
		super(s);
	}

	@SuppressWarnings("unused")
	public static boolean verificarStringNumero(String s) {
		
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
		
	}// fin del verificarStringNumero

}// fin del ExceptionsOrbis
