package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class GrupoTest {

	@Test
	public void versionTest() {
		
	}
	
	@Test
	public void listaMiembrosTest() {
		Usuario usuario = new Usuario(null, null, "", null, 1, null);
		Grupo grupo = new Grupo("grupo1", 1, 1, usuario, usuario);
		List<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios.add(usuario);
		assertNotNull(grupo.getListaUsuarios());
	}
	
	@Test
	public void listaMensajesTest() throws InterruptedException {
		SynchronousQueue<Mensaje> listaMensajes = new SynchronousQueue<>();
		Mensaje mensaje = new Mensaje();
		mensaje.setContenido("Prueba");
		listaMensajes.put(mensaje);
		assertNotNull(listaMensajes);
	}

}
