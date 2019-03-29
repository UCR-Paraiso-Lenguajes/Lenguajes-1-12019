package com.orbis.b63199.datos;

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

import com.orbis.b63199.dominio.Autor;
import com.orbis.b63199.dominio.Libro;

@Repository
public class LibroDatos {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Libro libro;
	
	@Transactional(readOnly=true)
	private List<Libro> listarLibrosPorIdEditorial(int id_Editorial){
		String sqlSelect = ""
				+ "Select l.id_libro, l.titulo, l.ano, l.precio, l.id_editorial"
				+ "from Librro l"
				+ "where l.id_editorial = "+id_Editorial;
		return jdbcTemplate.query(sqlSelect, new LibroExtractor());
	}
}

class LibroExtractor implements ResultSetExtractor<List<Libro>> {
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { // new pelicula record
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setPrecio(rs.getInt("precio"));
				libro.setAno(rs.getInt("ano"));

				map.put(id, libro);
			} // if
			int autorId = rs.getInt("id_autor");
			if (autorId > 0) {
				Autor autor = new Autor();
				autor.setId_autor(autorId);
				autor.setNombre(rs.getString("nombre_actor"));
				autor.setApellidos(rs.getString("apellidos_actor"));
				libro.getAutores().add(autor);
			} // if
			// TODO Auto-generated method stub
		} // while
		return new ArrayList<Libro>(map.values());
	} // extractData
	
}
