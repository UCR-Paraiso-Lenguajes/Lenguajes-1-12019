package com.videcartago.renting.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.videcartago.renting.domain.Pelicula;

@Repository
public class PeliculaData {
 @Autowired
 private JdbcTemplate jdbcTemplate;
 private SimpleJdbcCall simpleJdbcCall;
 private DataSource dataSource;
 @Autowired
 public void setDataSource(DataSource dataSource) {
  this.dataSource=dataSource;
  this.simpleJdbcCall=new SimpleJdbcCall(dataSource)
    .withCatalogName("dbo")
    .withProcedureName("VideoRent_PeliculaInsert")
    .withoutProcedureColumnMetaDataAccess()
    .declareParameters(new SqlOutParameter("@codPelicula",Types.INTEGER))
    .declareParameters(new SqlParameter("titulo",Types.VARCHAR))
    .declareParameters(new SqlParameter("codGenero",Types.INTEGER))
    .declareParameters(new SqlParameter("@totalPeliculas",Types.INTEGER))
    .declareParameters(new SqlParameter("@subtitulada",Types.BIT))
    .declareParameters(new SqlParameter("@estreno",Types.BIT));

 }
 @Transactional 
  public Pelicula save(Pelicula pelicula)throws SQLException{
   
   SqlParameterSource parameterSource = new MapSqlParameterSource()
     .addValue("@titulo",pelicula.getTitulo())
     .addValue("@codGenero",pelicula.getGenero().getCodGenero())
     .addValue("@totalPeliculas",pelicula.getTotalPeliculas())
     .addValue("@Subtitulada",pelicula.isSubtitulada())
     .addValue("@estreno",pelicula.isEstreno());
  Map<String,Object> outParameters = simpleJdbcCall.execute(parameterSource);
  pelicula.setCodPelicula(Integer.parseInt(outParameters.get("@codPelicula").toString()));
   
  return pelicula;
  }
 
 @Transactional(readOnly=true)
	public List<Pelicula> findMoviesByTitleAndGenre(String title, String genre){
		// TODO QUE MÁS FALTA ...ESPACIOS EN BLANCO
		String sqlSelect = "SELECT p.cod_pelicula, titulo, total_peliculas, subtitulada, estreno, g.nombre_genero," + 
				"g.cod_genero, a.cod_actor, a.nombre_actor, a.apellidos_actor" + 
				"  FROM  Pelicula p, Genero g, Actor a, Pelicula_Actor pa" + 
				"  where p.cod_genero = g.cod_genero" + 
				"  and p.cod_pelicula = pa.cod_pelicula and" + 
				"  a.cod_actor = pa.cod_actor and" + 
				"  p.titulo like '%" + title + "%' and g.nombre_genero like '%" + genre + "%'" + 
				"  order by p.titulo";
		return jdbcTemplate.query(sqlSelect, new PeliculasWithActoresExtractor());
	}

}
class PeliculasWithActoresExtractor implements ResultSetExtractor<List<Pelicula>>{

	@Override
	public List<Pelicula> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Pelicula> map = new HashMap<Integer, Pelicula>();
		Pelicula pelicula = null;
		while(rs.next()) {
			Integer codPeliculaActual = rs.getInt("cod_pelicula");
			pelicula = map.get(codPeliculaActual);
			if (pelicula == null) {
				pelicula = new Pelicula();
				pelicula.setCodPelicula(codPeliculaActual);
				pelicula.setTitulo(rs.getString("titulo"));
				pelicula.setTotalPeliculas(rs.getInt("total_peliculas"));
				pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
				pelicula.setEstreno(rs.getBoolean("estreno"));
				pelicula.getGenero().setCodGenero(rs.getInt("cod_genero"));
				pelicula.getGenero().setNombreGenero(rs.getString("nombre_genero"));
				map.put(codPeliculaActual, pelicula);
			}
			Actor actor = new Actor();
			actor.setCodActor(rs.getInt("cod_actor"));
			actor.setNombreActor(rs.getString("nombre_actor"));
			actor.setApellidosActor(rs.getString("apellidos_actor"));
			pelicula.getActores().add(actor);
		}//while
		
		return new ArrayList<Pelicula>(map.values());
	}
	
}
