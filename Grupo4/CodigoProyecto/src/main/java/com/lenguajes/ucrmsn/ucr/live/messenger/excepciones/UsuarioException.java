package com.lenguajes.ucrmsn.ucr.live.messenger.excepciones;

public class UsuarioException extends Exception{
	private String mensaje="";

	public UsuarioException(String mensaje) {
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
