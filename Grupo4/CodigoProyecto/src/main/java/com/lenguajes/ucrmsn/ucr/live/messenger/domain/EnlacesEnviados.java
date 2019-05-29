package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EnlacesEnviados {
	
	private List<Enlace> enlaces ;
	private static EnlacesEnviados enlacesEnviados;

	private EnlacesEnviados() {
	enlaces=new ArrayList<Enlace>();
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
