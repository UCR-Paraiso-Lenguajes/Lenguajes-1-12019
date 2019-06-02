package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;
import com.chat.domain.HistorialLogueo;
import com.chat.domain.Message;

@Repository
public class HistorialLogueoData {

	@Autowired
	private DataSource dataSource;
	
	@Transactional
	public void insertLogueo(HistorialLogueo historialLogueo) {
		Connection conexion = null;
		
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsert = "INSERT INTO history_Log(id, id_user, fecha_inicio) "
					+ "VALUES (?, ?, ?)";
			PreparedStatement statementInser = conexion.prepareStatement(sqlInsert);
			statementInser.setInt(1, historialLogueo.getId());
			statementInser.setInt(2, historialLogueo.getId_user());
			statementInser.setString(3, historialLogueo.getFecha());
			statementInser.executeUpdate();

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
	
	public ArrayList<HistorialLogueo> getLogin() {

		ArrayList<HistorialLogueo> logueos = new ArrayList<HistorialLogueo>();
		
		String sql = "Select fecha_ingreso From history_Log";
		
		Connection conexion = null;
		ResultSet rs = null;
		try{
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()) {
				HistorialLogueo historialLogueo = new HistorialLogueo(
						rs.getInt("id"),
						rs.getString("fecha_ingreso"),
						rs.getInt("id_user")
						);
				
				logueos.add(historialLogueo);
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return logueos;
	}
	
}
