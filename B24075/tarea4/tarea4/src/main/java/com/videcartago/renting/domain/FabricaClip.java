package com.videcartago.renting.domain;

import com.videcartago.renting.inter.FabricaAbstracta;
import com.videcartago.renting.inter.IClip;
import com.videcartago.renting.inter.IPelicula;
import com.videcartago.renting.inter.IVideo;

public class FabricaClip implements FabricaAbstracta{

	@Override
	public IVideo getVideo() {
	
		return null;
	}

	@Override
	public IPelicula getPelicula(String tipoPelicula) {

		return null;
	}

	@Override
	public IClip getClip() {
		// TODO Auto-generated method stub
		return new Clip();
	}

}
