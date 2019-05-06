package com.orbis.B77436.data;

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

import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;


@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro> buscarPorId(int id_editorial) {
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio, l.id_editorial"
				+ " FROM Libro l "
				+ " WHERE l.id_editorial="+id_editorial;
		return jdbcTemplate.query(sqlSelect, new LibroWithExtractor());
	}
	
	
}

class LibroWithExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		
		Libro libro = null;
		while (rs.next()) {
			Integer id_edito = rs.getInt("id_editorial");
			Integer id_libro = rs.getInt("id_libro");
			Short ano = rs.getShort("ano");
			Float precio = rs.getFloat("precio");
			libro = map.get(id_libro);
			if (libro == null) { 
				libro = new Libro();
				libro.setId_libro(id_libro);
				libro.setTitulo(rs.getString("titulo"));
				
				libro.setAno(ano);
				libro.setPrecio(precio);
				libro.setId_editorial(id_edito);
				
				map.put(id_libro, libro);
			} 
			 
		}
		
		return map.values().iterator();
	} 
}