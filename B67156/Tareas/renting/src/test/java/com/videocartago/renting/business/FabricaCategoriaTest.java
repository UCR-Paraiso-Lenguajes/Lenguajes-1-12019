package com.videocartago.renting.business;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.business.FabricaTipoPelicula;
import com.videocartago.renting.domain.EnumGenero;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.PeliculaAbstract;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FabricaCategoriaTest {
	
	@Test
	public void FabricaCategoria() {
		Genero genero0 = new Genero(0, "Terror",EnumGenero.TERROR);
		FabricaTipoPelicula fabrica = new FabricaTipoPelicula();
		PeliculaAbstract fabricaPelicula1 = fabrica.getCategoria(genero0);
		
		Genero genero1 = new Genero(1, "Suspenso",EnumGenero.SUSPENSO);
		PeliculaAbstract fabricaPelicula2 = fabrica.getCategoria(genero1);
		
		Genero genero2 = new Genero(2, "todo publico",EnumGenero.TODO_PUBLICO);
		PeliculaAbstract fabricaPelicula3 = fabrica.getCategoria(genero2);
		
		Genero genero3 = new Genero(3, "sin definir",EnumGenero.SIN_DEFINIR);
		PeliculaAbstract fabricaPelicula4 = fabrica.getCategoria(genero3);
		
		assertNotNull("pelicula vacía",fabricaPelicula1);
		assertNotNull(fabricaPelicula2);
		assertNotNull(fabricaPelicula3);
		assertNotNull(fabricaPelicula4);
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, fabricaPelicula1.toString());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, fabricaPelicula2.toString());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, fabricaPelicula3.toString());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, fabricaPelicula4.toString());
	}


}
