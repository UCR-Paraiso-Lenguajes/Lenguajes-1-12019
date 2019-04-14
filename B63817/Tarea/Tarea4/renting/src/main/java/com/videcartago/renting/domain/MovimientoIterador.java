package com.videcartago.renting.domain;

import java.util.Date;
import java.util.Iterator;

public class MovimientoIterador implements Iterator<Movimiento>{
   private Movimiento[] movimientos;
   private int posicion = -1;
	
   
   
   public MovimientoIterador() {
	this.movimientos= new Movimiento[100];
   }

@Override
	public boolean hasNext() {
		if(posicion < movimientos.length && movimientos[posicion] != null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Movimiento next() {
		
		return movimientos[posicion++];
	}
	
	public void add(Movimiento movimiento) {

		movimientos[posicion+1]= movimiento;
		
	}
		
	}
	
	
	

}
