package com.lenguajes.ucrmsn.ucr.live.messenger.excepciones;

public class MensajeException extends RuntimeException{
	private String mensaje="";

	public MensajeException(String mensaje) {
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