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

import com.orbis.b63817.ventas.dominio.Actor;
import com.orbis.b63817.ventas.dominio.Libro;
import com.orbis.b63817.ventas.dominio.Libro;

@Repository
public class LibroDatos {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro> mostrarLibros(int id_Editorial) {
		String sqlSelect = "Select id_libro,titulo,ano,precio,id_editorial " + 
				"From Libro " + 
				"Where id_editorial ="+id_Editorial;
		return jdbcTemplate.query(sqlSelect, new LibrosPorEditorialExtractor());
	}// findMoviesByTitleAndGenre
}

class LibrosPorEditorialExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { // new Libro record
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAno(rs.getInt("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				libro.setId_editorial(rs.getInt("id_editorial"));
			map.put(id, libro);
			} // if
			
		} // while
		return new ArrayList<Libro>(map.values()).iterator();
	} // extractData
}