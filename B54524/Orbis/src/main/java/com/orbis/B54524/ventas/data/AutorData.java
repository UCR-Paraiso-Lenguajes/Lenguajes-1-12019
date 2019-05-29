package com.orbis.B54524.ventas.data;

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
import org.springframework.transaction.annotation.Transactional;
import com.orbis.B54524.ventas.domain.Autor;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Autor> obtenerAutorPorId(int id) {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor FROM Autor a "
				+ "WHERE a.id_autor = "+id;
		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}

	@Transactional(readOnly = true)
	public List<Autor> buscarAutores(String apellidos) {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor FROM Autor a "
				+ "WHERE a.apellidos_autor  LIKE '%"+apellidos+"%'";
		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}
	
	@Transactional
	public void update(int id, Autor autor) {
		String sql = "UPDATE Autor SET nombre_autor = '"+autor.getNombre()+"', "
				+ "apellidos_autor = '"+autor.getApellidos()+"' "
						+ "WHERE id_autor = "+autor.getId();
		
		jdbcTemplate.batchUpdate(sql);
	}
	

	public void delete(int id) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlIntermedia = "DELETE FROM Libro_Autor WHERE id_autor= "+id;
			PreparedStatement statementLibro = conexion.prepareStatement(sqlIntermedia);
			statementLibro.executeUpdate();
			String sql = "DELETE FROM Autor WHERE id_autor = "+id;
			PreparedStatement statementLibroAutor = conexion.prepareStatement(sql);
			statementLibroAutor.executeUpdate();
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

class AutorExtractor implements ResultSetExtractor<List<Autor>> {

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
			}
		}
		return new ArrayList<Autor>(map.values());
	}
}
