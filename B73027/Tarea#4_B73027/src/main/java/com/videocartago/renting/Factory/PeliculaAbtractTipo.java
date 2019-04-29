package com.videocartago.renting.Factory;

import java.util.List;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;

public abstract class PeliculaAbtractTipo {
	
		public abstract void setCategoriaEdad();
		public abstract String getCategoriaEdad();
		public abstract Genero getGenero();
		public abstract void setGenero(Genero genero);
		public abstract List<Actor> getActores();
		public abstract void setActores(List<Actor> actores);
		public abstract int getCodPelicula();
		public abstract void setCodPelicula(int codPelicula);
		public abstract String getTitulo();
		public abstract void setTitulo(String titulo);
		public abstract int getTotalPeliculas();
		public abstract void setTotalPeliculas(int totalPeliculas);
		public abstract boolean isSubtitulada();
		public abstract void setSubtitulada(boolean subtitulada);
		public abstract boolean isEstreno();
		public abstract void setEstreno(boolean estreno);
		
		public int codPelicula;
		public String titulo;
		public int totalPeliculas;
		public boolean subtitulada;
		public boolean estreno;
		public Genero genero;
		public List<Actor> actores;
		public String categoriaEdad;
	}
