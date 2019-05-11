package com.videocartago.renting.form;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaFormTest {
	@Autowired
	private PeliculaForm peliculaForm;
	
	@Test
	public void peliculaForm() {
		peliculaForm= new PeliculaForm();
		peliculaForm.setCodGenero(12);
		peliculaForm.setCodPelicula(1222);
		peliculaForm.setTitulo("El rey");
		peliculaForm.setTotalPeliculas(12);
		peliculaForm.setSubtitulada(false);
		peliculaForm.setEstreno(true);
		
		peliculaForm.getCodGenero();
		peliculaForm.getCodPelicula();
		peliculaForm.getTitulo();
		peliculaForm.getTotalPeliculas();
		peliculaForm.isEstreno();
		peliculaForm.isSubtitulada();
		
		assertNotNull(peliculaForm);
		assertTrue(!peliculaForm.equals(""));
	}
	
	
}
