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
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B70620.ventas.domain.Autor;


@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private DataSource dataSource;
	
	@Transactional(readOnly=true)
	public List<Autor> obtenerAutoresPorApellidos(String apellidos) {
		String sqlSelect = "SELECT id_autor, nombre_autor, apellidos_autor FROM Autor "
				+ "WHERE apellidos_autor LIKE '%"+ apellidos+"%'";

		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}

	public void editarAutor(Autor autor) {
		String sqlSelect = "UPDATE Autor " + 
				"SET  nombre_autor = '"+autor.getNombre()+"', apellidos_autor = '"+autor.getApellidos()+"' " + 
				"WHERE id_autor = " + autor.getId();

	    jdbcTemplate.update(sqlSelect);
		
	}

	public void eliminarAutor(Autor autor) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);

			String deleteSQL = "DELETE FROM LIBRO_AUTOR WHERE ID_AUTOR = ?";
			
			PreparedStatement statementLibroAutor = conexion.prepareStatement(deleteSQL, Statement.RETURN_GENERATED_KEYS);

			statementLibroAutor.setInt(1, autor.getId());

			statementLibroAutor.executeUpdate();
			
			deleteSQL = "DELETE FROM AUTOR WHERE ID_AUTOR = ?";
			
			

			PreparedStatement statementAutor = conexion.prepareStatement(deleteSQL);
			statementAutor .setInt(1, autor.getId());
			statementAutor.executeUpdate();

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
			} // if
		
		} // while
		return new ArrayList<Autor>(map.values());
	} // extractData
}
