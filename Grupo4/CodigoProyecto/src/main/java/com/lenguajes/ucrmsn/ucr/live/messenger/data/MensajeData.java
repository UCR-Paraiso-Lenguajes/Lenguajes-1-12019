package com.lenguajes.ucrmsn.ucr.live.messenger.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;

@Repository
public class MensajeData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	@Transactional(readOnly=true)
	public void save(Mensaje mensaje) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "INSERT INTO MENSAJE(contenido,version,idUsuario) VALUES(?,?,?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1,mensaje.getContenido());
			statementrol.setInt(2,mensaje.getVersion());
			statementrol.setInt(3,mensaje.getUsuario().getId());
			statementrol.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e3) {
					throw new RuntimeException(e3);
				}
			}
		}
	}
	

}
