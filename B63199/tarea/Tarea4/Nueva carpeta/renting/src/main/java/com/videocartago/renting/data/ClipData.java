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
import com.videocartago.renting.domain.Clip;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Video;

public class ClipData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("VideoRent_ClipInsert")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@codClip", Types.INTEGER))
				.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlParameter("@codGenero", Types.INTEGER))
				.declareParameters(new SqlParameter("@subtitulada", Types.BIT))
				.declareParameters(new SqlParameter("@estreno", Types.BIT));
	}
	
	public Clip save(Clip film) {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@titulo", film.getTitulo())
				.addValue("@codGenero", film.getGenero().getCodGenero())
				.addValue("@subtitulada", film.isSubtitulada())
				.addValue("@estreno", film.isEstreno());
		
		
		Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
		film.setCodClip(Integer.parseInt(outParameters.get("@codClip").toString()));
   	return film;
	}
}

class ClipWithExtractor implements ResultSetExtractor<List<Clip>> {
	@Override
	public List<Clip> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Clip> map = new HashMap<Integer, Clip>();
		Clip clip = null;
		while (rs.next()) {
			Integer id = rs.getInt("cod_video");
			clip = map.get(id);
			if (clip == null) { 
				Genero genero = new Genero();
				genero.setCodGenero(rs.getInt("cod_genero"));
				genero.setNombreGenero(rs.getString("nombre_genero"));
				clip = new Clip();
				clip.setCodClip(id);
				clip.setTitulo(rs.getString("titulo"));
				clip.setSubtitulada(rs.getBoolean("subtitulada"));
				clip.setEstreno(rs.getBoolean("estreno"));
				map.put(id, clip);
			} // if

		} // while
		return new ArrayList<Clip>(map.values());
	} // extractData
	
	


}
