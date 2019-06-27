package cr.ac.ucr.ie.lenguajes.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import cr.ac.ucr.ie.lenguajes.domain.Editorial;
import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Repository
public class EditorialData {
		@Autowired
		private JdbcTemplate jdbcTemplate;
	
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	
	public List<Editorial> listarEditoriales(int numInicio, int numFinal) {
		
		   List<Editorial> editoriales = new ArrayList<>();
		String sqlSelect = "SELECT e.id_editorial, e.nombre, e.direccion, e.telefono, "
				+ "l.ano, l.id_editorial, l.id_libro, l.precio, l.titulo "
				+ "FROM Editorial e join Libro l on e.id_editorial = l.id_editorial"
				+ "  WHERE e.id_editorial BETWEEN "+ numInicio + " AND  " + numFinal+"";
		
		jdbcTemplate.query(sqlSelect, new Object[] {}, (rs, row) -> new Editorial(rs.getInt("id_editorial"),
	                rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"))).forEach(Entry->editoriales.add(Entry));
		return editoriales;
	
	}
	
	@Transactional(readOnly = true)
	public List<Libro> listarLibrosPorEditorial(int idEditorial) {
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio, l.id_editorial "
				+ " FROM Libro l"
				+ " WHERE " +idEditorial+ " = l.id_editorial";
	
		return jdbcTemplate.query(sqlSelect, new LibrosExtractor());
	}

}


class LibrosExtractor implements ResultSetExtractor<List<Libro>> {
		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
		
			while (rs.next()) {
				int idLibro = rs.getInt("id_libro");
				libro = map.get(idLibro);
		
				if (libro == null) {
					libro = new Libro();
					libro.setAno(rs.getShort("ano"));
					libro.setIdLibro(rs.getInt("id_libro"));
					libro.setPrecio(rs.getInt("precio"));
					libro.setTitulo(rs.getString("titulo"));
					map.put(idLibro, libro);
				}
				
			}
		
			return new ArrayList<Libro>(map.values());
}

}


