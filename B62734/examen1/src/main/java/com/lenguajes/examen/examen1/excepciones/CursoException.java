package com.lenguajes.examen.examen1.excepciones;

public class CursoException extends RuntimeException{
	private String mensaje="";

	public CursoException(String mensaje) {
		super();
		if (mensaje!=null) {
			this.mensaje = mensaje;

		}else {
			throw new RuntimeException("La Excepcion necesita un mensaje");
		}
	}

	@Override
	public String toString() {
		return mensaje ;
	}
}