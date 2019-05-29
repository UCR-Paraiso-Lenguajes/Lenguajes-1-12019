package com.lenguajes.examen.examen1.excepciones;

public class RequisitoException extends RuntimeException{
	private String mensaje="";

	public RequisitoException(String mensaje) {
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