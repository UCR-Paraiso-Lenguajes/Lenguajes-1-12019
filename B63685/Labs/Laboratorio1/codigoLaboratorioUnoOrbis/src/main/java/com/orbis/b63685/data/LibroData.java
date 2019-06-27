package com.orbis.b63685.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.b63685.domain.Autor;
import com.orbis.b63685.domain.Libro;

@Repository
public class LibroData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Libro> buscarPorEditorial(int codEditorial){
		String sqlSelect="select l.id_libro, l.ano,l.titulo,l.precio, e.nombre" + 
		          " from libro l, Editorial e where l.id_editorial = "
		          + codEditorial+ " and e.id_editorial= "+ codEditorial;
		return jdbcTemplate.query(sqlSelect, new LibrosWithTitleExtractor());
	}
	
}


class LibrosWithTitleExtractor implements ResultSetExtractor<List<Libro>>{

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Libro> list = new LinkedList<>();
		Libro libro= null;
		while(rs.next()) {
			Integer idLibroActual= rs.getInt("id_libro");
				libro= new Libro();
				libro.setIdLibro(idLibroActual);
				libro.setTitulo(rs.getString("titulo"));
				libro.setPrecio(rs.getFloat("precio"));
				
				list.add(libro);
			}
		
		return list;
	}
	
}

