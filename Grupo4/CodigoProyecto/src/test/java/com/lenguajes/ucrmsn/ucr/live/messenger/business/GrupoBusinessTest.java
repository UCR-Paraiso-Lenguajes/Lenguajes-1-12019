package com.lenguajes.ucrmsn.ucr.live.messenger.business;

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
public class GrupoBusinessTest {


	
	@Test
	public void invitarTest() throws GrupoException, UsuarioException {
		GrupoBusiness grupoBusiness = new  GrupoBusiness();
		grupoBusiness.crear(new Usuario(0, null, null, 0, null));
        
	}

}
