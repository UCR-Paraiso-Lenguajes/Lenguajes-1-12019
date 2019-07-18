package com.orbis.b73331.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b73331.domain.Autor;

@Repository
public class AutorData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Autor> encuentraAutores(int inicio, int fin) {
		List<Autor> autores = new ArrayList<>();
		String selectSql = "SELECT id_autor, nombre_autor, apellidos_autor " + "FROM Autor "
				+ "WHERE id_autor > ? AND id_autor < ? " + "order by id_autor ASC";
		jdbcTemplate
				.query(selectSql, new Object[] { inicio, fin }, (rs, row) -> new Autor(rs.getInt("id_autor"),
						rs.getString("nombre_autor"), rs.getString("apellidos_autor")))
				.forEach(entry -> autores.add(entry));
		return autores;

	}

	public Autor encuentraAutor(int id) {
		List<Autor> autores = new ArrayList<>();
		String selectSql = "SELECT id_autor, nombre_autor, apellidos_autor " + "FROM Autor " + "WHERE id_autor = ?";
		jdbcTemplate
				.query(selectSql, new Object[] { id }, (rs, row) -> new Autor(rs.getInt("id_autor"),
						rs.getString("nombre_autor"), rs.getString("apellidos_autor")))
				.forEach(entry -> autores.add(entry));
		return autores.get(0);

	}

	@Transactional(readOnly = true)
	public Iterator<Autor> buscarAutoresPorApellidos(String apellidosAutor) {

		String sqlSelect = "SELECT id_autor,nombre_autor,apellidos_autor" + " FROM Autor WHERE apellidos_autor like '%"
				+ apellidosAutor + "%'";
		return jdbcTemplate.query(sqlSelect, new ActorInfo());
	}

	public void update(int id, Autor autor) {
		String sqlSelect = "UPDATE Autor set nombre_autor = '" + autor.getNombre_autor() + "'," + " apellidos_autor = '"
				+ autor.getApellidos_autor() + "' where id_autor = " + id;
		jdbcTemplate.batchUpdate(sqlSelect);
	}
	@Transactional
	public void delete(int id) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			String sqlSelect = "Delete from Libro_Autor where id_autor = "+id;
			jdbcTemplate.batchUpdate(sqlSelect);
			/*
			if(true) {
				throw new SQLException();
			}
			*/
			sqlSelect = "Delete from Autor where id_autor = "+id;
			jdbcTemplate.batchUpdate(sqlSelect);
			
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}

class ActorInfo implements ResultSetExtractor<Iterator<Autor>> {
	@Override
	public Iterator<Autor> extractData(ResultSet rs) {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();

		Autor autor = null;
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_autor");
				autor = map.get(id);
				if (autor == null) {
					autor = new Autor();
					autor.setId_autor(id);
					autor.setNombre_autor(rs.getString("nombre_autor"));
					autor.setApellidos_autor(rs.getString("apellidos_autor"));

					map.put(id, autor);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map.values().iterator();
	}
}