package com.videocartago.renting.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Pelicula;

public class PeliculaWithActoresExtractor implements ResultSetExtractor<List<Pelicula>> {

		public List<Pelicula> extractData(ResultSet rs) throws SQLException, DataAccessException{
			Map<Integer, Pelicula> map = new HashMap<Integer, Pelicula>();
			Pelicula pelicula = null;
			while (rs.next()) {
				Integer id = rs.getInt("cod_pelicula");
				pelicula = map.get(id);
				if(pelicula == null) {//new pelicula record
					pelicula = new Pelicula();
					pelicula.setCodPelicula(id);
					pelicula.setTitulo(rs.getString("titulo"));
					pelicula.getGenero().setCodGenero(rs.getString("cod_genero"));
					pelicula.getGenero().setNombreGenero(rs.getString("nombre_genero"));
					pelicula.setTotalPeliculas(rs.getInt("total_peliculas"));
					pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
					pelicula.setEstreno(rs.getBoolean("estreno"));
					map.put(id, pelicula);
				}//if
				int actorId = rs.getInt("cod_actor");
				if(actorId >0 ) {
					Actor actor = new Actor();
					actor.setCodActor(actorId);
					actor.setNombreActor(rs.getString("nombre_actor"));
					actor.setApellidosActor(rs.getString("apellidos_actor"));
					pelicula.getActores().add(actor);
			}//if
		}//while
		return new ArrayList<Pelicula>(map.values());
	}//extractData

}
