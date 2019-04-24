package com.orbis.b54524.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.orbis.b54524.dominio.Autor;
import com.orbis.b54524.dominio.Editorial;
import com.orbis.b54524.dominio.Libro;

@Repository
public class LibroDatos {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
		.withCatalogName("dbo")
		.withProcedureName("INGRESAR_LIBROS")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(new SqlOutParameter("@idLibro", Types.INTEGER))
		.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
		.declareParameters(new SqlParameter("@año", Types.INTEGER))
		.declareParameters(new SqlParameter("@precio", Types.FLOAT))
		.declareParameters(new SqlParameter("@idEditorial", Types.INTEGER));
	
   }
	
	@Transactional
	public Libro save(Libro libro) throws NumberFormatException, Exception {

		SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("@titulo", libro.getTitulo())
				.addValue("@año", libro.getAnio()).addValue("@precio", libro.getPrecio())
				.addValue("@idEditorial", libro.getEditorial().getIdEditorial());

		Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
		libro.setIdLibro(Integer.parseInt(outParameters.get("@idLibro").toString()));
		return libro;

	}
	
	@Transactional(readOnly=true)
	public ArrayList<Libro> listarLibros(int inicioRegistros, int finRegistros, int idEditorial){
		
		String sqlSelect = "SELECT table_libros.id_libro, table_libros.titulo, table_libros.ano, table_libros.precio, " + 
				"table_libros.id_autor, table_libros.nombre_autor, table_libros.apellidos_autor, " + 
				"table_libros.id_editorial, table_libros.nombre AS 'nombre_editorial', table_libros.direccion AS 'direccion_editorial', table_libros.telefono AS 'telefono_editorial' " + 
				" FROM (SELECT ROW_NUMBER() OVER (ORDER BY l.id_libro) AS row_number, l.id_libro, l.titulo, l.ano, l.precio, " + 
				"a.id_autor, a.nombre_autor, a.apellidos_autor, " + 
				"e.id_editorial, e.nombre, e.direccion, e.telefono " + 
				"FROM Libro l JOIN Libro_Autor la ON " + 
				"l.id_libro = la.id_libro JOIN " + 
				"Autor a ON la.id_autor = a.id_autor JOIN " + 
				"Editorial e ON l.id_editorial = e.id_editorial) as table_libros " + 
				"WHERE row_number BETWEEN "+inicioRegistros+" AND "+finRegistros+" AND id_editorial = "+idEditorial;
		return jdbcTemplate.query(sqlSelect, new LibrosWithAutorsExtractor());
	}
	
	
}


class LibrosWithAutorsExtractor implements ResultSetExtractor<ArrayList<Libro>> {
	@Override
	public ArrayList<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		Libro libro = null;
		Editorial editorial = new Editorial();
		while (rs.next()) {
			Integer id = rs.getInt("id_libro");
			libro = map.get(id);
			if (libro == null) {
				libro = new Libro();
				try {
					libro.setIdLibro(id);
					libro.setTitulo(rs.getString("titulo"));
					libro.setAnio(rs.getShort("ano"));
					libro.setPrecio(rs.getFloat("precio"));
					editorial.setIdEditorial(rs.getInt("id_editorial"));
					editorial.setNombre(rs.getString("nombre_editorial"));
					editorial.setDireccion(rs.getString("direccion_editorial"));
					editorial.setTelefono(rs.getString("telefono_editorial"));
					libro.setEditorial(editorial);
					map.put(id, libro);
				}catch (Exception e) {
					//e.printStackTrace();// TODO: handle exception
				}
				
			}
			int autorId = rs.getInt("id_autor");
			if (autorId > 0) {
				Autor autor = new Autor();
				try {
					autor.setIdAutor(autorId);
					autor.setNombreAutor(rs.getString("nombre_autor"));
					autor.setApellidosAutor(rs.getString("apellidos_autor"));
					libro.getAutores().add(autor);
				}catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
			}
		}
		return new ArrayList<Libro>(map.values());
	}
}
