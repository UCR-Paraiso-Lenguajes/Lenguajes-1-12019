package com.videocartago.renting.domain;

import java.util.List;

import com.videocartago.renting.factoryAbstract.PeliculaAbstract;

public class Mayores12Persona extends PeliculaAbstract	  {
	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	
	
	public Mayores12Persona(Pelicula pelicula) {
		if(pelicula.equals("")) throw new RuntimeException("La pelicula tiene elementos vacios");
		this.codPelicula =pelicula.getCodPelicula();
		this.titulo = pelicula.getTitulo();
		this.totalPeliculas = pelicula.getTotalPeliculas();
		this.subtitulada = pelicula.isSubtitulada();
		this.estreno = pelicula.isEstreno();
		this.genero= pelicula.getGenero();
		this.actores=pelicula.getActores();
	}
	
	
	
	



	@Override
	public String getTipo() {
		return "Mayores de 12 años";
	}







	@Override
	public Genero getGenero() {
		
		return genero;
	}







	@Override
	public void setGenero(Genero genero) {
		this.genero=genero;
		
	}







	@Override
	public List<Actor> getActores() {
		return actores;
	}







	@Override
	public void setActores(List<Actor> actores) {
		this.actores=actores;
		
	}







	@Override
	public int getCodPelicula() {
		
		return codPelicula;
	}







	@Override
	public void setCodPelicula(int codPelicula) {
		this.codPelicula=codPelicula;
		
	}







	@Override
	public String getTitulo() {
		return titulo;
	}







	@Override
	public void setTitulo(String titulo) {
		this.titulo=titulo;
		
	}







	@Override
	public int getTotalPeliculas() {
		return totalPeliculas;
	}







	@Override
	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas=totalPeliculas;
		
	}







	@Override
	public boolean isSubtitulada() {
		
		return subtitulada;
	}







	@Override
	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada=subtitulada;
		
	}







	@Override
	public boolean isEstreno() {
		
		return estreno;
	}







	@Override
	public void setEstreno(boolean estreno) {
		this.estreno=estreno;
		
	}







	@Override
	public void setTipo() {
		this.getTipo();
		
	}	
	
	
	

}