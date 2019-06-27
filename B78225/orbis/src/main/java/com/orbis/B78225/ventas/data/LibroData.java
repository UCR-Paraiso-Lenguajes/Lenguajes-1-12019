package com.orbis.B78225.ventas.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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

import com.orbis.B78225.ventas.domain.Libro;

@Repository
public class LibroData {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	
	public Libro save(Libro libro) {
		Connection conexion = null;
		
		try {
			conexion =  dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlSaveBook = "insert into Libro values (?,?,?,?,?)";
			String sqlSaveLibroAutor= "insert into Libro_Autor values(?,?)";
			
			PreparedStatement statementSaveBook =
					conexion.prepareStatement(sqlSaveBook,Statement.RETURN_GENERATED_KEYS);
			
			PreparedStatement statementLibroAutor = 
					conexion.prepareStatement(sqlSaveLibroAutor);
			
			
			statementSaveBook.setString(1, libro.getTitulo());
			statementSaveBook.setInt(2, libro.getAno());
			statementSaveBook.setFloat(3, libro.getPrecio());
			statementSaveBook.setInt(4, libro.getEditorial().getIdEditorial());
			statementSaveBook.setString(5, libro.getISBN());
			statementSaveBook.executeUpdate();
			
			ResultSet rs = statementSaveBook.getResultSet();
			if(rs.next()) {
			libro.setIdLibro(rs.getInt(1));
			}
			for(int i=0; i>libro.getAutores().size();i++) {
				
				statementLibroAutor.setInt(1, libro.getIdLibro());
				statementLibroAutor.setInt(2, libro.getAutores().get(i).getIdAutor());
				statementLibroAutor.executeUpdate();
			}
			
			
			conexion.commit();
			
		}catch(SQLException e) {
			
			try {
				conexion.rollback();
			}catch(SQLException e1) {
				throw new  RuntimeException(e1);
			}
			
			throw new RuntimeException(e);
			
		}finally {
			
			if(conexion != null) {
				try {
					conexion.close();
				}catch(SQLException e){
					throw new  RuntimeException(e);
				}
			}
		}
		
	return libro;
		
	}
}
	

