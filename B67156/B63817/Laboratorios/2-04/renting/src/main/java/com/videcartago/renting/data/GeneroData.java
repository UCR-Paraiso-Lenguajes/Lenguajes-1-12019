package com.videcartago.renting.data;



import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.videcartago.renting.domain.Genero;



@Repository
public class GeneroData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Genero> findAllGenres(int inicioRegistros, int finRegistros){
		List<Genero> generos = new ArrayList<>();
		String selectSql = "SELECT cod_genero, nombre_genero "
				+ "FROM Genero g "
				+ "WHERE cod_genero > ? AND cod_genero < ? "
				+ "ORDER BY cod_genero ASC";
		
		jdbcTemplate.query(selectSql, new Object[] {inicioRegistros, finRegistros}, (rs, row) -> new Genero(rs.getInt("cod_genero"), rs.getString("nombre_genero")))
		.forEach(entry -> generos.add(entry));
		return generos;
	}


	


}