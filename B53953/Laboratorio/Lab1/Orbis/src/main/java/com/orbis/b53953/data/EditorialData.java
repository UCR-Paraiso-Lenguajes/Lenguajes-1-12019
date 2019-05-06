package com.orbis.b53953.data;
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

import com.orbis.b53953.domain.Editorial;


@Repository
public class EditorialData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	
	public List<Editorial> encontrarEditoriales(int cod) {
		String sqlSelect = "SELECT "
				+ "e.id_editorial,e.nombre,e.dirreccion, e.telefono"
				+ " FROM Editorial e"
				+ " WHERE e.id_editorial = " +cod;
		return jdbcTemplate.query(sqlSelect, new ListaEditoriales());
	}
}

class ListaEditoriales implements ResultSetExtractor<List<Editorial>> {
	@Override
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) { // new editorial record
				editorial = new Editorial();
				editorial.setIdEditorial(id);
				editorial.setNombre(rs.getString("Nombre"));
				editorial.setDireccion(rs.getString("Direccion"));
				editorial.setTelefono(rs.getString("Telefono"));
				map.put(id, editorial);
			} 
		} // while
		return new ArrayList<Editorial>(map.values());
	} // extractData
}