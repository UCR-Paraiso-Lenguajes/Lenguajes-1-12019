package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;
import java.util.List;

public class EnlacesEnviados {

	private List<Enlace> enlaces = new ArrayList<>();
	private static EnlacesEnviados enlacesEnviados;

	private EnlacesEnviados() {
	}

	public static EnlacesEnviados getInstancia() {
		enlacesEnviados = new EnlacesEnviados();
		return enlacesEnviados;
	}
	
	public void agregar(Enlace enlace) {
		if (enlace != null) {
			enlaces.add(enlace);
		} else {
			throw new RuntimeException("El enlace no puede ser agregado");
		}
	}
	
	public void eliminar(Enlace enlace) {
		if (enlaces.contains(enlace)) {
			enlaces.remove(enlace);
		} else {
			throw new RuntimeException("El enlace no puede ser eliminado");
		}
	}
}
