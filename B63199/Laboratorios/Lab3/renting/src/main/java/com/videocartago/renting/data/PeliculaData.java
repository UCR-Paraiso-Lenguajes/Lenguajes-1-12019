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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Pelicula;



@Repository
public class PeliculaData {

@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource= dataSource;
		this.simpleJdbcCall= new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("VideoRent_PeliculaInsert")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@codPelicula", Types.INTEGER))
				.declareParameters(new SqlOutParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlOutParameter("@codGenero", Types.INTEGER))
				.declareParameters(new SqlOutParameter("@totalPeliculas", Types.INTEGER))
				.declareParameters(new SqlOutParameter("@subtitulada", Types.BIT))
				.declareParameters(new SqlOutParameter("@estreno", Types.BIT));
	}
	@Transactional
	public Pelicula save(Pelicula pelicula) throws SQLException{
		SqlParameterSource parameterSource= new MapSqlParameterSource()
				.addValue("@titulo", pelicula.getTitulo())
				.addValue("@codGenero", pelicula.getGenero().getCodGenero())
				.addValue("@totalPeliculas", pelicula.getTotalPeliculas())
				.addValue("@subtitulada", pelicula.isSubtitulada())
				.addValue("@estreno", pelicula.isEstreno());
		Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);
		pelicula.setCodPelicula(Integer.parseInt(outParameters.get("@codPelicula").toString()));
		
		return pelicula;
	}
}
