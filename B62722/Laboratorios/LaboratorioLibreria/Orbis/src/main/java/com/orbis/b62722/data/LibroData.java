package com.orbis.b62722.data;

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

import com.orbis.b62722.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Libro> buscarLibro(int idEditorial) {
		String sqlSelect="select l.id_libro, l.año,l.titulo,l.precio, e.nombre" + 
		          " from Libro l, Editorial e where l.id_editorial="
		          + idEditorial+ " and e.id_editorial="+ idEditorial;

		return jdbcTemplate.query(sqlSelect, new LibroExtractor());

	}
}

class LibroExtractor implements ResultSetExtractor<List<Libro>> {
	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { 
				libro = new Libro();
				libro.setId_libro(id);;
				libro.setTitulo(rs.getString("titulo"));
				libro.setAño(rs.getInt("año"));
				libro.setPrecio(rs.getFloat("precio"));
				libro.getEditorial().setId_editorial(rs.getInt("id_editorial"));
				map.put(id, libro);
			} 
		} 
		return new ArrayList<Libro>(map.values());
	}
}
