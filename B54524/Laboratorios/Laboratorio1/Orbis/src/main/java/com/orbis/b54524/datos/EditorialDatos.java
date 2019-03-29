package com.orbis.b54524.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.orbis.b54524.dominio.Editorial;
import com.orbis.b54524.dominio.Libro;

@Repository
public class EditorialDatos {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator<Editorial> listarEditoriales(int inicioRegistros, int finRegistros){
		String sqlSelect = "SELECT table_editorial.id_editorial, table_editorial.nombre, table_editorial.direccion, table_editorial.telefono, " + 
				"table_editorial.id_libro, table_editorial.titulo, table_editorial.ano, table_editorial.precio " + 
				"FROM (SELECT ROW_NUMBER() OVER (ORDER BY l.id_libro) AS row_number, l.id_libro, l.titulo, l.ano, l.precio, " + 
				"e.id_editorial, e.nombre, e.direccion, e.telefono " + 
				"FROM Libro l JOIN " + 
				"Editorial e ON l.id_editorial = e.id_editorial) as table_editorial " + 
				"WHERE row_number BETWEEN "+inicioRegistros+" AND "+finRegistros;
		return jdbcTemplate.query(sqlSelect, new EditorialWithLibrosExtractor());
	}
}

class EditorialWithLibrosExtractor implements ResultSetExtractor<Iterator<Editorial>> {
	@Override
	public Iterator<Editorial> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Editorial> map = new HashMap<Integer, Editorial>();
		Editorial editorial = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_editorial");
			editorial = map.get(id);
			if (editorial == null) { // new pelicula record
				editorial = new Editorial();
				try {
					editorial.setIdEditorial(id);
					editorial.setNombre(rs.getString("nombre"));
					editorial.setDireccion(rs.getString("direccion"));
					editorial.setTelefono(rs.getString("telefono"));
					map.put(id, editorial);
				}catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
				
			} // if
			int libroId = rs.getInt("id_libro");
			if (libroId > 0) {
				Libro libro = new Libro();
				try {
					libro.setIdLibro(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setAnio(rs.getShort("ano"));
					libro.setPrecio(rs.getFloat("precio"));
					editorial.getLibros().add(libro);
				}catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
			} // if
			// TODO Auto-generated method stub
		} // while
		return new ArrayList<Editorial>(map.values()).iterator();
	} // extractData
}
