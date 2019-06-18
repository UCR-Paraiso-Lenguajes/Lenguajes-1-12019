package com.videcartago.renting.domain;

import com.videcartago.renting.inter.FabricaAbstracta;
import com.videcartago.renting.inter.IClip;
import com.videcartago.renting.inter.IPelicula;
import com.videcartago.renting.inter.IVideo;

public class FabricaPelicula implements FabricaAbstracta{



	@Override
	public IPelicula getPelicula(String genero) {
		
		 if (genero.equalsIgnoreCase("Terror")) {
			return new PeliculaM18();
		} else if (genero.equalsIgnoreCase("Suspenso")) {
			return new PeliculaM12();
		} 
		
		return new PeliculaTP();

	}

	@Override
	public IClip getClip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVideo getVideo() {
		// TODO Auto-generated method stub
		return null;
	}

}
