package com.orbis.b32915.ventas.data;

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

import com.orbis.b32915.ventas.domain.Editorial;

@Repository
public class EditorialData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly = true)
	public Iterator<Editorial> findEditorialByRange(int primerEditorial, int ultimaEditorial) {
		String sqlSelect = "Select id_editorial,nombre,direccion,telefono " 
	            +" from Editorial "
				+" where id_editorial between "+primerEditorial+" and "+ultimaEditorial;

		return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}
	

	}

class EditorialExtractor implements ResultSetExtractor<Iterator<Editorial>> {
	@Override
	public Iterator<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
				editorial.setTelefono(rs.getString("telefono"));;
				map.put(id, editorial);
			}
			
		}
		return new ArrayList<Editorial>(map.values()).iterator();
	}
}
