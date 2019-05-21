package com.orbis.B77436.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;


@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Transactional(readOnly=true)
	public Iterator<Libro> buscarPorId(int id_editorial) {
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio, l.id_editorial"
				+ " FROM Libro l "
				+ " WHERE l.id_editorial="+id_editorial;
		return jdbcTemplate.query(sqlSelect, new LibroWithExtractor());
	}
	
	@Transactional(readOnly=true)
	public void save(Libro libro, Libro_Autor libroAutor) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertLibro = "Insert into Libro Values( ?, ?, ?, ?, ?)";
			
			PreparedStatement statementLibro = conexion.prepareStatement(sqlInsertLibro);
			statementLibro.setInt(1, libro.getId_libro());
			statementLibro.setString(2, libro.getTitulo());
			statementLibro.setShort(3, libro.getAno());
			statementLibro.setFloat(4, libro.getPrecio());
			statementLibro.setInt(5, libro.getId_editorial());
			statementLibro.executeUpdate();
			
			String sqlInsertLibroAutor = "";
			for(int i=0; i < libroAutor.getId_autor().size(); i++) {
				sqlInsertLibroAutor = "Insert into Libro_Autor VALUES (?, ?)";
				PreparedStatement statementLibroAutor = conexion.prepareStatement(sqlInsertLibroAutor);
				statementLibroAutor.setInt(1, libroAutor.getId_libro());
				statementLibroAutor.setInt(2, libroAutor.getId_autor().get(i));
				statementLibroAutor.executeUpdate();
				
			}
			
			
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e3) {
					throw new RuntimeException(e3);
				}
			}
		}
	}
	
	
}

class LibroWithExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		
		Libro libro = null;
		while (rs.next()) {
			Integer id_edito = rs.getInt("id_editorial");
			Integer id_libro = rs.getInt("id_libro");
			Short ano = rs.getShort("ano");
			Float precio = rs.getFloat("precio");
			libro = map.get(id_libro);
			if (libro == null) { 
				libro = new Libro();
				libro.setId_libro(id_libro);
				libro.setTitulo(rs.getString("titulo"));
				
				libro.setAno(ano);
				libro.setPrecio(precio);
				libro.setId_editorial(id_edito);
				
				map.put(id_libro, libro);
			} 
			 
		}
		
		return map.values().iterator();
	} 
	
	
}