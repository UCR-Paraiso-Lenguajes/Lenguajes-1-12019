package com.videoparaiso.renting.domain;

public class Productora {
	
	private static Productora productora = new Productora();

	private Productora() {
	}

	public static Productora getProductora() {
		return productora;
	}
}
