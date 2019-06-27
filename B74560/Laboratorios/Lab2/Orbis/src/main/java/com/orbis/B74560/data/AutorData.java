package com.orbis.B74560.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.orbis.B74560.domain.Autor;

@Repository
public class AutorData {

	@Autowired // Inicializa
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}// fin de setDataSource

	public List<Autor> buscarAutor(int rangoInicio, int rangoFinal) {

		List<Autor> listaAutores = new ArrayList<>();
		String selectSql = "SELECT id_autor, nombre_autor, apellidos_autor " + "FROM Autor "
				+ "WHERE id_autor > ? AND id_autor < ? " + "ORDER BY id_autor ASC";

		jdbcTemplate.query(selectSql, new Object[] { rangoInicio, rangoFinal }, (rs,
				row) -> new Autor(rs.getInt("id_autor"), rs.getString("nombre_autor"), rs.getString("apellidos_autor")))
				.forEach(entry -> listaAutores.add(entry));

		return listaAutores;

	}// fin de buscarAutor

}// fin de AutorData
