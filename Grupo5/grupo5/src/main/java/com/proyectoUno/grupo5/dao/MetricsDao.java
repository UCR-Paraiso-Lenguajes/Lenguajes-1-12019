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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.Role;

@Repository
public class MetricsDao {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;

	    @Transactional(readOnly = true)
	    public List<Metrics> getMetrics() {
	        String sqlSelect = "Select id_metrics, quantity_rooms,quantity_users,average_user_per_group,last_message,first_login,date_first_login,user_with_more_message,last_group_created,group_with_more_message From metrics";
	        return jdbcTemplate.query(sqlSelect, new MetricsWithExtractor());
	    }
	    class MetricsWithExtractor implements ResultSetExtractor<List<Metrics>> {

	        @Override
	        public List<Metrics> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            Map<Integer, Metrics> map = new HashMap<>();
	            Metrics metrics = null;
	            while (rs.next()) {
	                Integer id = rs.getInt("id_metrics");
	                metrics = map.get(id);
	                if (metrics == null) {
	                    metrics = new Metrics();
	                    metrics.setIdmetrics(id);
	                    metrics.setQuantityOfRooms(rs.getInt("quantity_rooms"));
	                    metrics.setQuantityOfUsers(rs.getInt("quantity_users"));
	                    metrics.setAverageUsersForRooms(rs.getInt("average_user_per_group"));
	                    metrics.setLast_message(rs.getString("last_message"));
	                    metrics.setFirst_login(rs.getDate("first_login"));
	                    metrics.setDate_first_login(rs.getDate("date_first_login"));
	                    metrics.setUser_with_more_message(rs.getInt("user_with_more_message"));
	                    metrics.setLast_group_created(rs.getString("last_group_created"));
	                    metrics.setGroup_with_more_message(rs.getString("group_with_more_message"));
	                    
	                     
	                

	                    
	                    map.put(id, metrics);

	                }

	            }
	            return new ArrayList<Metrics>(map.values());
	        }

	    }

}