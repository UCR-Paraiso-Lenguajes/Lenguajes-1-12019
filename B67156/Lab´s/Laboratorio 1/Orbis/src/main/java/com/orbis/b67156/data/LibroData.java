package com.orbis.b67156.data;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b67156.domain.Libro;

@Repository
public class LibroData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  buscarPorEditorial(int id_editorial) {
		String sqlSelect = "SELECT l.id_libro,l.titulo,l.ano,l.precio, l.id_editorial"
				+ " FROM Libro l "
				+ " WHERE id_editorial ="+id_editorial;
		return jdbcTemplate.query(sqlSelect, new LibroExtractor());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  buscarPorBloque(int valorInicial, int valorFinal){
		String sqlSelect = "SELECT id_libro,titulo,ano,precio, id_editorial FROM\r\n" + 
				"(SELECT ROW_NUMBER() OVER (ORDER BY id_editorial) AS MyRowNumber, id_libro,titulo,ano,precio, id_editorial\r\n" + 
				"FROM Libro) tbl\r\n" + 
				"WHERE MyRowNumber BETWEEN "+ valorInicial+ "AND" + valorFinal;
		return jdbcTemplate.query(sqlSelect, new LibroExtractor());
	}
	

}
