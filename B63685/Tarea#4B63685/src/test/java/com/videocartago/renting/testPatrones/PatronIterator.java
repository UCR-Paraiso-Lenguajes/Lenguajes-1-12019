package com.videocartago.renting.testPatrones;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.patronIterator.DatosMovimiento;
import com.videocartago.renting.patronIterator.Movimientos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatronIterator {

	@Test
	public void test() {

	Movimientos movimientos = new Movimientos();
	DatosMovimiento datosMovimiento = new DatosMovimiento("3/14/2019", "rentada");
	movimientos.add(datosMovimiento);
	
	Iterator<DatosMovimiento> iter = movimientos.iterator();
	
	while(iter.hasNext()) {
		DatosMovimiento datosMovimientos = (DatosMovimiento) iter.next();
		
		Logger.getLogger(getClass().getName()).log(Level.INFO, "movimientos"+ datosMovimientos);

	}
	
	}

}
