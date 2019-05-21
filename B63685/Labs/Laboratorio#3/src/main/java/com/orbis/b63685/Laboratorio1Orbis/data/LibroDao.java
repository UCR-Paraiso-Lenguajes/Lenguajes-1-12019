package com.orbis.b63685.Laboratorio1Orbis.data;

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

import com.orbis.b63685.Laboratorio1Orbis.domain.Editorial;
import com.orbis.b63685.Laboratorio1Orbis.domain.Libro;

@Repository
public class LibroDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	@Autowired
	public  void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.simpleJdbcCall=new	SimpleJdbcCall(dataSource);

	}
	@Transactional(readOnly=true)
	public List<Libro> buscaLibros(int idEditorial) {
		String sqlSelect = "SELECT l.id_libro,l.titulo,l.año,l.precio"
				+ " from libro l, Editorial e where l.id_editorial = "
		          + idEditorial+ " and e.id_editorial= "+ idEditorial;
		
		return jdbcTemplate.query(sqlSelect, new LibrosEditorialExtractor());
	}// BuscaLibros por editorial
	
	
	class LibrosEditorialExtractor implements ResultSetExtractor<List<Libro>> {
		//extrae los datos de la base
		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_libro");
				libro = map.get(id);
				if (libro == null) { 
					libro = new Libro();
					libro.setIdLibro(id);
					libro.setAno(rs.getShort("año"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setPrecio(rs.getFloat("precio"));
					map.put(id, libro);
				} // if
				// TODO Auto-generated method stub
			} // while
			return new ArrayList<Libro>(map.values());
		} // extractData
	}


	@Transactional
	  public Libro save(Libro libro) throws SQLException {
	   SqlParameterSource parameterSource = new MapSqlParameterSource()
	     .addValue("@id_libro", libro.getIdLibro())
	     .addValue("@titulo", libro.getTitulo())
	     .addValue("@año", libro.getAno())
	     .addValue("@precio", libro.getPrecio())
	     .addValue("@id_editorial", libro.getEditorial().getIdEditorial());
	   Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
	   return libro;
	   
	  }
	
	
	
}
