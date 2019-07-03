package com.videoparaiso.renting.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.videoparaiso.renting.domain.Genero;

@Repository
public class GeneroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Genero> findAllGenres() {
		List<Genero> generos = new ArrayList<>();
		String selectSql = "SELECT cod_genero, nombre_genero " + "FROM Genero g order by cod_genero ASC";
		jdbcTemplate
				.query(selectSql, new Object[] {},
				(rs, row) -> new Genero(rs.getInt("cod_genero"), rs.getString("nombre_genero")))
				.forEach(entry -> generos.add(entry));
		return generos;
	}
}