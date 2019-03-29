package cr.ac.ucr.ie.lenguajes.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.ie.lenguajes.domain.Editorial;

@Repository
public class EditorialData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Collection<Editorial> ListarEditoriales(int inicio,int _final){
		String sqlSelect = "SELECT e.id_editorial, e.nombre, e.direccion, e.telefono"
				+ "FROM Editorial e"
				+ " WHERE consecutivo BETWEEN "+inicio+" AND "+_final;
		return jdbcTemplate.query(sqlSelect, new EditorialEstractor());
	}//findMoviesByTitleAndGenre

	
	class EditorialEstractor implements ResultSetExtractor<List<Editorial>>{

		@Override
		public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
			Editorial editorial = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id_libro");
				editorial = map.get(id);
				
				if(editorial == null) {
					
					editorial = new	Editorial();
					editorial.setId_editorial(rs.getInt("id_editorial"));
					editorial.setNombre(rs.getString("nombre"));
					editorial.setDireccion(rs.getString("direccion"));
					editorial.setTelefono(rs.getInt("telefono"));
					map.put(id, editorial);
					
				}//if
			}//while
			return new ArrayList<Editorial>(map.values());
		}//extractData
	}
}
