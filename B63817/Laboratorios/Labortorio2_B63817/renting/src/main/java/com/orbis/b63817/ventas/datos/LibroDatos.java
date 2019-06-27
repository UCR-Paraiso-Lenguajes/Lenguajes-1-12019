package com.orbis.b63817.ventas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63817.ventas.domain.form.LibroForm;
import com.orbis.b63817.ventas.dominio.Autor;
import com.orbis.b63817.ventas.dominio.Libro;
import com.orbis.b63817.ventas.dominio.Libro;

@Repository
public class LibroDatos {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public Iterator<Libro> mostrarLibros(int id_Editorial) {
		String sqlSelect = "Select id_libro,titulo,ano,precio,id_editorial " + "From Libro " + "Where id_editorial ="
				+ id_Editorial;
		return jdbcTemplate.query(sqlSelect, new LibrosPorEditorialExtractor());
	}// findMoviesByTitleAndGenre

	@Transactional(readOnly = true)
	public int insertarLibro(LibroForm libroForm) throws SQLException {
		System.out.println(libroForm.toString() + "---");
		int id_Libro=0;
		String queryInsertarLibro = "Insert INTO Libro(titulo,ano,precio,id_editorial,isbn) values (?,?,?,?,?)";
		this.dataSource = dataSource;
		Connection conexion = dataSource.getConnection();

		conexion.setAutoCommit(false);

		try {
			PreparedStatement prest = conexion.prepareStatement(queryInsertarLibro, Statement.RETURN_GENERATED_KEYS);
			prest.setString(1, libroForm.getTitulo());
			prest.setInt(2, libroForm.getAno());
			prest.setFloat(3, libroForm.getPrecio());
			prest.setInt(4, libroForm.getId_Editorial());
			prest.setInt(5, libroForm.getIsbn());

			prest.executeUpdate();
			conexion.commit();

			ResultSet rs = prest.getGeneratedKeys();
			if (rs.next()) {
				id_Libro = rs.getInt(1);
				insertarAutorLibro(id_Libro, libroForm);

			}
		} catch (SQLException e) {

			conexion.rollback();
			throw e;
		} finally {
			if (conexion != null)
				conexion.close();

		}
		return id_Libro;

	}

	@Transactional(readOnly = true)
	public void insertarAutorLibro(int id_libro, LibroForm libroForm) throws SQLException {
		System.out.println(libroForm.toString() + "---");
		String insertarAutorLibro = "INSERT INTO LIBRO_AUTOR(id_libro,id_autor) VALUES (?,?)";
		Connection conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);

		try {
			PreparedStatement prest = conexion.prepareStatement(insertarAutorLibro, Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < libroForm.getListaAutoresDelLibro().size(); i++) {
				int id_autor = Integer.parseInt(libroForm.getListaAutoresDelLibro().get(i).toString());
				prest.setInt(1, id_libro);
				prest.setInt(2, id_autor);

				prest.addBatch();
			}
			prest.executeBatch();
			conexion.commit();

		} catch (SQLException e) {

			conexion.rollback();
			throw e;
		} finally {
			if (conexion != null)
				conexion.close();

		}

	}

}

class LibrosPorEditorialExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) { // new Libro record
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo(rs.getString("titulo"));
				libro.setAno(rs.getInt("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				libro.setId_editorial(rs.getInt("id_editorial"));
				map.put(id, libro);
			} // if

		} // while
		return new ArrayList<Libro>(map.values()).iterator();
	} // extractData
}
