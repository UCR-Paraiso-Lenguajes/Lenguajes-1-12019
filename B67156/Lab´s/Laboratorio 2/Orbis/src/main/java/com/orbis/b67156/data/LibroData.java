package com.orbis.b67156.data;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b67156.domain.Libro;
import com.orbis.b67156.domain.Libro_Autor;

@Repository
public class LibroData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
//	private DataSource dataSource;
	
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
	
	
	@Transactional
	public void save(Libro libro, Libro_Autor libroAutor){
		String sqlInsertLibro = "Insert into Libro VALUES "
				+ "( " +libro.getId()+ ", " 
				+ "'"+libro.getTitulo()+ "', " 
				+ libro.getAno()+", " 
				+ libro.getPrecio()
				+", "+libro.getId()+")";
		
		jdbcTemplate.batchUpdate(sqlInsertLibro);
		String sqlInsertLibroAutor = "";
		
		for(int i=0; i < libroAutor.getListAutores().size(); i++) {
			sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES ("+ libroAutor.getId_libro() + ", " +libroAutor.getListAutores().get(i)+")";
			jdbcTemplate.batchUpdate(sqlInsertLibroAutor);
			
		}
	}
	
}
