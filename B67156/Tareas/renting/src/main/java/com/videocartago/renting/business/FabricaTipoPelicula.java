package com.videocartago.renting.business;

import com.videocartago.renting.domain.EnumGenero;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.MayoresDeDieciocho;
import com.videocartago.renting.domain.MayoresDeDoce;
import com.videocartago.renting.domain.PeliculaAbstract;
import com.videocartago.renting.domain.TodoPublico;

public class FabricaTipoPelicula {
	
	public PeliculaAbstract getCategoria(Genero genero) {
		
		EnumGenero enumGenero = genero.getEnumGenero();
		
		if(EnumGenero.SUSPENSO == enumGenero) {
			return new MayoresDeDoce();
		}
		if(EnumGenero.TERROR == enumGenero) {
			return new MayoresDeDieciocho();
		}
		return new TodoPublico();
	}

}
