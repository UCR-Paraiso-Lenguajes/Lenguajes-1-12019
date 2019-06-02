package com.videcartago.renting.domain;

import java.util.Iterator;

import javax.swing.text.AttributeSet;



public class MovimientosIterable implements Iterator {
	private Movimiento[] movimientos;
	private final int size = 200;
	public int objetoActual = -1;

	public MovimientosIterable() {
		super();
		this.movimientos = new Movimiento[size];
	}
	public boolean isEmpty() {
        return  objetoActual!= -1;
	}
	public boolean agregar(Movimiento movimiento) {
        boolean verify = false;
        if (isEmpty()) {
            return verify;
        } else {
        	if (!hasNext()) {
        		movimientos[objetoActual+1] = movimiento;
                verify=true;	
			}
         
        }
        return verify;
    }
	@Override
	public boolean hasNext() {
        return movimientos[objetoActual+1]!=null;         
	}

	@Override
	public Object next() {
		if (hasNext()) {
			return movimientos[objetoActual+1];
		}else {
			throw new RuntimeException("No existe un elemento siguiente");		
		}
	}

}
