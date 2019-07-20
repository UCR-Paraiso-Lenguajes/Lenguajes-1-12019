package com.orbis.b40894.ventas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.orbis.b40894.ventas.domain.Editorial;

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
	
	@Transactional(readOnly=true)
	public Iterator<Editorial> findEditorial(int cantidadInicio, int cantidadFinal) {
		String sqlSelect = "SELECT DISTINCT table_editorial.id_editorial, table_editorial.nombre, table_editorial.direccion, table_editorial.telefono\r\n" + 
				"FROM (SELECT ROW_NUMBER() OVER (ORDER BY e.id_Editorial) AS row_number,  \r\n" + 
				"e.id_editorial, e.nombre, e.direccion, e.telefono \r\n" + 
				"FROM Editorial e) as table_editorial\r\n" + 
				"WHERE row_number BETWEEN "+cantidadInicio+" AND "+cantidadFinal;
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