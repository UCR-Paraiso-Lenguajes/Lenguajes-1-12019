package com.videcartago.renting.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.videcartago.renting.domain.Actor;
import com.videcartago.renting.domain.Movimiento;
import com.videcartago.renting.domain.MovimientoIterador;
import com.videcartago.renting.domain.Pelicula;
import com.videcartago.renting.domain.PeliculaDisponible;
import com.videcartago.renting.domain.PeliculaRentada;

@Repository
public class PeliculaData {
	@Autowired
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	private MovimientoIterador movimientoIterador;
	
	@Transactional(readOnly=true)
	public List<Pelicula> findMoviesByTitleAndGenre(String title, String genre) {
			String sqlSelect = "SELECT p.cod_pelicula,p.titulo,p.cod_genero,g.nombre_genero, p.total_peliculas,"
				+ "p.subtitulada,p.estreno,pa.cod_actor, a.nombre_actor, a.apellidos_actor"
				+ " FROM Pelicula p left join Genero g on p.cod_genero = g.cod_genero"
				+ "  left join Pelicula_Actor pa on p.cod_pelicula = pa.cod_pelicula"
				+ "  left join Actor a on pa.cod_actor = a.cod_actor"
				+ " WHERE p.titulo like '%"+title.trim() + "%' and g.nombre_genero like '%"+genre.trim()+"%'";
		return jdbcTemplate.query(sqlSelect, new PeliculasWithActoresExtractor());
	}// findMoviesByTitleAndGenre

	


class PeliculasWithActoresExtractor implements ResultSetExtractor<List<Pelicula>> {
	@Override
	public List<Pelicula> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Pelicula> map = new HashMap<Integer, Pelicula>();
		Pelicula pelicula = null;
		while (rs.next()) {
			Integer id = rs.getInt("cod_pelicula");
			pelicula = map.get(id);
			if (pelicula == null) { // new pelicula record
				pelicula = new Pelicula("");
				pelicula.setCodPelicula(id);
				pelicula.setTitulo(rs.getString("titulo"));
				pelicula.getGenero().setCodGenero(rs.getInt("cod_genero"));
				pelicula.getGenero().setNombreGenero(rs.getString("nombre_genero"));
				pelicula.setTotalPeliculas(rs.getInt("total_peliculas"));
				pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
				pelicula.setEstreno(rs.getBoolean("estreno"));
				map.put(id, pelicula);
			} // if
			int actorId = rs.getInt("cod_actor");
			if (actorId > 0) {
				Actor actor = new Actor();
				actor.setCodActor(actorId);
				actor.setNombreActor(rs.getString("nombre_actor"));
				actor.setApellidosActor(rs.getString("apellidos_actor"));
				pelicula.getActores().add(actor);
			} // if
			// TODO Auto-generated method stub
		} // while
	
		return new ArrayList<Pelicula>(map.values());
	} // extractData
	
	
	
}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource= dataSource;
		this.simpleJdbcCall= new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("VideoRent_PeliculaInsert")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@codPelicula", Types.INTEGER))
				.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlParameter("@codGenero", Types.INTEGER))
				.declareParameters(new SqlParameter("@totalPeliculas", Types.INTEGER))
				.declareParameters(new SqlParameter("@subtitulada", Types.BIT))
				.declareParameters(new SqlParameter("@estreno", Types.BIT));
			
		
	}
	@Transactional
	public Pelicula save(Pelicula pelicula) {
		SqlParameterSource parameterSource= new MapSqlParameterSource()
				.addValue("@titulo", pelicula.getTitulo())
				.addValue("@codGenero", pelicula.getGenero().getCodGenero())
				.addValue("@totalPeliculas", pelicula.getTotalPeliculas())
				.addValue("@subtitulada", pelicula.isSubtitulada())
				.addValue("@estreno", pelicula.isEstreno());
		Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);
		
		
		
		
		return pelicula;
	
	}
	
	
	public void Rentar(Pelicula pelicula) {
		pelicula.setEstadoPelicula(new PeliculaRentada());
		Date fecha= new Date();
		
		Movimiento movimiento= new Movimiento(fecha, pelicula.getEstadoPelicula());
		movimientoIterador.add(movimiento);
		
	}
	
	
	public void devolver(Pelicula pelicula) {
		pelicula.setEstadoPelicula(new PeliculaDisponible());
		Date fecha= new Date();
		
		Movimiento movimiento= new Movimiento(fecha, pelicula.getEstadoPelicula());
		movimientoIterador.add(movimiento);
	}

}