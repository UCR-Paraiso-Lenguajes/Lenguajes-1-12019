package com.videocartago.renting.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PeliculaForm {
	private int codPelicula;
	@NotNull
	@Size(min = 2, max = 50)
	private String titulo;
	@NotNull
	@Min(2)
	private int totalPeliculas;
	private boolean subtituladas;
	private boolean estreno;
	@NotNull
	private int codGenero;

	public PeliculaForm() {

	}
}
