package com.orbis.B52265.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orbis.B52265.domain.Autor;
@Repository
public class AutorDao {

	    @Autowired
	    private JdbcTemplate jdbcTemplate;



	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate= new JdbcTemplate(dataSource);
	    }


	    public List<Autor> listarAutores(int inicio, int fin)  {

	        List<Autor> autores = new ArrayList<>();
	        String selectSql =
	                "SELECT  id_autor, nombre_autor , apellidos_autor FROM Autor WHERE id_autor between ? and ? ";;
	        jdbcTemplate.query(
	                selectSql,
	                new Object[] {inicio,fin},
	                (rs,row)->	new Autor(rs.getInt("id_autor"),
	                        rs.getString("nombre_autor"),
	                        rs.getString("apellidos_autor") )
	        )
	                .forEach(entry ->  autores.add(entry)
	                );

	        return  autores;
	    }


}
