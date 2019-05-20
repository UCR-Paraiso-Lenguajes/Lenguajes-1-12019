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

import com.projectOne.interactiveMessaging.domain.Metrics;

public class MetricsData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Iterator <Metrics> findMetrics (){
		String mySqlSelect = "SELECT p.";
		return jdbcTemplate.query(mySqlSelect, new MetricsExtractor());
		
	}

}

class MetricsExtractor implements ResultSetExtractor<Iterator<Metrics>>{

	@Override
	public Iterator<Metrics> extractData(ResultSet rs) {
		Map<Integer, Metrics> map = new HashMap<Integer, Metrics>();
		Metrics metrics = null;
		try {
			while (rs.next()) {
				Integer id = rs.getInt("idMetrics");
				metrics = map.get(id);
				if(metrics == null) {
					metrics = new Metrics(id,rs.getInt("numberOfUsers"),
							rs.getInt("numberOfRooms"),rs.getFloat("averageOfUsersPerRoom"),
							rs.getDate("dateLastMessage"),rs.getDate("dateFirstLogin"),
							rs.getInt("idBigUser"),rs.getInt("idLongestMessage"),
							rs.getInt("idLastRoomCreated"), rs.getInt("idBiggestRoom"));
					map.put(id, metrics);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<Metrics>(map.values()).iterator();
	}
	
}