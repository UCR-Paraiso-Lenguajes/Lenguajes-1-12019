package com.orbis.b67156.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b67156.domain.Editorial;
@Repository
public class EditorialData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Editorial>  buscarPorEditorial(int idEditorial) {
		String sqlSelect = "SELECT e.id_editorial,e.nombre,e.direccion,e.telefono"
				+ " FROM Editorial e "
				+ " WHERE id_editorial ="+idEditorial;
		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Editorial>  buscarPorBloque(int valorInicial, int valorFinal){
		String sqlSelect = "SELECT e.id_editorial,  e.nombre,  e.direccion, e.telefono FROM\r\n" + 
				"(SELECT ROW_NUMBER() OVER (ORDER BY id_editorial) AS MyRowNumber, id_editorial,  nombre,  direccion,  telefono\r\n" + 
				"FROM Editorial) tbl\r\n" + 
				"WHERE MyRowNumber BETWEEN "+ valorInicial+ "AND" + valorFinal;
		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
	
}




