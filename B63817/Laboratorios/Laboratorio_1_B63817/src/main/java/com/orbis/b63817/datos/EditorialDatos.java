package com.orbis.b63817.datos;

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

import com.orbis.b63817.dominio.Editorial;
import com.orbis.b63817.dominio.Libro;


@Repository
public class EditorialDatos {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Editorial> listadoEditoriales(int cantidadInicial , int cantidadFinal) {
		String sqlSelect ="SELECT DISTINCT table_editorial.id_editorial, table_editorial.nombre, table_editorial.direccion, table_editorial.telefono\r\n" + 
				"FROM (SELECT ROW_NUMBER() OVER (ORDER BY e.id_Editorial) AS row_number,  \r\n" + 
				"e.id_editorial, e.nombre, e.direccion, e.telefono \r\n" + 
				"FROM Editorial e) as table_editorial\r\n" + 
				"WHERE row_number BETWEEN "+cantidadInicial+" AND "+cantidadFinal;
				
		 return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
	}// findMoviesByTitleAndGenre
}

class EditorialExtractor implements ResultSetExtractor<List<Editorial>> {
	@Override
	public List<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) { // new Editorial record
				editorial = new Editorial();
				editorial.setId_Editorial(id);
				editorial.setNombre(rs.getString("nombre"));
				editorial.setDireccion(rs.getString("direccion"));
				editorial.setTelefono(rs.getString("telefono"));
				
				map.put(id, editorial);	
		} // if
		int libroId = rs.getInt("id_libro");
		if (libroId> 0) {
			Libro libro = new Libro();
			libro.setId_libro(libroId);
			libro.setTitulo(rs.getString("titulo"));
			libro.setAno(rs.getInt("ano"));
			libro.setPrecio(rs.getFloat("precio"));
			editorial.getListaLibros().add(libro);
		} // if
		// TODO Auto-generated method stub
	} // while
	return new ArrayList<Editorial>(map.values());
}
	}
