package com.orbis.b54524.datos;

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

import com.orbis.b54524.dominio.Autor;



@Repository
public class AutorDatos {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public Iterator<Autor> encontrarAutores() {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor"
				+ " FROM Autor a";
		return jdbcTemplate.query(sqlSelect, new ListaAutores());
	}
}

class ListaAutores implements ResultSetExtractor<Iterator<Autor>> {
	@Override
	public Iterator<Autor> extractData(ResultSet rs)throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) { // new editorial record
				autor = new Autor();
				try {
					autor.setIdAutor(id);
					autor.setNombreAutor(rs.getString("nombre_autor"));
					autor.setApellidosAutor(rs.getString("apellidos_autor"));
				}catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
				
				map.put(id, autor);
			} 
		} // while
		return new ArrayList<Autor>(map.values()).iterator();
	} // extractData
}
