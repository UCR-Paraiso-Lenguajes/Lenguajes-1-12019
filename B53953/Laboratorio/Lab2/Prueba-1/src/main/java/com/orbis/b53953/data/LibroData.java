package com.orbis.b53953.data;

import java.sql.SQLException;
import java.sql.Types;
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

import com.orbis.b53953.domain.Libro;


@Repository
public class LibroData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallLibro;
	private SimpleJdbcCall simpleJdbcCallLibroAutor;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.simpleJdbcCallLibro = new SimpleJdbcCall(dataSource)
		.withCatalogName("dbo")
		.withProcedureName("INGRESAR_LIBROS")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(new SqlOutParameter("@idLibro", Types.INTEGER))
		.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
		.declareParameters(new SqlParameter("@año", Types.INTEGER))
		.declareParameters(new SqlParameter("@precio", Types.FLOAT))
		.declareParameters(new SqlParameter("@idEditorial", Types.INTEGER));
		
		this.simpleJdbcCallLibroAutor = new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("INGRESAR_LIBRO_AUTOR")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("@idLibro", Types.INTEGER))
				.declareParameters(new SqlParameter("@autoresTotales", Types.INTEGER));
	
   }
	
	@Transactional
	
	public Libro save(Libro libro) throws SQLException{
		
		SqlParameterSource parameterSource = new MapSqlParameterSource()
		.addValue("@titulo", libro.getTitulo())
		.addValue("@año", libro.getAño())
		.addValue("@precio", libro.getPrecio())
		.addValue("@idEditorial", libro.getEditorial().getIdEditorial());
		
		Map<String, Object> outParameters = simpleJdbcCallLibro.execute(parameterSource);
		libro.setIdLibro(Integer.parseInt(outParameters.get("@idLibro").toString()));
		
		for (int i = 0; i < libro.getAutores().size(); i++) {

			SqlParameterSource parameterSourceLibroAutor = new MapSqlParameterSource()
					.addValue("@idLibro",libro.getIdLibro())
					.addValue("@autoresTotales", libro.getAutores().get(i).getIdAutor());


			simpleJdbcCallLibroAutor.execute(parameterSourceLibroAutor);

		}
		return libro;
		
		
				
		
	}
}
