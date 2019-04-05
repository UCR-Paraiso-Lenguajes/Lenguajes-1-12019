package com.orbis.b32915.ventas.data;

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
import com.orbis.b32915.ventas.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Transactional(readOnly = true)
	public Iterator<Libro> findLibroByEditorial(int idEditorial) {
		String sqlSelect = "Select id_libro,titulo,ano,precio,id_editorial " + 
				"From Libro " + 
				"Where id_editorial ="+idEditorial;

		return jdbcTemplate.query(sqlSelect, new LibroExtractor());
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
