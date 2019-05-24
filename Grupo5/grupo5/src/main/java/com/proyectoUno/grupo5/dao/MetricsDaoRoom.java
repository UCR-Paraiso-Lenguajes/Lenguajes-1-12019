package com.proyectoUno.grupo5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoUno.grupo5.dao.MetricsDao.MetricsWithExtractor;
import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.MetricsRooms;

public class MetricsDaoRoom {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;

	    @Transactional(readOnly = true)
	    public List<MetricsRooms> getMetricsRoom() {
	        String sqlSelect = "SELECT idMetricsRoom,userWithMoreMessage,longerMesssage,dateOfLastMessage,idRoom FROM metricsRoom";
	        return jdbcTemplate.query(sqlSelect, new MetricsRoomWithExtractor());
	    }
	    class MetricsRoomWithExtractor implements ResultSetExtractor<List<MetricsRooms>> {

	        @Override
	        public List<MetricsRooms> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            Map<Integer, MetricsRooms> map = new HashMap<>();
	            MetricsRooms metrics = null;
	            while (rs.next()) {
	                Integer id = rs.getInt("idMetricsRoom");
	                metrics = map.get(id);
	                if (metrics == null) {
	                    metrics = new MetricsRooms();
	                    metrics.setIdMetricsRoom(id);
	                    metrics.setUserWithMoreMessage(("userWithMoreMessage"));
	                    metrics.setLongerMesssage(("longerMesssage"));
	                    metrics.setDateOfLastMessage(rs.getDate("dateOfLastMessage"));
	                    metrics.setRoom(rs.getInt("idRoom"));

	                    
	                    map.put(id, metrics);

	                }

	            }
	            return new ArrayList<MetricsRooms>(map.values());
	        }

	    }
	
}
