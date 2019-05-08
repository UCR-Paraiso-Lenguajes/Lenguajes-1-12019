package com.videocartago.renting.patronFactory;

public enum CategoriaPeliculas {

	//Variables Constantes
	TodoPublico("TP", 0), MayorDeDieciecho("+18", 18), MayorDeDoce("+12", 12);

	private final int edadMinima;
	private final String nombreCategoria;

	private CategoriaPeliculas(String nombreCategoria, int edadMinima) {
		this.edadMinima = edadMinima;
		this.nombreCategoria = nombreCategoria;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

}
