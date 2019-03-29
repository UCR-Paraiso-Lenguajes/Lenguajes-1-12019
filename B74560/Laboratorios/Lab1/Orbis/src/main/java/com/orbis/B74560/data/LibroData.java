package com.orbis.B74560.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.orbis.B74560.domain.Libro;
import java.util.Iterator;


@Repository
public class LibroData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Libro>  buscarPorEditorial(int id_editorial) {
		
		String sqlSelect = "SELECT i.id_libro,i.titulo,i.ano,i.precio,i.id_editorial"
				+ " FROM Libro i "
				+ " WHERE id_editorial ="+id_editorial;
		
		return jdbcTemplate.query(sqlSelect, new bucarPorEditorialExtractor ());
	}//  searchPorEditorial 
}
class bucarPorEditorialExtractor implements ResultSetExtractor<Iterator<Libro>> {
	@Override
	public Iterator<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		  
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		
		while (rs.next()) {
			
			//variables para inicializar
			Integer id_editorialLibro = rs.getInt("id_editorial");
			libro = map.get(id_editorialLibro);
			
			Integer idLibro = rs.getInt("id_libro");
			libro = map.get(idLibro);
			
			short anoLibro = rs.getShort("ano");
			libro = map.get(anoLibro);
			
			float precioLibro = rs.getFloat("precio");
			libro = map.get(precioLibro);
			
			
			if (libro == null) { 
				
				libro = new Libro();
				libro.setId_editorial(id_editorialLibro);
				libro.setId_libro(idLibro);
				libro.setAno(anoLibro);
				libro.setPrecio(precioLibro);
				libro.setTitulo(rs.getString("titulo"));
				
				
				map.put(id_editorialLibro, libro);
				
			} // if
			
		} // while
		
		return map.values().iterator();
		
	} // extractData
	
	
}