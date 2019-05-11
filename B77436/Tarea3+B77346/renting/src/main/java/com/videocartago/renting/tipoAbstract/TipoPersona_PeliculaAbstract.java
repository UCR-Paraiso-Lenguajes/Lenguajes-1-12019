package com.videocartago.renting.tipoAbstract;

import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.factoryAbstract.PeliculaAbstract;

public abstract class TipoPersona_PeliculaAbstract {
	
	public abstract PeliculaAbstract elegirTipoDeTelevidente(Pelicula pelicula);

}
