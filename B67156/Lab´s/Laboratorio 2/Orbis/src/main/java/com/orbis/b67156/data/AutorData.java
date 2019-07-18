package com.orbis.b67156.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b67156.domain.Autor;


@Repository
public class AutorData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Autor>  buscarPoridAutor(int idAutor) {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor,a.apellidos_autor"
				+ " FROM Autor a "
				+ " WHERE id_autor ="+idAutor;
		return jdbcTemplate.query(sqlSelect, new AutorExtractor());
	}
	
	@Transactional(readOnly=true)
	public List<Autor> buscarPorBloque(int inicio, int fin){
		List<Autor> autores = new ArrayList<>();
		String selectSql = "SELECT id_autor, nombre_autor, apellidos_autor "
				+ "FROM Autor "
				+ "WHERE id_autor > ? AND id_autor < ? "
				+ "order by id_autor ASC";
		jdbcTemplate.query(selectSql, new Object[] {inicio, fin}, (rs, row) -> new Autor(rs.getInt("id_autor"),
				rs.getString("nombre_autor"),rs.getString("apellidos_autor")))
		.forEach(entry -> autores.add(entry));
		return autores;
		
	}

}
