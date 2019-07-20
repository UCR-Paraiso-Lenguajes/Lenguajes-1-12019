package com.orbis.B78225.ventas.data;
import  com.orbis.B78225.ventas.domain.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutorData {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }


    public List<Autor> listarAutores(int inicio, int fin)  {

        List<Autor> autores = new ArrayList<>();
        String selectSql =
                "SELECT  id_autor, nombre_autor , apellidos_autor FROM Autor WHERE id_autor between ? and ? ";
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