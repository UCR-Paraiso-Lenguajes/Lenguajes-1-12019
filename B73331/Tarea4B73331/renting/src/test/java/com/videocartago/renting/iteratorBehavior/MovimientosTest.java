package com.videocartago.renting.iteratorBehavior;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientosTest {
	Movimientos movimientos;

	private void fillIterator() {
		AgregadoIterator agregarMovimiento = new AgregadoIterator();
		movimientos = agregarMovimiento.getIterador();
		// Crear el objeto agregado que contiene la lista (un vector en este ejemplo)
		for (int i = 0; i < 4; i++) {
			agregarMovimiento.agregar("Rentada" + i, "IT");
		}

	}

	@Test
	public void pruebaHayMas() {
		fillIterator();
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/-------------------------------------------------");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/Prueba HayMas");
		while (movimientos.hayMas()) {
			Logger.getLogger(getClass().getName()).log(Level.INFO, "" + movimientos.siguiente());
		}
	}

	@Test
	public void pruebaActual() {
		fillIterator();
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/-------------------------------------------------");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/Prueba Actual");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "Movimineto actual: " + movimientos.actual());
	}

	@Test
	public void pruebaSiguiente() {
		fillIterator();
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/-------------------------------------------------");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/Prueba Siguiente");
		while (movimientos.hayMas()) {
			Logger.getLogger(getClass().getName()).log(Level.INFO, "" + movimientos.siguiente());
		}
	}

	@Test
	public void pruebaPrimero() {
		fillIterator();
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/-------------------------------------------------");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "/Prueba Primero");
		Logger.getLogger(getClass().getName()).log(Level.INFO, "" + movimientos.primero());

	}
}
