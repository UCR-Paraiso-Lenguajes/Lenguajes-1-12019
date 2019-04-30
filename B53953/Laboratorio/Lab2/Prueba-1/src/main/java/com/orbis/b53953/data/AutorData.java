package com.orbis.b53953.data;

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

import com.orbis.b53953.domain.Autor;


@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public List<Autor> encontrarAutores() {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor"
				+ " FROM Autor a";
		return jdbcTemplate.query(sqlSelect, new ListaAutores());
	}
}

class ListaAutores implements ResultSetExtractor<List<Autor>> {
	@Override
	public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) { // new editorial record
				autor = new Autor();
				autor.setIdAutor(id);
				autor.setNombreAutor(rs.getString("nombre_autor"));
				autor.setNombreAutor(rs.getString("apellidos_autor"));
				map.put(id, autor);
			} 
		} // while
		return new ArrayList<Autor>(map.values());
	} // extractData
}
