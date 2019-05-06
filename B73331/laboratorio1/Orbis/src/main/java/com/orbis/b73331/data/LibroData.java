package com.orbis.b73331.data;

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

import com.orbis.b73331.domain.Editorial;
import com.orbis.b73331.domain.Libro;


@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  buscarPorIdEditorial(int idEditorial) {
		String sqlSelect = "SELECT id_libro, titulo, ano, precio, id_editorial FROM Libro WHERE id_editorial = "+idEditorial;
		return jdbcTemplate.query(sqlSelect, new buscarLibroIdEditorial());
	}//  searchPorEditorial 
}

class buscarLibroIdEditorial implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { // new editorial record
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo((rs.getString("titulo")));
				libro.setAno(rs.getShort("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				map.put(id, libro);
			} // if
			
		} // while
		return map.values().iterator();
	} // extractData
	
	
}

