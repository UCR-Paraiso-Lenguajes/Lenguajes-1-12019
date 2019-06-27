package com.examen1.exceptions;

public class Exceptions {
	
	String mensaje = null;

	public String cursoRepetido() {
		
		mensaje = "Curso repetido, no puedo ingresarse.";
		
		return mensaje;
	}
	
	public String cursoInsertado() {
		
		mensaje = "Curso insertado correctamente.";
		
		return mensaje;
	}
	
	public String planEstudiosRepetido() {
		
		mensaje = "Plan de estudios repetido, no pudo ingresarse.";
	
	 return mensaje;
	}
	
	public String planEstudiosInsertado() {
		
		mensaje = "Plan de estudios insertado correctamente.";
	
	 return mensaje;
	}

}
