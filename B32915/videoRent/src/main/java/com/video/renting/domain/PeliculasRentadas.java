package com.video.renting.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PeliculasRentadas implements EstadoPeliculas{

	@Autowired
	public Movimiento movimientos;
	public List<Movimiento> movimientosRealizados;
	
	@Override
	public void Rentar(Pelicula peli) {
		if(peli.isDisponibilidad()==false) {
			peli.setDisponibilidad(true);
		}else if(peli.isDisponibilidad()==true) {
			System.out.println("La Pelicula no se puede rentar");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		movimientosRealizados.add(new Movimiento(movimientosRealizados.size()+1,date,peli.isDisponibilidad(),peli));
	}

	@Override
	public void Devolver(Pelicula peli) {
		if(peli.isDisponibilidad()==true) {
			peli.setDisponibilidad(false);
		}else if(peli.isDisponibilidad()==false) {
			System.out.println("La Pelicula no se requiere");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		movimientosRealizados.add(new Movimiento(movimientosRealizados.size()+1,date,peli.isDisponibilidad(),peli));
		
	}



}
