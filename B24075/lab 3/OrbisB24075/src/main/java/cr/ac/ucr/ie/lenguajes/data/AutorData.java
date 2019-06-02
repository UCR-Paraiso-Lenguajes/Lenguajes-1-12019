package cr.ac.ucr.ie.lenguajes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cr.ac.ucr.ie.lenguajes.domain.Autor;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public List<Autor> ListarAutores(int inicio, int _final) {
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor " + " FROM Autor a"
				+ " WHERE id_autor BETWEEN " + inicio + " AND " + _final;
		return jdbcTemplate.query(sqlSelect, new AutoresEstractor());
	}// findMoviesByTitleAndGenre

	class AutoresEstractor implements ResultSetExtractor<List<Autor>> {

		@Override
		public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {

			Map<Integer, Autor> map = new HashMap<Integer, Autor>();
			Autor autor = null;

			while (rs.next()) {

				Integer id = rs.getInt("id_autor");
				autor = map.get(id);

				if (autor == null) {

					autor = new Autor();
					autor.setIdAutor(rs.getInt("id_autor"));
					autor.setNombre(rs.getString("nombre_autor"));
					autor.setApellidos(rs.getString("apellidos_autor"));
					map.put(id, autor);

				} // if
			} // while
			return new ArrayList<Autor>(map.values());
		}// extractData

	}

	public List<Autor> buscarAutoresApellidos(String apellidos) {
		List<Autor> autores = new ArrayList<>();

		String selectSql = "exec buscarAutores @apellido='" + apellidos + "';";

		jdbcTemplate.query(selectSql, new Object[] {}, (rs, row) -> new Autor(rs.getString("nombre_autor"),
				rs.getString("apellidos_autor"), rs.getInt("id_autor"))).forEach(entry -> autores.add(entry));

		return autores;

	}

	public Autor findAutorById(int codAutor) {
		String sqlSelect = "SELECT a.id_autor,a.nombre_autor,apellidos_autor from Autor a where a.id_autor=" + codAutor;

		List<Autor> autores = jdbcTemplate.query(sqlSelect, new AutoresEstractor());

		if (autores.size() == 0) {
			return null;
		} else {
			return autores.get(0);
		}
	}

	public void remove(int codAutor) throws SQLException {

		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlDeleteLibroAutor = "DELETE FROM Libro_Autor " + "WHERE id_autor = ?";
			String sqlDeletePelicula = "DELETE FROM Autor " + "WHERE id_autor = ?";
			PreparedStatement statementLibroAutor = conexion.prepareStatement(sqlDeleteLibroAutor);
			statementLibroAutor.setInt(1, codAutor);
			statementLibroAutor.executeUpdate();

			PreparedStatement statementAutor = conexion.prepareStatement(sqlDeletePelicula);
			statementAutor.setInt(1, codAutor);
			statementAutor.executeUpdate();
			conexion.commit();

		} catch (SQLException e) {
			conexion.rollback();
			throw e;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}

	}

	public void update(int id, String nombre, String apellido) throws SQLException {

		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlUpdateAutor = "update Autor set nombre_autor=?,apellidos_autor=? WHERE id_autor = ?";
			PreparedStatement statementUpdateAutor = conexion.prepareStatement(sqlUpdateAutor);
			statementUpdateAutor.setString(1, nombre);
			statementUpdateAutor.setString(2, apellido);
			statementUpdateAutor.setInt(3, id);
			statementUpdateAutor.executeUpdate();

			conexion.commit();

		} catch (SQLException e) {
			conexion.rollback();
			throw e;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}

	}

}
