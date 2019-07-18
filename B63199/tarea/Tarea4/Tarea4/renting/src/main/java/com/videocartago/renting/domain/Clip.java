package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clip {

	private int codClip;
	private String titulo;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	
	public Clip() {
		genero=new Genero();
	}

	public Clip(String titulo, boolean subtitulada, Genero genero) {
		super();
		this.titulo = titulo;
		this.subtitulada = subtitulada;
		this.genero = genero;
	}

	public int getCodClip() {
		return codClip;
	}

	public void setCodClip(int codClip) {
		this.codClip = codClip;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isSubtitulada() {
		return subtitulada;
	}

	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}

	public boolean isEstreno() {
		return estreno;
	}

	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	


}
