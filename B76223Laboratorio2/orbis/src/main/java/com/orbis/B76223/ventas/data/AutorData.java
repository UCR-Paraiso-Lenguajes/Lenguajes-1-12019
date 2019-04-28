package com.orbis.B76223.ventas.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orbis.B76223.ventas.domain.Autor;


@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	
public List<Autor> findAllAutores(int inicio, int fin)  {
		
		List<Autor> autores = new ArrayList<>();
		String selectSql = 
				"SELECT id_autor, nombre_autor, apellidos_autor FROM Autor a WHERE id_autor > ? AND  id_autor < ? order by id_autor ASC";
					jdbcTemplate.query(
							selectSql,
							new Object[] {inicio,fin},
							(rs,row)->	new Autor(rs.getInt("id_autor"),
											rs.getString("nombre_autor"), 
											rs.getString("apellidos_autor"))
							)
							.forEach(entry -> autores.add(entry)
					);
		
		return autores;
	}
}
