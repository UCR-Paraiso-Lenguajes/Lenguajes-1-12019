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

import com.orbis.B70620.ventas.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Libro> obtenerLibrosPorEditorial(int editorialId) {
		String sqlSelect = "SELECT ano, id_libro, precio, titulo "
				+ "FROM Libro WHERE id_editorial = " + editorialId;

		/*
		String sqlSelect = "SELECT e.id_editorial, l.ano, l.id_editorial, l.id_libro, l.precio, l.titulo "
				+ "FROM Editorial e join Libro l on e.id_editorial = l.id_editorial WHERE " + editorialId
				+ " = l.id_editorial";
*/
		return jdbcTemplate.query(sqlSelect, new LibrosExtractor());
	}

}

class LibrosExtractor implements ResultSetExtractor<List<Libro>> {
	
	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {
			int id = rs.getInt("id_libro");
			libro = map.get(id);

			if (libro == null) {
				libro = new Libro();
				libro.setAnio(rs.getInt("ano"));
				libro.setId(id);
				libro.setPrecio(rs.getInt("precio"));
				libro.setTitulo(rs.getString("titulo"));
				map.put(id, libro);
			}
			
		}

		return new ArrayList<Libro>(map.values());
	}	
	
}