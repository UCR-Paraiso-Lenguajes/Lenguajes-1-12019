package com.orbis.B76223.ventas.data;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B76223.ventas.data.EditorialData.LibrosExtractor;
import com.orbis.B76223.ventas.domain.Autor;
import com.orbis.B76223.ventas.domain.Libro;

@Repository
public class LibroData {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("Orbis_LibroInsert")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@idLibro", Types.INTEGER))
				.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlParameter("@ano", Types.INTEGER))
				.declareParameters(new SqlParameter("@precio", Types.INTEGER))
				.declareParameters(new SqlParameter("@idEditorial", Types.INTEGER));
				
	}
	
	@Transactional
	public Libro save(Libro libro)
	{
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@titulo", libro.getTitulo())
				.addValue("@ano", libro.getAno())
				.addValue("@precio", libro.getPrecio())
				.addValue("@idEditorial", libro.getEditorial().getIdEditorial());
		Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);
		libro.setIdLibro(Integer.parseInt(outParameters.get("@idLibro").toString()));
		// TODO FALTA INSERTAR LOS ACTORES DE LA PELICULA
		return libro;
	}
	
	@Transactional
	public void saveLibroAutor(int idLibro, ArrayList<Autor> autorLibros) {
		
		String sqlSelect = "INSERT INTO LIBRO_AUTOR VALUES ";
		
		for(int i=0; i<autorLibros.size();i++) {
			sqlSelect += "(" + autorLibros.get(i).getIdAutor() + ", " + idLibro +"), ";			
		}
		
		
	}
	
}
	

