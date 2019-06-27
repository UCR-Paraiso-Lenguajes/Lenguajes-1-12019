package com.orbis.B76223.ventas.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				.declareParameters(new SqlParameter("@idEditorial", Types.INTEGER))
				.declareParameters(new SqlParameter("@ISBN", Types.INTEGER));
				
	}
	
	@Transactional
	public Libro save2(Libro libro)
	{
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@titulo", libro.getTitulo())
				.addValue("@ano", libro.getAno())
				.addValue("@precio", libro.getPrecio())
				.addValue("@idEditorial", libro.getEditorial().getIdEditorial())
				.addValue("@ISBN", libro.getISBN());
		Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);
		libro.setIdLibro(Integer.parseInt(outParameters.get("@idLibro").toString()));
		
		String sqlInsertLibroAutor = "";
		
		for(int i=0; i < libro.getAutores().size(); i++) {
			sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES ("+ libro.getIdLibro() + ", " +libro.getAutores().get(i).getIdAutor()+")";
			jdbcTemplate.batchUpdate(sqlInsertLibroAutor);
			
		
		}
		
		
		return libro;
	}
	
	
	public Libro save(Libro libro) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);

			String sqlInsertLibro = "Insert INTO Libro VALUES (?,?,?,?,?)";
			
			PreparedStatement statementLibro = conexion.prepareStatement(sqlInsertLibro, Statement.RETURN_GENERATED_KEYS);
			statementLibro.setString(1, libro.getTitulo());
			statementLibro.setInt(2, libro.getAno());
			statementLibro.setFloat(3, libro.getPrecio());
			statementLibro.setInt(4, libro.getEditorial().getIdEditorial());
			statementLibro.setLong(5, libro.getISBN());
			
			statementLibro.executeUpdate();
			
			
			ResultSet rs= statementLibro.getGeneratedKeys(); 
			
			if(rs.next()) {
				libro.setIdLibro(rs.getInt(1));
			}
			
			String sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES (?,?)";
			
			
			for(int i=0; i < libro.getAutores().size(); i++) {
				
				PreparedStatement statementLibroAutor = conexion.prepareStatement(sqlInsertLibroAutor);
				statementLibroAutor.setInt(1, libro.getIdLibro());
				statementLibroAutor.setInt(2, libro.getAutores().get(i).getIdAutor());
				
				statementLibroAutor.executeUpdate();
				
			}
			
			conexion.commit();	
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {

				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}

			}
		}

		return libro;
	}
	
	
	
}
	

