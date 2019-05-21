package com.orbis.B77436.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;

@Repository
public class AutorData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Transactional(readOnly=true)
	public Iterator<Autor> findAutores() throws SQLException {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor"
				+ " FROM Autor  ";
		return jdbcTemplate.query(sqlSelect, new ActorInfo());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Autor> findApellidosAutores(String apellidosAutor) throws SQLException {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor"
				+ " FROM Autor WHERE apellidos_autor like '%"+apellidosAutor+"%'";
		return jdbcTemplate.query(sqlSelect, new ActorInfo());
	}
	
	
	@Transactional(readOnly=true)
	public Iterator<Autor> findAutorId(int id_autor) throws SQLException {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor"
				+ " FROM Autor WHERE id_autor = "+id_autor;
		return jdbcTemplate.query(sqlSelect, new ActorInfo());
	}
	@Transactional(readOnly=true)
	public void update(int id, Autor autor) {
		String sqlSelect = "UPDATE Autor set  nombre_autor = '"+autor.getNombre_autor()+"',"
						+ " apellidos_autor = '"+autor.getApellidos_autor()+"' where id_autor = "+id;
		jdbcTemplate.batchUpdate(sqlSelect);
	}
	@Transactional(readOnly=true)
	public void delete1(int id_autor) {
		jdbcTemplate.update("Delete from Autor where id_autor = ?", new Object[] {id_autor});
		jdbcTemplate.update("Delete from Libro_Autor where id_autor = ?", new Object[] {id_autor});
	}
	
	@Transactional
	public void delete(int id_autor) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String deleteLibro_Autor ="Delete from Libro_Autor where id_autor ="+id_autor;
			String deleteAutor ="Delete from Autor where id_autor = "+id_autor;
			//jdbcTemplate.update("Delete from Libro_Autor where id_autor = ?", new Object[] {id_autor});
			//jdbcTemplate.update("Delete from Autor where id_autor = ?", new Object[] {id_autor});
			jdbcTemplate.execute(deleteLibro_Autor);
			jdbcTemplate.execute(deleteAutor);
			
			
			conexion.commit();
			//conexion.rollback();
			
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

class ActorInfo implements ResultSetExtractor<Iterator<Autor>> {
	@Override
	public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) { 
				autor = new Autor();
				autor.setId_autor(id);
				autor.setNombre_autor(rs.getString("nombre_autor"));
				autor.setApellidos_autor(rs.getString("apellidos_autor"));
				
				map.put(id, autor);
			} 
			 
		}
		
		return map.values().iterator();
	} 
}
