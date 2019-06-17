package com.videcartago.renting.domain;

import com.videcartago.renting.inter.FabricaAbstracta;
import com.videcartago.renting.inter.IClip;
import com.videcartago.renting.inter.IPelicula;
import com.videcartago.renting.inter.IVideo;

public class FabricaVideo implements FabricaAbstracta{

	@Override
	public IVideo getVideo() {
		// TODO Auto-generated method stub
		return  new Video();
	}

	@Override
	public IPelicula getPelicula(String tipoPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IClip getClip() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
