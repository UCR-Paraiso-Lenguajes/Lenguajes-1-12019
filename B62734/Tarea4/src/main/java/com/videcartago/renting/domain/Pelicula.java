package com.videcartago.renting.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import java.util.List;

public class Pelicula extends Contenido {

	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	public MovimientosIterable movimientosIterable;
	private EstadoPelicula estado;
	private EstadoComparacion estadoComparacion;

	public Pelicula(String duracion, String descripcion) {
		super(duracion, descripcion);
		genero = new Genero();
		actores = new LinkedList<Actor>();
		estado= new Disponible();
		movimientosIterable=new MovimientosIterable();
		estadoComparacion=estadoComparacion.disponible;
	}

	public Pelicula(String duracion, String descripcion, int codPelicula, String titulo, int totalPeliculas,
			boolean subtitulada, boolean estreno, Genero genero, List<Actor> actores) {
		super(duracion, descripcion);
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.totalPeliculas = totalPeliculas;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		this.genero = genero;
		this.actores = actores;
		estado = new Disponible();
		movimientosIterable=new MovimientosIterable();
		estadoComparacion=estadoComparacion.disponible;

	}
	public void rentar() {
		if (estadoComparacion== estadoComparacion.rentada) {
			throw new RuntimeException("La pelicula ya la rento alguien mas.");		
		}else {
			estadoComparacion=estadoComparacion.rentada;
			estado=new Rentada();
	        Date fecha = new Date();
	        fecha.getDate();
			movimientosIterable.agregar(new Movimiento(fecha,getTitulo(),getEstado()));
		}
		
	}

	
	 public  void devolver() {
		if (estadoComparacion== estadoComparacion.disponible) {
			throw new RuntimeException("La pelicula ya la devolvieron antes.");		
		}else {
			estadoComparacion=estadoComparacion.disponible;
			estado=new Disponible();
	        Date fecha = new Date();
	        fecha.getDate();
			movimientosIterable.agregar(new Movimiento(fecha,getTitulo(),getEstado()));	}
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

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTotalPeliculas() {
		return totalPeliculas;
	}

	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas = totalPeliculas;
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


	public MovimientosIterable getMovimientosIterable() {
		return movimientosIterable;
	}

	public void setMovimientosIterable(MovimientosIterable movimientosIterable) {
		this.movimientosIterable = movimientosIterable;
	}

	public EstadoPelicula getEstado() {
		return estado;
	}

	public void setEstado(EstadoPelicula estado) {
		this.estado = estado;
	}

	public EstadoComparacion getEstadoComparacion() {
		return estadoComparacion;
	}

	public void setEstadoComparacion(EstadoComparacion estadoComparacion) {
		this.estadoComparacion = estadoComparacion;
	}



}
