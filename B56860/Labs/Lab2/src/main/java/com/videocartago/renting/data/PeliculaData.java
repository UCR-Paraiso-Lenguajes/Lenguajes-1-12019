package com.videocartago.renting.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.videocartago.renting.domain.Pelicula;

@Repository
public class PeliculaData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Pelicula> findMoviesByTitleAndGenre(String title, String genre){
		String sqlSelect = "SELECT p.cod_pelicula,p.titulo,p.cod_genero,g.nombre_genero,p.total_peliculas,"
				+ "p.subtitulada,p.estreno,pa.cod_actor,a.nombre_actor,a.apellidos_actor "
				+ "FROM Pelicula p left join Genero g on p.cod_genero = g.cod_genero "
				+ "left join Pelicula_Actor pa on p.cod_pelicula = pa.cod_pelicula "
				+ "left join Actor a on pa.cod_actor = a.cod_actor "
				+ " WHERE p.titulo like '%" + title.trim() + "%' and g.nombre_genero like '%"+genre.trim()+"%'";
		return jdbcTemplate.query(sqlSelect, new PeliculasWithActoresExtractor());
	}//findMoviesByTitleAndGenre

	
	class PeliculasWithActoresExtractor implements ResultSetExtractor<List<Pelicula>>{

		@Override
		public List<Pelicula> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Pelicula> map = new HashMap<Integer, Pelicula>();
			Pelicula pelicula = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("cod_pelicula");
				pelicula = map.get(id);
				
				if(pelicula == null) {
					
					pelicula = new 	Pelicula();
					pelicula.setCodPelicula(id);
					pelicula.setTitulo(rs.getString("titulo"));
					pelicula.setGenero().setCodGenero(rs.getInt("cod_genero"));
					pelicula.setGenero().setNombreGenero(rs.getString("nombre_genero"));
					pelicula.setTotalPeliculas(rs.getInt("total_peliculas"));
					pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
					pelicula.setEstreno(rs.getBoolean("estreno"));
					map.put(id, pelicula);
					
				}//if
			}//while
			return new ArrayList<Pelicula>(map.values());
		}//extractData
		
	}
}
