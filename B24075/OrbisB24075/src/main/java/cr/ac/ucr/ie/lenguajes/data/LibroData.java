package cr.ac.ucr.ie.lenguajes.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
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

import cr.ac.ucr.ie.lenguajes.domain.Editorial;
import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallLibro, simpleJdbcCallInsertarLibroAutor;

	@Autowired
	public void setDataSource(DataSource dataSource) {
	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCallLibro = new SimpleJdbcCall(dataSource).withCatalogName("dbo")
				.withProcedureName("insertarLibroSp").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlOutParameter("@id_libro", Types.INTEGER))
				.declareParameters(new SqlParameter("@titulo", Types.VARCHAR))
				.declareParameters(new SqlParameter("@ano", Types.SMALLINT))
				.declareParameters(new SqlParameter("@precio", Types.FLOAT))
				.declareParameters(new SqlParameter("@id_editorial", Types.INTEGER));
			
		this.simpleJdbcCallInsertarLibroAutor = new SimpleJdbcCall(dataSource).withCatalogName("dbo")
				.withProcedureName("insertarLibroAutorSp").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("@id_libro", Types.INTEGER))
				.declareParameters(new SqlParameter("@id_autor", Types.INTEGER));
		
		
	}
	
	@Transactional
	public Libro save(Libro libro) throws SQLException {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@id_libro",1)
				.addValue("@titulo",libro.getTitulo())
				.addValue("@ano", libro.getAno())
				.addValue("@id_editorial", libro.getEditorial().getIdEditorial())
				.addValue("@precio", libro.getPrecio());
		Map<String, Object> outParameters = simpleJdbcCallLibro.execute(parameterSource);
		libro.setIdLibro(Integer.parseInt(outParameters.get("@id_libro").toString()));


		for (int i = 0; i < libro.getAutores().size(); i++) {
			
			SqlParameterSource parameterSourceLibroAutor = new MapSqlParameterSource()
					.addValue("@id_libro",libro.getIdLibro())
					.addValue("@id_autor", libro.getAutores().get(i).getIdAutor());
			
			
			simpleJdbcCallInsertarLibroAutor.execute(parameterSourceLibroAutor);
			
		}
		
		return libro;
	}
	
	
	@Transactional(readOnly=true)
	public List<Libro> ListarLibros(int inicio,int _final){
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio , e.id_editorial, e.nombre, e.direccion, e.telefono"+
		" FROM Libro l, Editorial e"
		+" WHERE id_libro BETWEEN "+inicio+" and" + _final+" and l.id_editorial=e.id_editorial";
		return jdbcTemplate.query(sqlSelect, new LibrosEstractor());
	}//findMoviesByTitleAndGenre

	class LibrosEstractor implements ResultSetExtractor<List<Libro>>{

		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
			Editorial editorial = null;
			
			while(rs.next()) {
				
				Integer idLibro = rs.getInt("id_libro");
				libro = map.get(idLibro);
				
				
				if(libro == null) {
					
					libro = new	Libro();
					editorial= new Editorial();
					libro.setIdLibro(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setAno(rs.getInt("ano"));
					libro.setPrecio(rs.getFloat("precio"));
					editorial.setDireccion(rs.getString("direccion"));
					editorial.setNombre(rs.getString("nombre"));
					editorial.setTelefono(rs.getString("telefono"));
					libro.setEditorial(editorial);
					
					
				
					map.put(idLibro, libro);
					
				}//if
			}//while
			return new ArrayList<Libro>(map.values());
		}//extractData
	} 
}
