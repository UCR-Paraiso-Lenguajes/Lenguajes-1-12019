package cr.ac.ucr.ie.lenguajes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.ie.lenguajes.domain.Autor;
import cr.ac.ucr.ie.lenguajes.domain.Libro;

@Repository
public class LibroData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Transactional(readOnly=true)
	public List<Libro> ListarLibros(int inicio,int _final){
		String sqlSelect = "SELECT l.id_libro, l.titulo, l.ano, l.precio "
				+ " FROM Libro l"
				+ " WHERE id_libro BETWEEN "+inicio+" AND "+_final;
		return jdbcTemplate.query(sqlSelect, new LibrosEstractor());
	}//findMoviesByTitleAndGenre


	public Libro save(Libro libro)
	{
		
		Connection conexion = null;
		
		try {
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
		
			
			String insertLibro = "INSERT INTO Libro  (titulo, precio, ano)  VALUES(?,?,?)";
			
			PreparedStatement prest;
			prest = conexion.prepareStatement(insertLibro,Statement.RETURN_GENERATED_KEYS);
			prest.setString(1, libro.getNombre_libro());
			prest.setFloat(2, libro.getPrecio());
			prest.setInt(3, libro.getAno());
            prest.executeUpdate();
			
			
			
			ResultSet rs = prest.getGeneratedKeys();
            if(rs.next())
            {
                libro.setId_libro(rs.getInt(1));
            }
            
            

            
            
			String insertLibro_Autor = "INSERT INTO Libro_Autor  (id_libro, id_autor)  VALUES(?,?)";
			
			
             
            for(int i=0; i < libro.getAutores().size(); i++) {
             
             PreparedStatement statementLibroAutor = conexion.prepareStatement(insertLibro_Autor);
             statementLibroAutor.setInt(1, libro.getId_libro());
             statementLibroAutor.setInt(2,((Autor)libro.getAutores().get(i)).getId_autor());
             statementLibroAutor.executeUpdate();
             
            }
			
			
			
			prest = conexion.prepareStatement(insertLibro_Autor);
			
			
			
			
			
			conexion.commit();
		}catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException a) {
				throw new RuntimeException(a);
			}
			throw new RuntimeException(e);
		}
		finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException a) {
					throw new RuntimeException(a);
				}
			}
		}
		
		return libro;
	}
	
	
	
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
