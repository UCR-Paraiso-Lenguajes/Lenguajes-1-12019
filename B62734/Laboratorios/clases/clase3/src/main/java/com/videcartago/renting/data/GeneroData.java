package com.videcartago.renting.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.videcartago.renting.domain.Genero;

@Repository
public class GeneroData {
 
 
 @Autowired
 private JdbcTemplate jdbcTemplate;
 
 private void setDataSource(DataSource dataSource) {
  this.jdbcTemplate = new JdbcTemplate(dataSource);
 }
 
 public List<Genero> findAllGenres(int inicio, int fin){
  List<Genero> generos = new LinkedList<Genero>();
  String sqlSelect="SELECT cod_genero ,nombre_genero" + 
    " FROM dbo.Genero" + 
    "where cod_genero>? AND cod_genero<?"+
    " ORDER BY cod_genero ASC";
   
  jdbcTemplate.query(sqlSelect, new Object[] {inicio,fin}, (rs,row)->new Genero(rs.getInt("cod_genero"),
    rs.getString("nombre_genero"))).forEach(entry -> generos.add(entry));
  return generos;
 }


}
