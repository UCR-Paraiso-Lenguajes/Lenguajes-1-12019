package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrupoBusinessTest {
	
	@Test
	public void unirseTest() {
		GrupoBusiness business = new GrupoBusiness();
		Usuario usuario = new Usuario(null, null, "usuario1", null, 1, null);
		Grupo grupo = new Grupo("grupo1", 2, 1, usuario, usuario);
		business.unirse(usuario, grupo);
		assertTrue(grupo.getListaUsuarios().contains(usuario));
	}

	@Test
	public void getVersionTest() {
		
	}
	
	@Test
	public void getMessagesFromTest() {
		
	}
}
