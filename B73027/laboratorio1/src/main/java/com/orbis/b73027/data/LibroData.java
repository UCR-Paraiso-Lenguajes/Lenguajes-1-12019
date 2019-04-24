package com.orbis.b73027.data;

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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b73027.domain.Editorial;
import com.orbis.b73027.domain.Libro;


@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  searchPorEditorial(int idEditorial) {
		String sqlSelect = "SELECT i.id_libro,i.titulo,i.ano,i.precio,i.id_editorial"
				+ " FROM Libro i "
				+ " WHERE id_editorial ="+idEditorial;
		return jdbcTemplate.query(sqlSelect, new searchPorEditorial ());
	}//  searchPorEditorial 
}
class searchPorEditorial  implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			Integer idLibro = rs.getInt("id_libro");
			short ano = rs.getShort("ano");
			float precio = rs.getFloat("precio");
			
			
			libro = map.get(idLibro);
			if (libro == null) { 
				libro = new Libro();
				libro.setId_editorial(id);
				libro.setId_libro(idLibro);
				libro.setAno(ano);
				libro.setPrecio(precio);
				libro.setTitulo(rs.getString("titulo"));
				
				
				map.put(idLibro, libro);
			} // if
			
		} // while
		return map.values().iterator();
	} // extractData
	
	
}