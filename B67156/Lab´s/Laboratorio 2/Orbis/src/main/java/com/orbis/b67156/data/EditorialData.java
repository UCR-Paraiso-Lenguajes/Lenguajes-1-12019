package com.orbis.b67156.data;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		String sqlSelect = "SELECT e.id_editorial,e.nombre,e.direccion,e.telefono"
				+ " FROM Editorial e,(SELECT ROW_NUMBER() OVER (ORDER BY id_editorial) AS MyRowNumber, id_editorial,  nombre,  direccion,  telefono FROM Editorial) tbl"
				+ " WHERE MyRowNumber BETWEEN "+ valorInicial+ " AND "+ valorFinal;
		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
	
}




