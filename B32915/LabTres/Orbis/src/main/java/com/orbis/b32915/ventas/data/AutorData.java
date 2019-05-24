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

import com.orbis.b32915.ventas.domain.Autor;
import com.orbis.b32915.ventas.domain.Libro;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Iterator<Autor> findAllAutores() {
		String sqlSelect = "Select id_autor,nombre_autor,apellidos_autor " + "From Autor ";

		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}

	public void update(int id, Autor autor) {

		String sqlSelect = "UPDATE Autor SET nombre_autor = '" + autor.getNombreAutor() + "', apellidos_autor = '"
				+ autor.getApellidosAutor() + "' Where id_autor = " + id;
		jdbcTemplate.batchUpdate(sqlSelect);

	}

	public void delete(int id) {

		String sqlSelect = "DELETE from Libro_Autor Where id_autor = " + id;
		jdbcTemplate.batchUpdate(sqlSelect);

		String sqlSelect2 = "DELETE from Autor Where id_autor = " + id;
		jdbcTemplate.batchUpdate(sqlSelect2);
	}

	@Transactional(readOnly = true)
	public Iterator<Autor> obtenerAutorPorId(int id) {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor FROM Autor a " + "WHERE a.id_autor = "
				+ id;
		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}

	class AutorExtractor implements ResultSetExtractor<Iterator<Autor>> {
		@Override
		public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Autor> map = new HashMap<Integer, Autor>();
			Autor autor = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_autor");
				autor = map.get(id);
				if (autor == null) {
					autor = new Autor();
					autor.setIdAutor(id);
					autor.setNombreAutor(rs.getString("nombre_autor"));
					autor.setApellidosAutor(rs.getString("apellidos_autor"));
					map.put(id, autor);
				}
			}
			return new ArrayList<Autor>(map.values()).iterator();
		}
	}
}
