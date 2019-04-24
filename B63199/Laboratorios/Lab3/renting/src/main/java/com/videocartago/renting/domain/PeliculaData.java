package com.videocartago.renting.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.videocartago.renting.data.PeliculaWithActoresExtractor;

@Repository
public class PeliculaData {
	
@Autowired
private JdbcTemplate jdbcTemplate;

@Transactional(readOnly=true)
	public List<Pelicula> findMoviesByTitleAndGenre(String title, String genre) {
		String sqlSelect = "SELECT p.cod_pelicula, p.titulo, p.cod_genero, g.nombre_genero, p.total_peliculas,"
				+ "p.subtitulada, p.estreno, pa.cod_actor, a.nombre_actor, a.apellidos_actor"
				+ "FROM Pelicula p left outer join Genero g on p.cod_genero = g.cod_genero"
				+ "left outer join Pelicula_Actor pa on p.cod_pelicula =pa.cod_pelicula"
				+ "left outer join Actor a on pa.cod_actor = a.cod_actor"
				+ "WHERE p.titulo like '%"+title.trim()+"%' and g.nombre_genero like '%"
				+ genre.trim()+"%'";
		return jdbcTemplate.query(sqlSelect, new PeliculaWithActoresExtractor());
	}//findMoviesByTitleAndGenre

}





