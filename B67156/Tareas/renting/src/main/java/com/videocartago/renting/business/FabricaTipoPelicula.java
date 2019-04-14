package com.videocartago.renting.business;

import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.MayoresDeDieciocho;
import com.videocartago.renting.domain.MayoresDeDoce;
import com.videocartago.renting.domain.PeliculaAbstract;
import com.videocartago.renting.domain.TodoPublico;

public class FabricaTipoPelicula {
	
	public PeliculaAbstract getCategoria(Genero genero) {
		
		if(genero.getNombreGenero().equalsIgnoreCase("Suspenso")) {
			return new MayoresDeDoce();
		}
		if(genero.getNombreGenero().equalsIgnoreCase("Terror")) {
			return new MayoresDeDieciocho();
		}
		
		return new TodoPublico();
	}

}
