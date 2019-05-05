package com.orbis.B70620.ventas.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.orbis.B70620.ventas.domain.Autor;
import com.orbis.B70620.ventas.domain.Editorial;
import com.orbis.B70620.ventas.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	public List<Libro> obtenerLibrosPorEditorial(int editorialId) {
		String sqlSelect = "SELECT ano, id_libro, precio, titulo "
				+ "FROM Libro WHERE id_editorial = " + editorialId;

		return jdbcTemplate.query(sqlSelect, new LibrosExtractor());
	}

	public List<Autor> obtenerAutores() {
		String sqlSelect = "SELECT id_autor, nombre_autor, apellidos_autor FROM Autor";
		
		return jdbcTemplate.query(sqlSelect, new AutoresExtractor());
	}
	

	public void guardar(Libro libro, ArrayList<Integer> idAutores) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);

			String sqlInsertLibro = "Insert INTO Libro VALUES (?,?,?,?)";
			
			PreparedStatement statementLibro = conexion.prepareStatement(sqlInsertLibro, Statement.RETURN_GENERATED_KEYS);
			statementLibro.setString(1, libro.getTitulo());
			statementLibro.setInt(2, libro.getAnio());
			statementLibro.setDouble(3, libro.getPrecio());
			statementLibro.setInt(4, libro.getEditorial().getId());
			
			statementLibro.executeUpdate();
			
			
			ResultSet rs = statementLibro.getGeneratedKeys(); 
			
			if(rs.next()) {
				libro.setId(rs.getInt(1));
			}
			
			String sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES (?,?)";
			
			if(true)throw new SQLException("JJoo");
			for(int i=0; i < idAutores.size(); i++) {
				PreparedStatement statementLibroAutor = conexion.prepareStatement(sqlInsertLibroAutor);
				statementLibroAutor.setInt(1, libro.getId());
				statementLibroAutor.setInt(2, idAutores.get(i));
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
	}
		
	

}

class LibrosExtractor implements ResultSetExtractor<List<Libro>> {
	
	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {
			int id = rs.getInt("id_libro");
			libro = map.get(id);

			if (libro == null) {
				libro = new Libro();
				libro.setAnio(rs.getInt("ano"));
				libro.setId(id);
				libro.setPrecio(rs.getInt("precio"));
				libro.setTitulo(rs.getString("titulo"));
				map.put(id, libro);
			}
			
		}

		return new ArrayList<Libro>(map.values());
	}	
	
}

class AutoresExtractor implements ResultSetExtractor<List<Autor>> {
	
	@Override
	public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) { 
				autor = new Autor();
				autor.setId(id);
				autor.setNombre(rs.getString("nombre_autor"));
				autor.setApellidos(rs.getString("apellidos_autor"));
				map.put(id, autor);
			} // if
		
		} // while
		return new ArrayList<Autor>(map.values());
	} // extractData
}