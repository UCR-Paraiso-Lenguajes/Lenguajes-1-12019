package cr.ac.ucr.ie.lenguajes.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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


import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Libro> ListarLibros(int inicio,int _final){
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio, l.id_editorial "
				+ " FROM Libro l"
				+ " WHERE consecutivo BETWEEN "+inicio+" AND "+_final;
		return jdbcTemplate.query(sqlSelect, new LibrosEstractor());
	}//findMoviesByTitleAndGenre

	
	class LibrosEstractor implements ResultSetExtractor<List<Libro>>{

		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id_libro");
				libro = map.get(id);
				
				if(libro == null) {
					
					libro = new	Libro();
					libro.setId_libro(rs.getInt("id_libro"));
					libro.setNombre_libro(rs.getString("titulo"));
					libro.setAno(rs.getShort("ano"));
					libro.setPrecio(rs.getFloat("precio"));
					map.put(id, libro);
					
				}//if
			}//while
			return new ArrayList<Libro>(map.values());
		}//extractData
	}
}
