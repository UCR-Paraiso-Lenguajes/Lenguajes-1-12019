package com.videocartago.renting.patronIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class MovimientosIterator implements Iterator<DatosMovimiento> {

	int posicion = 0;

	private ArrayList<DatosMovimiento> movimientos;

	public MovimientosIterator(ArrayList<DatosMovimiento> movimientos) {

		this.movimientos = movimientos;
	}

	@Override
	public boolean hasNext() {

		if (posicion < movimientos.size() && movimientos.get(posicion) != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public DatosMovimiento next() {

		return movimientos.get(posicion++);
	}

}
