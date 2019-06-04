package com.projectOne.interactiveMessaging.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
			Timestamp dateLastMessage, Timestamp dateFirstLogin, String BigUser, int numberMessagesBigUser, String LongestMessage,
			String LastRoomCreated, String BiggestRoom, int numberMessagesBiggestRoom, int sumOfUsersPerGroup, int quantityMessageBigUser) {
//		if(idMetrics==0 || numberOfRooms==0 || numberOfUsers==0 || averageOfUsersPerRoom==0
//				|| dateLastMessage.equals("") || dateFirstLogin.equals("") || BigUser==0
//				||numberMessagesBigUser==0 || LongestMessage==0 || LastRoomCreated==0 || BiggestRoom==0
//				||numberMessagesBiggestRoom==0) throw new RuntimeException("Los campos vienen vacío");
		
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String mySqlInsertMetrics="";
			mySqlInsertMetrics="Insert INTO Metrics values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statementMetrics = conexion.prepareStatement(mySqlInsertMetrics);
			statementMetrics.setInt(1, idMetrics);
			statementMetrics.setInt(2, numberOfRooms);
			statementMetrics.setInt(3, numberOfUsers);
			statementMetrics.setFloat(4, averageOfUsersPerRoom);
			statementMetrics.setDate(5, new java.sql.Date(dateLastMessage.getTime()));
			statementMetrics.setDate(6,  new java.sql.Date(dateFirstLogin.getTime()));
			statementMetrics.setString(7, BigUser);
			statementMetrics.setInt(8, numberMessagesBigUser);
			statementMetrics.setString(9, LongestMessage);
			statementMetrics.setString(10, LastRoomCreated);
			statementMetrics.setString(11, BiggestRoom);
			statementMetrics.setInt(12, numberMessagesBiggestRoom);
			statementMetrics.setInt(13, sumOfUsersPerGroup);
			statementMetrics.setInt(14, quantityMessageBigUser);
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
	public Metrics findMetrics (int idMetrics){
		//TODO Falta el parametro de entrada para ver porque voy a buscar
		String mySqlSelect = "SELECT idMetrics, numberOfRooms, numberOfUsers, averageOfUsersPerRoom, "
				+ "dateLastMessage, dateFirstLogin, idBigUser, numberMessagesBigUser, LongestMessage, "
				+ "LastRoomCreated, BiggestRoom, numberMessagesBiggestRoom, sumOfUsersPerGroup, quantityMessageBigUser " 
				+ "FROM Metrics "
				+ "WHERE idMetrics = "+ idMetrics;
		
		return jdbcTemplate.query(mySqlSelect, new MetricsExtractor());
	}
	
	
	@Transactional(readOnly=true)
	public Metrics recoverMetricsData(){
		String mysqlSelectMetrics = "SELECT idMetrics, numberOfRooms, numberOfUsers, averageOfUsersPerRoom, dateLastMessage, dateFirstLogin, idBigUser, numberMessagesBigUser," + 
				" LongestMessage, LastRoomCreated, BiggestRoom, numberMessagesBiggestRoom,sumOfUsersPerGroup,quantityMessageBigUser from Metrics";
		return jdbcTemplate.query(mysqlSelectMetrics, new MetricsExtractor());
	}
	
	
}

class MetricsExtractor implements ResultSetExtractor<Metrics>{
	
	Metrics metrics = Metrics.getInstance();

	@Override
	public Metrics extractData(ResultSet rs) throws SQLException {
//		Map<Integer, Metrics> map = new HashMap<Integer, Metrics>();
//		Metrics metrics = null;
		
			while (rs.next()) {
				int idMetrics = rs.getInt("idMetrics");
//				metrics = map.get(idMetrics);
//				if(metrics == null) {
//					metrics = new Metrics(/*idMetrics,rs.getInt("numberOfUsers"),
//							rs.getInt("numberOfRooms"),rs.getFloat("averageOfUsersPerRoom"),
//							rs.getDate("dateLastMessage"),rs.getDate("dateFirstLogin"),
//							rs.getInt("idBigUser"), rs.getInt("numberMessagesBigUser"),rs.getInt("idLongestMessage"),
//							rs.getInt("idLastRoomCreated"), rs.getInt("idBiggestRoom"), rs.getInt("numberMessagesBiggestRoom")*/);
					metrics.setId_Metrics(idMetrics);
					metrics.setNumberOfUsers(rs.getInt("numberOfUsers"));
					metrics.setNumberOfRooms(rs.getInt("numberOfRooms"));
					metrics.setAverageOfUsersPerRoom(rs.getFloat("averageOfUsersPerRoom"));
					metrics.setDateLastMessage(rs.getTimestamp("dateLastMessage"));
					metrics.setDateFirstLogin(rs.getTimestamp("dateFirstLogin"));
					metrics.setBigUser(rs.getInt("idBigUser")+"");
					metrics.setNumberMessagesBigUser(rs.getInt("numberMessagesBigUser"));
					metrics.setLongestMessage(rs.getString("LongestMessage"));
					metrics.setLastRoomCreated(rs.getString("LastRoomCreated"));
					metrics.setBiggestRoom(rs.getInt("BiggestRoom")+"");
					metrics.setNumberMessagesBiggestRoom(rs.getInt("numberMessagesBiggestRoom"));
					metrics.setSumOfUsersPerGroup(rs.getInt("sumOfUsersPerGroup")); 
					metrics.setQuantityMessageBigUser(rs.getInt("quantityMessageBigUser"));
			}
			return metrics;
	}
	
}