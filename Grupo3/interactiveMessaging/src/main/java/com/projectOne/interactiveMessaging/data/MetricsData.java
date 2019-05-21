package com.projectOne.interactiveMessaging.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Metrics;

public class MetricsData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public Iterator <Metrics> findMetrics (int idMetrics){
		//TODO Falta el parametro de entrada para ver porque voy a buscar
		String mySqlSelect = "SELECT idMetrics, numbersOfRooms, numbersOfUsers, averageOfUsersPerRoom,"
				+ "dateLastMessage, dateFirstLogin, idBigUser, numbersMessagesBigUser, idLongestMessage,"
				+ "idLastRoomCreated, idBiggestRoom, numberMessageBiggestRoom "
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