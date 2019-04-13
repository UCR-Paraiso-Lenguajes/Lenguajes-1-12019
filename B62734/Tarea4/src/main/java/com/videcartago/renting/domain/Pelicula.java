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
	private EstadoPelicula estado;
	private MovimientosIterable movimientosIterable;

	public Pelicula(String duracion, String descripcion) {
		super(duracion, descripcion);
		genero = new Genero();
		actores = new LinkedList<Actor>();
		estado = new Disponible();
		movimientosIterable=new MovimientosIterable();
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

	}

	public String rentar() {
		if (estado instanceof Rentada) {
			throw new RuntimeException("La Pelicula ya esta rentada");		
		}else {
			setEstado(new Rentada());
	        Date fecha = new Date();
	        fecha.getDate();
			movimientosIterable.agregar(new Movimiento(fecha,titulo,estado));
			return estado.Estado();
		}
	}

	public String devolver() {
		if (estado instanceof Disponible) {
			throw new RuntimeException("La Pelicula ya fue devuelta");		
		}else {
			setEstado(new Disponible());
	        Date fecha = new Date();
	        fecha.getDate();
			movimientosIterable.agregar(new Movimiento(fecha,titulo,estado));
			return estado.Estado();
		}
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

	public EstadoPelicula getEstado() {
		return estado;
	}

	public void setEstado(EstadoPelicula estado) {
		this.estado = estado;
	}

	public MovimientosIterable getMovimientosIterable() {
		return movimientosIterable;
	}

	public void setMovimientosIterable(MovimientosIterable movimientosIterable) {
		this.movimientosIterable = movimientosIterable;
	}



}
