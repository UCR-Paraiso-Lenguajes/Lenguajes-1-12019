package cr.ac.ucr.ie.lenguajes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

import cr.ac.ucr.ie.lenguajes.domain.Autor;
@Repository
public class AutorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly=true)
	public List<Autor> buscarAutores(){
		
		String sqlSelect="select id_autor,nombre_autor,apellidos_autor from autor" + 
				" order by id_autor";
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());
	}
	@Transactional(readOnly=true)
	public List<Autor> buscarAutorId(int id){
		
		String sqlSelect="select id_autor,nombre_autor,apellidos_autor from autor " + 
				" where id_autor="+id;
		
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());
	}
	
	@Transactional(readOnly=true)
	public List<Autor> buscarAutorApellido(String apellido){
		
		String sqlSelect="select id_autor,nombre_autor,apellidos_autor from autor" + 
				" where apellidos_autor Like '%"+apellido+"%'";
		
		return jdbcTemplate.query(sqlSelect, new autoresWithIdExtractor());
	}
	@Transactional(readOnly=true)
	public void eliminarAutor(int idAutor){		
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlIntermedia = "DELETE FROM Libro_Autor WHERE id_autor= "+idAutor;
			PreparedStatement statementLibro = conexion.prepareStatement(sqlIntermedia);
			statementLibro.executeUpdate();
			String sql = "DELETE FROM Autor WHERE id_autor = "+idAutor;
			PreparedStatement statementLibroAutor = conexion.prepareStatement(sql);
			statementLibroAutor.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
				
		}
	@Transactional
	public void actualizarAutor(Autor autor){		
		String sql = "UPDATE Autor SET nombre_autor = '"+autor.getNombreAutor()+"', "
				+ "apellidos_autor = '"+autor.getApellidosAutor()+"' "
						+ "WHERE id_autor = "+autor.getIdAutor();

 		jdbcTemplate.batchUpdate(sql);
		
	}
}


class autoresWithIdExtractor implements ResultSetExtractor<List<Autor>>{
	@Override
	public List<Autor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Autor> map = new HashMap<Integer, Autor>();
		Autor autor = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_autor");
			autor = map.get(id);
			if (autor == null) {
				autor = new Autor();
				autor.setIdAutor(id);
				autor.setNombreAutor(rs.getString("nombre_autor"));
				autor.setApellidosAutor(rs.getString("apellidos_autor"));
				map.put(id, autor);
			}
		}
		return new ArrayList<Autor>(map.values());
	}
	}
	

	


