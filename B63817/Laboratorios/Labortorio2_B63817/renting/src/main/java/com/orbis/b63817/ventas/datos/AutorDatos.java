package com.orbis.b63817.ventas.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63817.ventas.dominio.Autor;
import com.orbis.b63817.ventas.dominio.Autor;

@Repository
public class AutorDatos {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Autor> mostrarAutores() {
		String sqlSelect = "Select id_autor,nombre_Autor, apellidos_autor, telefono " + 
				"From Autor ";
		return jdbcTemplate.query(sqlSelect, new AutorsExtractor());
	}// findMoviesByTitleAndGenre
}

class AutorsExtractor implements ResultSetExtractor<Iterator<Autor>> {
	@Override
	public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor Autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			Autor = map.get(id);
			if (Autor == null) { // new Autor record
				Autor = new Autor();
				Autor.setId_autor(id);
				Autor.setNombre_Autor(rs.getString("nombre_Autor"));
				Autor.setApellidos_autor(rs.getString("apellidos_autor"));
				Autor.setTelefono(rs.getString("telefono"));
				
			map.put(id, Autor);
			} // if
			
		} // while
		return new ArrayList<Autor>(map.values()).iterator();
	} // extractData
}