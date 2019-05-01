package com.orbis.b40894.ventas.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b40894.ventas.domain.Libro;
import com.orbis.b40894.ventas.domain.form.LibroForm;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public Iterator<Libro> findLibroByEditorial(int idEditorial) {
		String sqlSelect = "Select id_libro,titulo,ano,precio,id_editorial " + "From Libro " + "Where id_editorial ="
				+ idEditorial;

		return jdbcTemplate.query(sqlSelect, new LibroExtractor());
	}

	@Transactional(readOnly = true)
	public void addBook(LibroForm libro) throws SQLException {
		
		System.out.println(libro.toString());
		
		String sqlInsertBook = "Insert into Libro(titulo,ano,precio,id_editorial,isbn) values (?,?,?,?,?)";	
		
		Connection conexion = null;
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
		
		try {
		PreparedStatement statementInsertBook = conexion.prepareStatement(sqlInsertBook, Statement.RETURN_GENERATED_KEYS);
		
	    statementInsertBook.setString(1, libro.getTitulo());
	    statementInsertBook.setInt(2, libro.getAnno());
	    statementInsertBook.setDouble(3, libro.getPrecio());
	    statementInsertBook.setInt(4, libro.getIdEditorial());
	    statementInsertBook.setInt(5, libro.getIsbn());
	    
		int filas = statementInsertBook.executeUpdate();
		
		conexion.commit();
		
		if (filas == 0) {
            throw new SQLException("Inserción del libro fallida.");
        }

        try (ResultSet generatedKeys = statementInsertBook.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            	libro.setId_libro(generatedKeys.getInt(1));
            	
            	addAutorByBook(libro.getId_libro(),libro);
            	
            }
            else {
                throw new SQLException("No se tienen PK generadas.");
            }
        }
		}catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				}catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		  }
	    }

	public void addAutorByBook(int cod_libro, LibroForm libro) throws SQLException {
		
		String sqlInsertAutorByBook = "Insert into Libro_Autor(id_libro,id_autor) values (?,?)";
		
		Connection conexion = null;
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
		try {
		
        PreparedStatement statementInsertAutorByBook = conexion.prepareStatement(sqlInsertAutorByBook);
        
		for (int i = 0; i < libro.getListaFinal().size(); i++) {
					
			int id_autor = Integer.parseInt(libro.getListaFinal().get(i).toString());
			System.out.println(id_autor);
			statementInsertAutorByBook.setInt(1, cod_libro);
			statementInsertAutorByBook.setInt(2, id_autor);
			
			statementInsertAutorByBook.addBatch();				
		}

		statementInsertAutorByBook.executeBatch();
		
		conexion.commit();
	       }catch (SQLException e) {
				throw new RuntimeException(e);
	       }
		}
	
}



class LibroExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) {
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAno(rs.getInt("ano"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setIdEditorial(rs.getInt("id_editorial"));
				map.put(id, libro);
			}
		}
		return new ArrayList<Libro>(map.values()).iterator();
	}
}
