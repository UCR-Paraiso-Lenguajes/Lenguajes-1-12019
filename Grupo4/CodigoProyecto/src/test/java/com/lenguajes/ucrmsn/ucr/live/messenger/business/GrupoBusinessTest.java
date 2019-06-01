package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrupoBusinessTest {

	@Autowired
	private GrupoBusiness grupoBusiness;
	
	@Test
	public void unirseTest() {
		GrupoBusiness business = new GrupoBusiness();
		Usuario usuario = new Usuario("abc");
		Grupo grupo = new Grupo("grupo1", 2, 1, usuario, usuario);
		business.unirse(usuario, grupo);
		assertTrue(grupo.getListaMensajes().contains(usuario));
	}
	
	@Test
	public void crearTest() {
		
		GrupoBusiness business = new GrupoBusiness();
		Usuario usuario = new Usuario("abc");
		business.crear(usuario);
		
	}

	@Test
	public void invitarTest() {
		
		
	}
}
