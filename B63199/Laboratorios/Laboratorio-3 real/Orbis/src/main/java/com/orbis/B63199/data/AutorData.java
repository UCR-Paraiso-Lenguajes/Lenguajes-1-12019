package com.orbis.B63199.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.orbis.B63199.domain.Autor;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	
	@Transactional(readOnly=true)
	public void modificarAutorPorId(int id, Autor autor)
	{
		String sqlUpdate = 
				"UPDATE Autor SET nombre_autor = '"+ autor.getNombre()+"', apellidos_autor = '"
						+autor.getApellidos()+"' where id_autor = "+id;
		
		jdbcTemplate.batchUpdate(sqlUpdate);
	}
	
	@Transactional(readOnly=true)
	public void eliminarAutorConId(int id) {
		String sqlDelete=
				"DELETE FROM Autor WHERE id_autor = "+id;
		jdbcTemplate.batchUpdate(sqlDelete);
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
