package com.videocartago.renting.factory;

import com.videcartago.renting.domain.Pelicula;

public class PeliculaFactory {

	public static Clasificacion getTipoClasificacion(String genero) {

		switch (genero) {
		
		case "Terror":
			return new ClasificacionMayoresDieciocho();
		case "Suspenso":
			return new ClasificacionMayoresDoce();
		default:
			return new ClasificacionTP();
		
		}
	}

}
