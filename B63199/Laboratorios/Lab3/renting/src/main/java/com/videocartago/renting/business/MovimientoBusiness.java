package com.videocartago.renting.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videocartago.renting.data.GeneroData;
import com.videocartago.renting.data.MovimientoData;
import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;

@Service
public class MovimientoBusiness {
	@Autowired
	private MovimientoData movimientoData;
	private PeliculaData peliculaData;
	
	public void validaEstado(String tituloPelicula, boolean rentar){

		//trae la pelicula con ese titulo y le saca el estado
		String estadoActual=peliculaData.findMoviesByTitle(tituloPelicula).get(1).getEstado();
		
		//si la pelicula esta rentada y se quiere devolver o si la pelicula no está rentada y se quiere rentar
		if((estadoActual.equals("Rentar") && !rentar) || estadoActual.equals("Stock") && rentar) 
			movimientoData.colocarEstado(tituloPelicula, rentar);

	}
}
	
	

