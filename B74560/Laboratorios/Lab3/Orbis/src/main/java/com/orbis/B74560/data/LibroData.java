package com.orbis.B74560.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.orbis.B74560.domain.Libro;
import com.orbis.B74560.domain.LibroAutor;
import com.orbis.B74560.exception.ExceptionsOrbis;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public Iterator<Libro> buscarPorEditorial(int idEditorial) {

		String sqlSelect = "SELECT id_libro, titulo, ano, precio, id_editorial " + "FROM Libro "
				+ "WHERE id_editorial = " + idEditorial;

		return jdbcTemplate.query(sqlSelect, new buscarLibroEditorial());

	}// fin del buscarPorEditorial

	@Transactional
	public void guardarLibro(Libro libro, LibroAutor libroAutor) {

		Connection connection = null;

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			String sqlInsertLibro = "Insert into Libro VALUES " + "( " + libro.getId_libro() + ", " + "'"
					+ libro.getTitulo() + "', " + libro.getAno() + ", " + libro.getPrecio() + ", "
					+ libro.getId_editorial() + ")";

			jdbcTemplate.batchUpdate(sqlInsertLibro);
			String sqlInsertLibroAutor = "";

			for (int i = 0; i < libroAutor.getAutores().size(); i++) {
				sqlInsertLibroAutor = "Insert into LIBRO_AUTOR VALUES (" + libroAutor.getId_libro() + ", "
						+ libroAutor.getAutores().get(i) + ")";
				jdbcTemplate.batchUpdate(sqlInsertLibroAutor);
			} // fin del for

			connection.commit();

		} catch (Exception e) {

			try {
				connection.rollback();
			} catch (SQLException eSQL) {
				throw new ExceptionsOrbis("Error de SQL " + eSQL.getMessage());
			} // fin del try-catch

			throw new ExceptionsOrbis("Error de conexion" + e.getMessage());

		} finally {

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					new ExceptionsOrbis("Error de SQL " + e.getMessage());
				} // fin del try-catch

			} // fin del if

		} // fin del try-catch-finally

	}// fin del guardarLibro

}// fin del LibroData

class buscarLibroEditorial implements ResultSetExtractor<Iterator<Libro>> {

	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {

			Integer id = rs.getInt("id_libro");
			libro = map.get(id);

			if (libro == null) {
				libro = new Libro();
				libro.setId_libro(id);
				libro.setTitulo((rs.getString("titulo")));
				libro.setAno(rs.getShort("ano"));
				libro.setPrecio(rs.getFloat("precio"));
				map.put(id, libro);
			} // fin del if

		} // fin del while

		return map.values().iterator();

	} // fin del extractData

} // fin del buscarLibroEditorial
