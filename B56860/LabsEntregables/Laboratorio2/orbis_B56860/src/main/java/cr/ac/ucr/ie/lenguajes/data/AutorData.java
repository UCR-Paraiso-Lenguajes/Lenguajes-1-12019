package cr.ac.ucr.ie.lenguajes.data;

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

import cr.ac.ucr.ie.lenguajes.domain.Autor;

@Repository
public class AutorData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Autor> ListarAutores(int inicio,int _final){
		String sqlSelect = "SELECT a.id_autor, a.nombre_autor, a.apellidos_autor "
				+ " FROM Autor a"
				+ " WHERE id_autor BETWEEN "+inicio+" AND "+_final;
		return jdbcTemplate.query(sqlSelect, new AutoresEstractor());
	}//findMoviesByTitleAndGenre

	class AutoresEstractor implements ResultSetExtractor<List<Autor>>{

		@Override
		public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Autor> map = new HashMap<Integer, Autor>();
			Autor autor = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id_autor");
				autor = map.get(id);
				
				if(autor == null) {
					
					autor = new	Autor();
					autor.setId_autor(rs.getInt("id_autor"));
					autor.setNombre_autor(rs.getString("nombre_autor"));
					autor.setApellidos_autor(rs.getString("apellidos_autor"));
					map.put(id, autor);
					
				}//if
			}//while
			return new ArrayList<Autor>(map.values());
		}//extractData
		
	}

}