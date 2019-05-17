package com.videocartago.renting.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.videocartago.renting.domain.EnumGenero;
import com.videocartago.renting.domain.Genero;

@Repository
public class GeneroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Genero> findAllGenres(int inicio, int fin){
		List<Genero> generos = new ArrayList<>();
		String selectSql = "SELECT cod_genero, nombre_genero "
				+ "FROM Genero g "
				+ "WHERE cod_genero > ? AND cod_genero < ? "
				+ "order by cod_genero ASC";
		jdbcTemplate.query(selectSql, new Object[] {inicio, fin}, (rs, row) -> new Genero(rs.getInt("cod_genero"),
				rs.getString("nombre_genero"),EnumGenero.SIN_DEFINIR))
		.forEach(entry -> generos.add(entry));
		return generos;
		
	}

}
