package com.videocartago.renting.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class IteratorTest {
	
	@Test
	public void test() {


		try {
			
			MovimientAgregadoConcreto agregado = new MovimientAgregadoConcreto();
			Iterador iterador = agregado.getIterador();
			agregado = new MovimientAgregadoConcreto();
			agregado.llenar("Rentada", "Los Vengadores");
			agregado.llenar("Disponible", "Hulk");
			agregado.llenar("Rentada", "Los perritos");
			iterador = agregado.getIterador();
			iterador.siguiente();
			iterador.siguiente();
			iterador.primero();
			
			while (iterador.hayMas() == true) {
				Logger.getLogger(getClass().getName()).log(Level.INFO, (String) iterador.siguiente() );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
