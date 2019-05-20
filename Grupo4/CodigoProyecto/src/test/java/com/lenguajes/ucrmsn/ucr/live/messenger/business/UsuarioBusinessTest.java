package com.lenguajes.ucrmsn.ucr.live.messenger.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;
import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.GrupoException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioBusinessTest {

	@Test
	public void test() throws GrupoException {
		UsuarioBusiness business = new UsuarioBusiness();
		Usuario usuario = new Usuario(0, null, null, 0, null);
		Grupo grupo = new Grupo(0, "Grupo", 0, 0, usuario, usuario);
		business.llenarLista();
		business.asignarNombreYAvatar(usuario, grupo);
		assertNotNull(usuario);
	}

}
