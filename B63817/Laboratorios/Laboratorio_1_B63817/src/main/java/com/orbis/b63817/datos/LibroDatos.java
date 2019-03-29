package com.orbis.b63817.datos;

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

import com.orbis.b63817.dominio.Libro;
import com.orbis.b63817.dominio.Libro;

@Repository
public class LibroDatos {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Libro> mostrarLibros(int id_Libro) {
		String sqlSelect = "SELECT p.id_libro,p.titulo,p.ano,p.precio,p.id_Libro"
				+ " FROM Libro "
				+ " WHERE p.id_Libro>= %"+id_Libro+"%'";
				
		 return jdbcTemplate.query(sqlSelect, new LibroExtractor());
	}// findMoviesByTitleAndGenre
}

class LibroExtractor implements ResultSetExtractor<List<Libro>> {
	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_Libro");
			libro = map.get(id);
			if (libro == null) { // new Libro record
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAno(rs.getInt("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				map.put(id, libro);	
		}} // if
		
	return new ArrayList<Libro>(map.values());
}
	}
	
