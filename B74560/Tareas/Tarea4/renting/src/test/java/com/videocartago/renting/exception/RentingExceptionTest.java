package com.videocartago.renting.exception;

import static org.junit.Assert.*;
import org.junit.Test;

public class RentingExceptionTest {

	
	boolean condicion = true;
	@Test
	public void test() {
	
		//Probando la excepcion
		if (condicion) {
			condicion = false;
			assertTrue(true);
			throw new RentingException("Exception Prueba");
			
		}
		
		
		
	}

}
