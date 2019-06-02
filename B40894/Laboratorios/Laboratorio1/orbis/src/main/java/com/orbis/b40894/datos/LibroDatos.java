package com.orbis.b40894.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b40894.dominio.Libro;

@Repository
public class LibroDatos {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
@Transactional(readOnly=true)
	public Iterator<Libro> buscarLibro(int cantidadInicio, int cantidadFinal, int editorial) {
		String sqlSelect = 
				"SELECT DISTINCT libro.id_libro, libro.titulo, libro.anno, libro.precio\r\n" + 
				"FROM (SELECT ROW_NUMBER() OVER (ORDER BY libro.id_libro) AS row_number,  \r\n" + 
				"libro.id_libro,libro.titulo, libro.anno, libro.precio\r\n" + 
				"FROM Libro libro Where libro.id_editorial="+editorial+" ) as libro\r\n" + 
				"WHERE row_number BETWEEN "+cantidadInicio+" AND "+cantidadFinal;
				

		return jdbcTemplate.query(sqlSelect, new listarLibros());
	}

class listarLibros implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { 
				libro = new Libro();
				libro.setIdLibro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAnno(rs.getInt("anno"));
				libro.setPrecio(rs.getFloat("precio"));
				map.put(id, libro);
			} // if
			
		} // while
		return new ArrayList<Libro>(map.values()).iterator();
	} // extractData

}

}
