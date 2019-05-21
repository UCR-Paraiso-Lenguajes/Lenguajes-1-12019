package com.orbis.B70620.ventas.data;

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

import com.orbis.B70620.ventas.domain.Autor;


@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		String sqlSelect = "DELETE FROM Autor " + 
				"WHERE id_autor = " + autor.getId();

	    jdbcTemplate.update(sqlSelect);
		
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
