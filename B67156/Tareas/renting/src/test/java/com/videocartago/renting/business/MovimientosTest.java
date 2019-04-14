package com.videocartago.renting.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Movimientos;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientosTest {
	@Test
	public void crearMovimientos() {
		RegistraMovimientos registro = new RegistraMovimientos();
		ArrayList<Movimientos> movimientos = new ArrayList<Movimientos>();
		for(int i = 0; i <= 5; i++ ) {
			Pelicula pelicula = new Pelicula(i, "Pelicula"+i, 10, true, true, new Genero(i,"Genero"),"categoria","estado");
			movimientos = registro.registrarMovimientos(new Movimientos(""+i, "El estado"+i,pelicula));
		}
			
		Iterator iterator = movimientos.iterator();	
		while(iterator.hasNext()) {
			Logger.getLogger(getClass().getName()).log(
			      Level.INFO, iterator.next().toString());
		}
	}
}
