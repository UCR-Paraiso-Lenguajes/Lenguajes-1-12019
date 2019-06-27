package com.orbis.b63685.Laboratorio2Orbis.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63685.Laboratorio2Orbis.domain.Autor;
import com.orbis.b63685.Laboratorio2Orbis.domain.Editorial;
import com.orbis.b63685.Laboratorio2Orbis.domain.Libro;

@Repository
public class LibroDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	@Transactional(readOnly=true)
	public List<Libro> buscaLibros(int idEditorial) {
		String sqlSelect = "SELECT l.id_libro,l.titulo,l.año,l.precio"
				+ " from libro l, Editorial e where l.id_editorial = "
		          + idEditorial+ " and e.id_editorial= "+ idEditorial;
		
		return jdbcTemplate.query(sqlSelect, new LibrosEditorialExtractor());
	}
	
	
	class LibrosEditorialExtractor implements ResultSetExtractor<List<Libro>> {
		
		@Override
		public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Libro> map = new HashMap<Integer, Libro>();
			Libro libro = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_libro");
				libro = map.get(id);
				if (libro == null) { 
					libro = new Libro();
					libro.setIdLibro(id);
					libro.setAno(rs.getShort("año"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setPrecio(rs.getFloat("precio"));
					map.put(id, libro);
				} 
				
			}
			return new ArrayList<Libro>(map.values());
		} 
	}
	
	public void saveLibro(Libro libro) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("{CALL Orbis_LibroInsert(?,?,?,?,?,?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, libro.getTitulo());
			cs.setFloat(3, libro.getPrecio());
			cs.setInt(4, libro.getAno());
			cs.setInt(5, libro.getEditorial().getIdEditorial());
			cs.setInt(6, libro.getIdLibro());
			cs.executeUpdate();
			libro.setIdLibro(cs.getInt(1));
			// insertamos los autores
			cs = conexion.prepareCall("{CALL Orbis_LibroAutorInsert(?,?)}");
			int cont = 0;
			while (cont < libro.getAutores().size()) {
				cs.setInt(1, libro.getIdLibro());
				Autor a = libro.getAutores().get(cont);
				cs.setInt(2, a.getIdAutor());
				cont++;
				cs.executeUpdate();
			}
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
}
