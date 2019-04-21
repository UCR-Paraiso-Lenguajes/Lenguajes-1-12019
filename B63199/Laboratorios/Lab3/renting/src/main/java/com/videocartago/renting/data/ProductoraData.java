package com.videocartago.renting.data;
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

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Clip;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Movimiento;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.Video;


@Repository
public class ProductoraData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	private Pelicula pelicula;
	private Clip clip;
	private Video video;

	@Autowired
	public void crearFilm(Object film) {
		pelicula = new Pelicula();
		clip = new Clip();
		video = new Video();
		
		PeliculaData peliculaData = new PeliculaData();
		VideoData videoData = new VideoData();
		ClipData clipData = new ClipData();
		
		if(film.getClass().equals(Pelicula.class)) {
			peliculaData.save((Pelicula) film);
		}else if(film.getClass().equals(Clip.class)) {
			clipData.save((Clip)film);
		}else if(film.getClass().equals(Video.class)) {
			videoData.save((Video)film);
		}
	}
	
	
}