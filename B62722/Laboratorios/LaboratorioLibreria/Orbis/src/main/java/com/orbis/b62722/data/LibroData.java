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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b62722.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Transactional(readOnly = true)
	public List<Libro> buscarLibro(int idEditorial) {
		String sqlSelect= "select l.id_libro, l.año,l.titulo,l.precio, e.nombre "
				+ "from Libro l, Editorial e where l.id_editorial="+idEditorial +"and e.id_editorial=" +idEditorial;

		return jdbcTemplate.query(sqlSelect, new LibroExtractor());

	}
	
	@Transactional
	 public Libro save(Libro libro) throws SQLException {
	  SqlParameterSource parameterSource = new MapSqlParameterSource()
	    .addValue("@isbn", libro.getId_libro())
	    .addValue("@titulo", libro.getTitulo())
	    .addValue("@año", libro.getAno())
	    .addValue("@editorial", libro.getEditorial().getNombre())
	    .addValue("@autor", libro.getAutores());
	  Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
	  return libro;
	  
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
				libro.setAno(rs.getInt("año"));
				libro.setPrecio(rs.getFloat("precio"));
				map.put(id, libro);
			} 
		} 
		return new ArrayList<Libro>(map.values());
	}
}