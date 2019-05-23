package com.projectOne.interactiveMessaging.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Metrics;

@Repository
public class MetricsData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Transactional(readOnly=true)
	public boolean saveMetrics(int idMetrics, int numberOfRooms, int numberOfUsers, float averageOfUsersPerRoom,
			Date dateLastMessage, Date dateFirstLogin, int idBigUser, int numberMessagesBigUser, int idLongestMessage,
			int idLastRoomCreated, int idBiggestRoom, int numberMessagesBiggestRoom) {
		if(idMetrics==0 || numberOfRooms==0 || numberOfUsers==0 || averageOfUsersPerRoom==0
				|| dateLastMessage.equals("") || dateFirstLogin.equals("") || idBigUser==0
				||numberMessagesBigUser==0 || idLongestMessage==0 || idLastRoomCreated==0 || idBiggestRoom==0
				||numberMessagesBiggestRoom==0) throw new RuntimeException("Los campos vienen vacío");
		
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String mySqlInsertMetrics="";
			mySqlInsertMetrics="Insert INTO Metrics values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statementMetrics = conexion.prepareStatement(mySqlInsertMetrics);
			statementMetrics.setInt(1, idMetrics);
			statementMetrics.setInt(2, numberOfRooms);
			statementMetrics.setInt(3, numberOfUsers);
			statementMetrics.setFloat(4, averageOfUsersPerRoom);
			statementMetrics.setDate(5, new java.sql.Date(dateLastMessage.getTime()));
			statementMetrics.setDate(6,  new java.sql.Date(dateFirstLogin.getTime()));
			statementMetrics.setInt(7, idBigUser);
			statementMetrics.setInt(8, numberMessagesBigUser);
			statementMetrics.setInt(9, idLongestMessage);
			statementMetrics.setInt(10, idLastRoomCreated);
			statementMetrics.setInt(11, idBiggestRoom);
			statementMetrics.setInt(12, numberMessagesBiggestRoom);
			statementMetrics.executeUpdate();
			
			
			conexion.commit();
			return true;
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
	
	@Transactional(readOnly=true)
	public Iterator <Metrics> findMetrics (int idMetrics){
		//TODO Falta el parametro de entrada para ver porque voy a buscar
		String mySqlSelect = "SELECT idMetrics, numberOfRooms, numberOfUsers, averageOfUsersPerRoom,"
				+ "dateLastMessage, dateFirstLogin, idBigUser, numberMessagesBigUser, idLongestMessage,"
				+ "idLastRoomCreated, idBiggestRoom, numberMessagesBiggestRoom "
				+ "FROM Metrics "
				+ "WHERE idMetrics = "+ idMetrics;
		
		return jdbcTemplate.query(mySqlSelect, new MetricsExtractor());
	}
}

class MetricsExtractor implements ResultSetExtractor<Iterator<Metrics>>{

	@Override
	public Iterator<Metrics> extractData(ResultSet rs) throws SQLException {
		Map<Integer, Metrics> map = new HashMap<Integer, Metrics>();
		Metrics metrics = null;
			while (rs.next()) {
				int idMetrics = rs.getInt("idMetrics");
				metrics = map.get(idMetrics);
				if(metrics == null) {
					metrics = new Metrics(idMetrics,rs.getInt("numberOfUsers"),
							rs.getInt("numberOfRooms"),rs.getFloat("averageOfUsersPerRoom"),
							rs.getDate("dateLastMessage"),rs.getDate("dateFirstLogin"),
							rs.getInt("idBigUser"),rs.getInt("idLongestMessage"),
							rs.getInt("idLastRoomCreated"), rs.getInt("idBiggestRoom"));
					//TODO faltan agregar dos valores que si estan en base, Cambiar metrics domain
					map.put(idMetrics, metrics);
				}
			}
		
		return new ArrayList<Metrics>(map.values()).iterator();
	}
	
}