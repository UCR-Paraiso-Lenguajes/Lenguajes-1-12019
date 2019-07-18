package com.orbis.B77436.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.B77436.domain.Editorial;


@Repository
public class EditorialData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
				.withCatalogName("dbo")
				.withProcedureName("Orbis_Editorial");
	}
	
	@Transactional(readOnly=true)
	public Iterator<Editorial> findEditorial() throws SQLException {

		String sqlSelect = "SELECT id_editorial,nombre,direccion,telefono"
				+ " FROM Editorial  ";
		return jdbcTemplate.query(sqlSelect, new EditorialWithExtractor());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Editorial> buscarPorId(int id_editorial) {
		
		String sqlSelect = "SELECT e.id_editorial,e.nombre,e.direccion,e.telefono"
				+ " FROM Editorial e "
				+ " WHERE e.id_editorial="+id_editorial;
		return jdbcTemplate.query(sqlSelect, new EditorialWithExtractor());
	}
	
	@Transactional(readOnly=true)
	public Iterator<Editorial> buscarPorExtracto(int rango1, int rango2) {
		
		String sqlSelect = "SELECT id_editorial,  nombre,  direccion,  telefono FROM " + 
				"  (SELECT ROW_NUMBER() OVER (ORDER BY id_editorial) AS MiRegistro, id_editorial,  nombre,  direccion,  telefono " + 
				"  FROM Editorial) tbl" + 
				" WHERE MiRegistro BETWEEN "+rango1+" AND "+rango2;
		return jdbcTemplate.query(sqlSelect, new EditorialWithExtractor());
	}
}

class EditorialWithExtractor implements ResultSetExtractor<Iterator<Editorial>> {
	@Override
	public Iterator<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) { 
				editorial = new Editorial();
				editorial.setId_editorial(id);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				
				map.put(id, editorial);
			} 
			 
		}
		
		return map.values().iterator();
	} 
}

