package com.orbis.b63685.Laboratorio2Orbis.data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63685.Laboratorio2Orbis.domain.Editorial;
import com.orbis.b63685.Laboratorio2Orbis.domain.Libro;

@Repository
public class EditorialDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Editorial> buscarEditoriales(){
		
		String sqlSelect="select id_editorial,nombre,direccion,telefono from Editorial" + 
				" order by id_editorial";
		return jdbcTemplate.query(sqlSelect, new EditorialesWithIdExtractor());
	}
	
	
}

class EditorialesWithIdExtractor implements ResultSetExtractor<List<Editorial>>{

	@Override
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Editorial> list = new LinkedList<>();
		Editorial editorial = null;
		while(rs.next()) {
			Integer idEditorialActual = rs.getInt("id_editorial");
				editorial = new Editorial();
				editorial.setIdEditorial(idEditorialActual);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				list.add(editorial);
			}
		
		
		return list;
	}
}
