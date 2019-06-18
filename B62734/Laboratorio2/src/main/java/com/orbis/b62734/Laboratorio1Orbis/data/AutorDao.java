package com.orbis.b62734.Laboratorio1Orbis.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b62734.Laboratorio1Orbis.domain.*;
@Repository
public class AutorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Autor> buscarAutores(){
		
		String sqlSelect="select id_autor,nombre_autor,apellidos_autor from autor" + 
				" order by id_autor";
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());
	}
	
	
}

class autoresWithIdExtractor implements ResultSetExtractor<List<Autor>>{

	@Override
	public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Autor> list = new LinkedList<>();
		Autor autor = null;
		while(rs.next()) {
			Integer idautorActual = rs.getInt("id_autor");
				autor = new Autor();
				autor.setIdAutor(idautorActual);
				autor.setNombreAutor(rs.getString("nombre_autor"));
				autor.setApellidosAutor(rs.getString("apellidos_autor"));
				list.add(autor);
			}
		return list;
	}

}
