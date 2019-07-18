package com.orbis3.b53953.data;

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

import com.orbis3.b53953.domain.Editorial;


@Repository
public class EditorialData {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Editorial> buscarEditoriales() {
		String sqlSelect = "SELECT e.id_editorial, e.nombre, e.direccion, e.telefono FROM Editorial e";
		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
}

class EditorialExtractor implements ResultSetExtractor<List<Editorial>> {

	@Override
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) {
				editorial = new Editorial();
				editorial.setId(id);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				map.put(id, editorial);
			}
		}
		return new ArrayList<Editorial>(map.values());
	}
}
