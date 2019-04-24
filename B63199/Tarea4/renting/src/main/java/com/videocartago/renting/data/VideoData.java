package com.videocartago.renting.data;

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

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.Video;

public class VideoData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("VideoRent_VideoInsert")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@codVideo", Types.INTEGER))
				.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlParameter("@codGenero", Types.INTEGER))
				.declareParameters(new SqlParameter("@subtitulada", Types.BIT))
				.declareParameters(new SqlParameter("@estreno", Types.BIT));
	}
	
	public Video save(Video film) {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@titulo", film.getTitulo())
				.addValue("@codGenero", film.getGenero().getCodGenero())
				.addValue("@subtitulada", film.isSubtitulada())
				.addValue("@estreno", film.isEstreno());
		
		
		Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
		film.setCodVideo(Integer.parseInt(outParameters.get("@codVideo").toString()));
		return film;
	}

}


class VideoWithActoresExtractor implements ResultSetExtractor<List<Video>> {
	@Override
	public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Video> map = new HashMap<Integer, Video>();
		Video video = null;
		while (rs.next()) {
			Integer id = rs.getInt("cod_video");
			video = map.get(id);
			if (video == null) { 
				Genero genero = new Genero();
				genero.setCodGenero(rs.getInt("cod_genero"));
				genero.setNombreGenero(rs.getString("nombre_genero"));
				video = new Video();
				video.setCodVideo(id);
				video.setTitulo(rs.getString("titulo"));
				video.setSubtitulada(rs.getBoolean("subtitulada"));
				video.setEstreno(rs.getBoolean("estreno"));
				map.put(id, video);
			} // if
			int actorId = rs.getInt("cod_actor");
			if (actorId > 0) {
				Actor actor = new Actor();
				actor.setCodActor(actorId);
				actor.setNombreActor(rs.getString("nombre_actor"));
				actor.setApellidosActor(rs.getString("apellidos_actor"));
				video.getActores().add(actor);
			} // if
			// TODO Auto-generated method stub
		} // while
		return new ArrayList<Video>(map.values());
	} // extractData
	
	
}