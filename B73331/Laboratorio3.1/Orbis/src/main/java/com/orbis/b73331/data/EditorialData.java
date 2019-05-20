package com.orbis.b73331.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b73331.domain.Editorial;


@Repository
public class EditorialData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Editorial>  buscarPorRango(int desde, int hasta) {
		String sqlSelect = "SELECT id_editorial,  nombre,  direccion,  telefono FROM"
				+ " (SELECT ROW_NUMBER() OVER (ORDER BY id_editorial) AS MyRowNumber, id_editorial,  nombre,  direccion,  telefono "
				+ "FROM Editorial) tbl "
				+ "WHERE MyRowNumber BETWEEN "+desde+" AND "+hasta ;
		return jdbcTemplate.query(sqlSelect, new buscarEditorialRango());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Editorial>  buscarPorId(int idEditorial) {
		String sqlSelect = "SELECT e.id_editorial,e.nombre,e.direccion,e.telefono"
				+ " FROM Editorial e "
				+ " WHERE id_editorial ="+idEditorial;
		return jdbcTemplate.query(sqlSelect, new buscarEditorialRango());
	}//  searchPorEditorial 
}

class buscarEditorialRango implements ResultSetExtractor<Iterator<Editorial>> {
	@Override
	public Iterator<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) { // new editorial record
				editorial = new Editorial();
				editorial.setId_editorial(id);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				map.put(id, editorial);
			} // if
			
		} // while
		return map.values().iterator();
	} // extractData
	
	
}
