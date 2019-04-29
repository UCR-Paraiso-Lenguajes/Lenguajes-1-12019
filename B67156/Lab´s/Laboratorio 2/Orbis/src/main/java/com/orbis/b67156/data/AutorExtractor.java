package com.orbis.b67156.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.orbis.b67156.domain.Autor;


public class AutorExtractor implements ResultSetExtractor<Iterator<Autor>>{
	
	@Override
	public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) {
//				autor = new Autor();
				autor.setIdAutor(id);
				autor.setNombreAutor(rs.getString("nombre_autor"));
				autor.setApellidosAutor(rs.getString("apellidos_autor"));
				map.put(id, autor);
			} 
			
		} 
		return map.values().iterator();
	} 

}
