package com.orbis.b73027.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Iterator;
import com.orbis.b73027.domain.Libro;
import com.orbis.b73027.domain.Libro_Autor;


@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  searchPorEditorial(int idEditorial) {
		String sqlSelect = "SELECT i.id_libro,i.titulo,i.ano,i.precio,i.id_editorial"
				+ " FROM Libro i "
				+ " WHERE id_editorial ="+idEditorial;
		return jdbcTemplate.query(sqlSelect, new searchPorEditorial ());
	}//  searchPorEditorial 
	@Transactional
	public void guardarLibro(Libro libro, Libro_Autor libroAutor) {
		Connection conexion = null;
		
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
		
			String sqlInsertLibro = "Insert into Libro VALUES "
					+ "( " +libro.getId_libro()+ ", " 
					+ "'"+libro.getTitulo()+ "', " 
					+ libro.getAno()+", " 
					+ libro.getPrecio()
					+", "+libro.getId_editorial()+")";
		
			jdbcTemplate.batchUpdate(sqlInsertLibro);
			String sqlInsertLibroAutor = "";
		
			for(int i=0; i < libroAutor.getListAutores().size(); i++) {
				sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES ("+ libroAutor.getId_libro() + ", " +libroAutor.getListAutores().get(i)+")";
				jdbcTemplate.batchUpdate(sqlInsertLibroAutor);
			
			}
			conexion.commit();
		
		}catch (Exception e) {
		
			try {
				conexion.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
			
	}
		

}
class searchPorEditorial  implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			Integer idLibro = rs.getInt("id_libro");
			short ano = rs.getShort("ano");
			float precio = rs.getFloat("precio");
			
			
			libro = map.get(idLibro);
			if (libro == null) { 
				libro = new Libro();
				libro.setId_editorial(id);
				libro.setId_libro(idLibro);
				libro.setAno(ano);
				libro.setPrecio(precio);
				libro.setTitulo(rs.getString("titulo"));
				
				
				map.put(idLibro, libro);
			} // if
			
		} // while
		return map.values().iterator();
	} // extractData
	
	
}