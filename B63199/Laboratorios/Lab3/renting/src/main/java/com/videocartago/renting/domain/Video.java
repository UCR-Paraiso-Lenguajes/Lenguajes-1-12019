package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Video {

	private int codVideo;
	private String titulo;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	
	public Video() {
		genero=new Genero();
		actores=new ArrayList<>();
	}
	

	public Video(String titulo, boolean subtitulada, boolean estreno) {
		super();
		this.titulo = titulo;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		genero=new Genero();
		actores=new ArrayList<>();
	}



	public int getCodVideo() {
		return codVideo;
	}

	public void setCodVideo(int codVideo) {
		this.codVideo = codVideo;
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

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	
	




}
