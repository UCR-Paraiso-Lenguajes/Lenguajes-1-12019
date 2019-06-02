package com.orbis.B76223.ventas.data;

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

import com.orbis.B76223.ventas.domain.Editorial;
import com.orbis.B76223.ventas.domain.Libro;

@Repository
public class EditorialData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Editorial> listarEditorial(int numInicio, int numFinal) {
		String sqlSelect = "SELECT e.id_editorial, e.nombre, e.direccion, e.telefono, cuentaRegistros, "
				+ "l.ano, l.id_editorial, l.id_libro, l.precio, l.titulo "
				+ "FROM Editorial e join Libro l on e.id_editorial = l.id_editorial " + "WHERE e.cuentaRegistros > "
				+ numInicio + " AND e.cuentaRegistros < " + numFinal;

		return jdbcTemplate.query(sqlSelect, new EditorialConLibrosExtractor());
	}

	@Transactional(readOnly = true)
	public List<Libro> listarLibrosPorEditorial(int idEditorial) {
		String sqlSelect = "SELECT e.id_editorial, l.ano, l.id_editorial, l.id_libro, l.precio, l.titulo "
				+ "FROM Editorial e join Libro l on e.id_editorial = l.id_editorial WHERE " + idEditorial
				+ " = l.id_editorial";

		return jdbcTemplate.query(sqlSelect, new LibrosExtractor());
	}

class EditorialConLibrosExtractor implements ResultSetExtractor<List<Editorial>> {
	@Override
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;

		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);

			if (editorial == null) {
				editorial = new Editorial();
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				editorial.setIdEditorial(rs.getInt("id_editorial"));
				editorial.setNumeroRegistro(rs.getInt("cuentaRegistros"));
				map.put(id, editorial);
			}
			
			int idLibro = rs.getInt("id_libro");
			if(idLibro > 0) {
				Libro libro = new Libro();
				libro.setIdLibro(idLibro);
				libro.setAno(rs.getInt("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				libro.setTitulo(rs.getString("titulo"));
			}
		}

		return new ArrayList<Editorial>(map.values());
	}
	
	
	
}

class LibrosExtractor implements ResultSetExtractor<List<Libro>> {
	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {
			int idLibro = rs.getInt("id_libro");
			libro = map.get(idLibro);

			if (libro == null) {
				libro = new Libro();
				libro.setAno(rs.getInt("ano"));
				libro.setIdLibro(idLibro);
				libro.setPrecio(rs.getInt("precio"));
				libro.setTitulo(rs.getString("titulo"));
				map.put(idLibro, libro);
			}
			
		}

		return new ArrayList<Libro>(map.values());
	}
	
	
	
}

}
