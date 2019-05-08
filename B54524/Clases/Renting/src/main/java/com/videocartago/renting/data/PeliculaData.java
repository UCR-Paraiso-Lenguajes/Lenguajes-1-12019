package com.videocartago.renting.data;

import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PeliculaData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Pelicula> findMoviesByTimeAndGenre(String title, String genero){
		String sqlSelect = "SELECT p.cod_pelicula, p.titulo, p.cod_genero, g.nombre_genero, p.total_peliculas, "
				+ "p.subtitulada, p.estreno, pa.cod_actor, a.nombre_actor, a.apellidos_actor"
				+ "FROM Pelicula p left join Genero g ON p.cod_genero = g.cod_genero "
				+ "left join Pelicula_Actor pa ON p.cod_pelicula = pa.cod_pelicula "
				+ "left join Actor a ON pa.cod_actor = a.cod_actor "
				+ "WHERE p.titulo like '%"+title.trim()+"%' AND g.nombre_genero like '%"+genero.trim()+"%'";
		return jdbcTemplate.query(sqlSelect, new PeliculasWithActoresExtractor());
	}
	
	class PeliculasWithActoresExtractor implements ResultSetExtractor<List<Pelicula>>{

		@Override
		public List<Pelicula> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Pelicula> map = new HashMap<Integer, Pelicula>();
			Pelicula pelicula = null;
			while (rs.next()) {
				Integer id = rs.getInt("cod_pelicula");
				pelicula = map.get(id);
				if(pelicula == null) {
					pelicula = new Pelicula();
					pelicula.setCodPelicula(id);
					pelicula.setTitulo(rs.getString("titulo"));
					pelicula.getGenero().setCodGenero(rs.getInt("cod_genero"));
					pelicula.getGenero().setNombreGenero(rs.getString("nombre_genero"));
					pelicula.setTotalPeliculas(rs.getInt("total_peliculas"));
					pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
					pelicula.setEstreno(rs.getBoolean("estreno"));
					map.put(id, pelicula);
				}
				int actorId = rs.getInt("cod_actor");
				if(actorId > 0) {
					Actor actor = new Actor();
					actor.setCodActor(actorId);
					actor.setNombreActor(rs.getString("nombre_actor"));
					actor.setApellidosActor(rs.getString("apellidos_actor"));
					pelicula.getActores().add(actor);
				}
			}
			return new ArrayList<Pelicula>(map.values());
		}
	}
}
