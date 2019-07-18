package com.orbis.B77436.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B77436.domain.Autor;
import com.orbis.B77436.domain.Editorial;

@Repository
public class AutorData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	
	@Transactional(readOnly=true)
	public Iterator<Autor> findAutores() throws SQLException {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor"
				+ " FROM Autor  ";
		return jdbcTemplate.query(sqlSelect, new ActorInfo());
	}
	

}

class ActorInfo implements ResultSetExtractor<Iterator<Autor>> {
	@Override
	public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) { 
				autor = new Autor();
				autor.setId_autor(id);
				autor.setNombre_autor(rs.getString("nombre_autor"));
				autor.setApellidos_autor(rs.getString("apellidos_autor"));
				
				map.put(id, autor);
			} 
			 
		}
		
		return map.values().iterator();
	} 
}
