package com.videocartago.renting.patronIterator;

import java.util.ArrayList;

public class Movimientos {

	private ArrayList<DatosMovimiento> movimientos;

	public Movimientos() {
		
		movimientos = new ArrayList<DatosMovimiento>();
	}
	
	public void add(DatosMovimiento datosMovimiento) {
		
		movimientos.add(datosMovimiento);
		
	}
	
	
	public MovimientosIterator iterator() {
		
		return new MovimientosIterator(movimientos);
	}
	
	
	
}
