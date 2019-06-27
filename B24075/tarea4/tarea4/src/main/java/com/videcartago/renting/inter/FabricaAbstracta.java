package com.videcartago.renting.inter;

public interface FabricaAbstracta {
	
	IVideo getVideo();
	IPelicula getPelicula(String tipoPelicula);
	IClip getClip();
	

}
