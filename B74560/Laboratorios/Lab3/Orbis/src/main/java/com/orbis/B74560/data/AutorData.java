package com.orbis.B74560.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.orbis.B74560.domain.Autor;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional(readOnly = true)
	public List<Autor> buscarAutores(int inicio, int fin) {
		List<Autor> autores = new ArrayList<>();
		String selectSql = "SELECT id_autor, nombre_autor, apellidos_autor " + "FROM Autor "
				+ "WHERE id_autor > ? AND id_autor < ? " + "order by id_autor ASC";
		jdbcTemplate
				.query(selectSql, new Object[] { inicio, fin }, (rs, row) -> new Autor(rs.getInt("id_autor"),
						rs.getString("nombre_autor"), rs.getString("apellidos_autor")))
				.forEach(entry -> autores.add(entry));
		return autores;

	}

	@Transactional(readOnly = true)
	public Iterator<Autor> searchPorAutorApellido(String apellidos_autor) {
		String sqlSelect = "SELECT id_autor, nombre_autor, apellidos_autor" + " FROM Autor "
				+ " WHERE apellidos_autor like '%" + apellidos_autor + "%'";
		return jdbcTemplate.query(sqlSelect, new buscarAutor());

	}

	@Transactional(readOnly = true)
	public Iterator<Autor> buscarAutorId(int id) {
		String sqlSelect = "SELECT id_autor, nombre_autor, apellidos_autor" + " FROM Autor " + " WHERE id_autor = "
				+ id;
		return jdbcTemplate.query(sqlSelect, new buscarAutor());

	}

	class buscarAutor implements ResultSetExtractor<Iterator<Autor>> {
		@Override
		public Iterator<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {

			Map<Integer, Autor> map = new HashMap<Integer, Autor>();
			Autor autor = null;
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

			return map.values().iterator();
		} // extractData

	}
	
	@Transactional(readOnly = true)
	public void actualizarAutor(int idAutor, Autor autor) {

		String sqlSelect = "UPDATE Autor SET nombre_autor = '" + autor.getNombre_autor() + "', apellidos_autor= '"
				+ autor.getApellidos_autor() + "' WHERE id_autor = '" + idAutor +"'";

		jdbcTemplate.batchUpdate(sqlSelect);
	}

	/*@Transactional(readOnly = true)
	public void borrarAutor(int idAutor) {

		String sqlBorrar = "Delete Autor WHERE id_autor = ?";

		jdbcTemplate.update(sqlBorrar, new Object[] { idAutor });
	}*/
	
	@Transactional(readOnly=true)
	 public void borrarAutor (int idAutor) {
	  String sqlBorrar = "Delete Autor WHERE id_autor = ? "
	    + "COMMIT TRANSACTION"; 
	  borrarLibro_Autor(idAutor);
	  jdbcTemplate.update(sqlBorrar, new Object[] {idAutor});
	 }
	 
	 @Transactional(readOnly=true)
	 private void borrarLibro_Autor (int idAutor) {
	  String sqlBorrarLibro = "Delete Libro_Autor WHERE id_autor = ? "
	    + "COMMIT TRANSACTION";
	  jdbcTemplate.update(sqlBorrarLibro, new Object[] {idAutor});
	 }

}
