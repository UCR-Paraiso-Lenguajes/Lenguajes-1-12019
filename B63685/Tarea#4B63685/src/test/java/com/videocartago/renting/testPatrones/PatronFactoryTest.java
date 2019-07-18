package com.videocartago.renting.testPatrones;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videcartago.renting.domain.Genero;
import com.videocartago.renting.factory.Clasificacion;
import com.videocartago.renting.factory.PeliculaFactory;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PatronFactoryTest {

	@Test
	public void test() {
		
		
		Genero terror = new Genero(1, "Terror");
		Genero suspenso = new Genero(2, "Suspenso");
		Genero todoPublico = new Genero(3, "Comedia");

		PeliculaFactory peliculaFactory = new PeliculaFactory();
		
		Clasificacion clasificacionMayoresDeDieciocho = peliculaFactory.getTipoClasificacion(terror.getNombreGenero());
		Clasificacion clasificacionMayoresDeDoce = peliculaFactory.getTipoClasificacion(suspenso.getNombreGenero());
		Clasificacion clasificacionTodoPublico = peliculaFactory.getTipoClasificacion(todoPublico.getNombreGenero());
		
		
		Logger.getLogger(getClass().getName()).log(Level.INFO, clasificacionMayoresDeDieciocho.getPelicula().getTitulo() + "\n" + 		
		clasificacionMayoresDeDoce.getPelicula().getTitulo()+
		clasificacionTodoPublico.getPelicula().getTitulo());


		
	}

}
