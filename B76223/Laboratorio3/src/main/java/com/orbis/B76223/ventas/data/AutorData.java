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

public void updateAutores(int idAutor, Autor autor) {

	String sqlSelect = 
			"UPDATE Autor SET nombre_autor = '" + autor.getNombreAutor()+ "',"
			+ " apellidos_autor = '" + autor.getApellidosAutor()+ "' "
			+ "WHERE id_autor = " + autor.getIdAutor();
	
	jdbcTemplate.batchUpdate(sqlSelect);

}

public List<Autor> findAutoresByLastName (String lastName) {

	List<Autor> autores = new ArrayList<>();
	String selectSql = 
			"SELECT id_autor, nombre_autor, apellidos_autor FROM Autor WHERE apellidos_autor = ?";
				jdbcTemplate.query(
						selectSql,
						new Object[] {lastName},
						(rs,row)->	new Autor(rs.getInt("id_autor"),
										rs.getString("nombre_autor"), 
										rs.getString("apellidos_autor"))
						)
						.forEach(entry -> autores.add(entry)
				);
	
	return autores;

}

public void deleteAutor (int idAutor) {
	
	String sqlDeleteLibro_Autor = "Delete LIBRO_AUTOR where id_autor = " + idAutor;
	String sqlDeleteAutor = "Delete Autor where id_autor = " + idAutor;
	
	jdbcTemplate.execute(sqlDeleteLibro_Autor);
	jdbcTemplate.execute(sqlDeleteAutor);

}


public List<Autor> findAutoresById(int idAutor) {
	List<Autor> autores = new ArrayList<>();
	String selectSql = 
			"SELECT id_autor, nombre_autor, apellidos_autor FROM Autor WHERE id_autor = ? ";
				jdbcTemplate.query(
						selectSql,
						new Object[] {idAutor},
						(rs,row)->	new Autor(rs.getInt("id_autor"),
										rs.getString("nombre_autor"), 
										rs.getString("apellidos_autor"))
						)
						.forEach(entry -> autores.add(entry)
				);
	
	return autores;
}

}
