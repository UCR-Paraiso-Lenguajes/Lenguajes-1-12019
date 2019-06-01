package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.UsuarioException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioBusinessTest {

	@Test
	public void asignarNombreYAvatarTest() throws GrupoException, UsuarioException {
		UsuarioBusiness business = new UsuarioBusiness();
		Usuario usuario = new Usuario( null);
		Grupo grupo = new Grupo( "Grupo", 0, 0, usuario, usuario);
		business.asignarNombreYAvatarUsuarioGrupo(usuario, grupo);
		assertNotNull(usuario);
	}
	
	@Test
	public void invitarTest() {
		UsuarioBusiness business = new UsuarioBusiness();
		business.invitar("sergioss1997@gmail.com");
	}

}
