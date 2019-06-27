package com.videocartago.renting.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Movimiento;
import com.videocartago.renting.domain.Pelicula;

@Repository
public class MovimientoData {
	@Autowired
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	PeliculaData peliculaData= new PeliculaData();
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//guardar un nuevo movimiento
	@Transactional
	public Movimiento save(Movimiento movimiento)  {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("@estado", movimiento.getEstado())
				.addValue("@codPelicula", movimiento.getPelicula().getCodPelicula());
		Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
		movimiento.setCodMovimiento(Integer.parseInt(outParameters.get("@codMovimiento").toString()));
		return movimiento;
	}
	
	//Traer el estado del movimiento de acuerdo al código de la pelicula
	public String determinaEstado(int CodPelicula){
		 List<Movimiento> movimientoBuscado = new ArrayList<>();
		String selectSql = "SELECT cod_movimiento, estado, fecha FROM Movimiento where cod_pelicula > ?";
	 jdbcTemplate.query(selectSql, 
			 new Object[] {1}, (rs, row) -> 
	 new Movimiento(rs.getObject("Pelicula"), rs.getString("estado")))
	 .forEach(entry -> movimientoBuscado.add(entry));
	 Movimiento mov=movimientoBuscado.get(1);
	 return mov.getEstado();
	}
	
	
	@Transactional
	 private void Rentar(Pelicula peliculaARentar) {
		
	//tengo que crear un nuevo movimiento y guardarlo en la bd, con el código de mi peli	 
		 Movimiento movimientoNuevo = new Movimiento(peliculaARentar, "Rentada");
		  	 
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("@pelicula", movimientoNuevo.getPelicula().getCodPelicula())
					.addValue("@estado", movimientoNuevo.getEstado());
			Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
			movimientoNuevo.setCodMovimiento(Integer.parseInt(
					outParameters.get("@codMovimiento").toString()));		 
	 }
	 
	@Transactional
	 private void Devolver(Pelicula peliculaARentar) {
		 Movimiento movimientoNuevo = new Movimiento(peliculaARentar, "Stock");
		   
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("@pelicula", movimientoNuevo.getPelicula().getCodPelicula())
					.addValue("@estado", movimientoNuevo.getEstado());
			Map<String, Object> outParameters = simpleJdbcCall.execute(parameterSource);
			movimientoNuevo.setCodMovimiento(Integer.parseInt(
					outParameters.get("@codMovimiento").toString()));	
	 }
	

	public void colocarEstado(String tituloPelicula, boolean rentar) {
		 ArrayList<Pelicula> peliculaARentar = new ArrayList<>();
			peliculaARentar	= (ArrayList<Pelicula>) peliculaData.findMoviesByTitle(tituloPelicula);
		 Pelicula peliculaRentar = peliculaARentar.get(1);

		if(rentar) {
			Rentar(peliculaRentar);
		}else if(!rentar) {
			Devolver(peliculaRentar);
		}
	}
}
