package com.videocartago.renting.business;

import java.util.ArrayList;

import com.videocartago.renting.domain.Movimientos;

public class RegistraMovimientos {
	ArrayList<Movimientos> arrayMovimientos = new ArrayList<Movimientos>();
	
	public ArrayList<Movimientos> registrarMovimientos(Movimientos movimiento) {
		arrayMovimientos.add(movimiento);
		return arrayMovimientos;
	}

}
