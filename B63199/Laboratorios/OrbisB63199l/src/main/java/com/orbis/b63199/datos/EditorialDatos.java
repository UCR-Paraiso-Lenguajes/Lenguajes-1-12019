package com.orbis.b63199.datos;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63199.dominio.Editorial;

@Repository
public class EditorialDatos {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Editorial editorial;
	
	@Transactional(readOnly=true)
	public List<Editorial> listarEditoriales(int inicial, int ultima){
		String sqlSelect = 
				"select * from Editorial";
				/*"Select e.id_editorial, e.nombre, e.direcion, e.telefono "
				+ "from Editorial e "
				+ "where e.id_editorial between "+inicial+" and "+ultima*/
		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
}

class EditorialExtractor implements ResultSetExtractor<List<Editorial>> {
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) {
				editorial = new Editorial();
				editorial.setId_editorial(id);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDirecion(rs.getString("direcion"));
				editorial.setTelefono(rs.getString("telefono"));
				map.put(id, editorial);
			} 

		} // while
		return new ArrayList<Editorial>(map.values());
	} // extractData
	
}
