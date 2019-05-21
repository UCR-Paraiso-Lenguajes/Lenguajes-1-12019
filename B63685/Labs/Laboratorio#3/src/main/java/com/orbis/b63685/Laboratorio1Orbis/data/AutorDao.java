package com.orbis.b63685.Laboratorio1Orbis.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63685.Laboratorio1Orbis.data.LibroDao.LibrosEditorialExtractor;
import com.orbis.b63685.Laboratorio1Orbis.domain.*;

@Repository
public class AutorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public List<Autor> buscarAutores() {

		String sqlSelect = "select id_autor,nombre_autor,apellidos_autor from autor" + " order by id_autor";
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public List<Autor> findAuthorById(int idAutor) {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor from autor WHERE id_autor="+idAutor;
		
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());

	}

	@Transactional(readOnly = true)
	public List<Autor> findAuthorByLastName(String lastName) {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor from autor WHERE apellidos_autor like '%"+lastName+"%' ";

		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());

	}

	@Transactional(readOnly = true)
	public List<Autor> listAuthors() {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor" + " from autor";

		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());

	}

	public void delete(int autorId) {
		
		String sqlDeleteAutor = "DELETE from Libro_Autor where id_autor = "+ autorId;
		String sqlDelete = "DELETE from Autor where id_autor = "+ autorId;
		jdbcTemplate.batchUpdate(sqlDeleteAutor);
		jdbcTemplate.batchUpdate(sqlDelete);


	}

	
	public void cDelete(int autorId) {

		String sqlDeleteAutor = "DELETE from Autor where id_autor = "+ autorId;
		jdbcTemplate.batchUpdate(sqlDeleteAutor);

	}

	public void update(int id, Autor autor) {
		String sqlUpdateName = "UPDATE Autor SET nombre_autor = '" + autor.getNombreAutor() + "' where id_autor = "
				+ id;
		jdbcTemplate.batchUpdate(sqlUpdateName);

		String sqlUpdateLastName = "UPDATE Autor SET apellidos_autor = '" + autor.getApellidosAutor()
				+ "' where id_autor = " + id;
		jdbcTemplate.batchUpdate(sqlUpdateLastName);

	}
}

class autoresWithIdExtractor implements ResultSetExtractor<List<Autor>> {

	@Override
	public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Autor> list = new LinkedList<>();
		Autor autor = null;
		while (rs.next()) {
			Integer idautorActual = rs.getInt("id_autor");
			autor = new Autor();
			autor.setIdAutor(idautorActual);
			autor.setNombreAutor(rs.getString("nombre_autor"));
			autor.setApellidosAutor(rs.getString("apellidos_autor"));
			list.add(autor);
		}
		return list;
	}

}
