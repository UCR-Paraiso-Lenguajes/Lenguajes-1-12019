package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class HashEnviados {
	
	private static ArrayList<String> hashs ;
	private static HashEnviados hashsEnviados;

	private HashEnviados() {
	hashs=new ArrayList<String>();
	}

	public static HashEnviados getInstancia() {
		hashsEnviados = new HashEnviados();
		return hashsEnviados;
	}
	
	public void agregar(String hash) {
		if (hash != null) {
			hashs.add(hash);
		} else {
			throw new RuntimeException("El enlace no puede ser agregado");
		}
	}
	
	public void eliminar(String hash) {
		if (hashs.contains(hash)) {
			hashs.remove(hash);
		} else {
			throw new RuntimeException("El enlace no puede ser eliminado");
		}
	}
	public boolean contiene(String hash) {
		return hashs.contains(hash);
	}
}
