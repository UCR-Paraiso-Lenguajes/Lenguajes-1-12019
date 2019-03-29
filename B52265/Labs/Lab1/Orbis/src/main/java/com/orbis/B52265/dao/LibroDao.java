package com.orbis.B52265.dao;

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

import com.orbis.B52265.dao.EditorialDao.EditorialWithLibrosExtractor;
import com.orbis.B52265.domain.Editorial;
import com.orbis.B52265.domain.Libro;
@Repository
public class LibroDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Libro> getLibros(int id) {
		String sqlSelect = "select l.id_libro, l.titulo,l.ano,l.precio\r\n" + 
				"from libro l\r\n" + 
				"where l.id_editorial = "+id;
		System.out.print(id);
		return jdbcTemplate.query(sqlSelect, new LibrosWithExtractor());
	}

	/*
	 * @Transactional(readOnly = true) public List<Pelicula> peliculas() { String
	 * sqlSelect = "SELECT * FROM Pelicula"; return jdbcTemplate.query(sqlSelect,
	 * new PeliculasWithActoresExtractor()); }
	 */

	class LibrosWithExtractor implements ResultSetExtractor<List<Libro>> {

		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_libro");
				libro = map.get(id);
				if (libro == null) {
					libro = new Libro();
					libro.setIdLibro(id);
					libro.setTitulo(rs.getString("titulo"));
					libro.setAno(rs.getShort("ano"));
					libro.setPrecio(rs.getInt("precio"));

					map.put(id, libro);

				}

			}
			return new ArrayList<Libro>(map.values());
		}

	}
}
