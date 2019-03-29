package com.orbis.B52265.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B52265.domain.Editorial;
import com.orbis.B52265.domain.Libro;

@Repository
public class EditorialDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Editorial> getEditoriales(int numero, int next) {
		String sqlSelect = "select e.id_editorial, e.nombre,e.direccion,e.telefono\r\n" + 
				"from editorial e\r\n"
				+ "where e.id_editorial between " + numero + " and " + next;
		System.out.println(numero + "numero" + next);
		return jdbcTemplate.query(sqlSelect, new EditorialWithLibrosExtractor());
	}

	/*
	 * @Transactional(readOnly = true) public List<Pelicula> peliculas() { String
	 * sqlSelect = "SELECT * FROM Pelicula"; return jdbcTemplate.query(sqlSelect,
	 * new PeliculasWithActoresExtractor()); }
	 */

	class EditorialWithLibrosExtractor implements ResultSetExtractor<List<Editorial>> {

		@Override
		public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
			Editorial editorial = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_editorial");
				editorial = map.get(id);
				if (editorial == null) {
					editorial = new Editorial();
					editorial.setIdEditorial(id);
					editorial.setNombre(rs.getString("nombre"));
					editorial.setDireccion(rs.getString("direccion"));
					editorial.setTelefono(rs.getString("telefono"));

					map.put(id, editorial);

				}

			}
			return new ArrayList<Editorial>(map.values());
		}

	}
}
