package com.videocartago.renting.exception;

import org.junit.Test;

public class RentingExceptionTest {

	
	boolean condicion = true;
	@Test
	public void test() {
	
		//Probando la excepcion
		if (condicion) {
			condicion = false;
			throw new RentingException("Exception Prueba");
		}
		
		
		
	}

}
