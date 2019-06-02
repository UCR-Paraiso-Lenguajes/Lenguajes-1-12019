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
	        String sqlSelect = "select id_metrics,average_user_per_group,cantity_groups,cantity_users,date_first_login from metrics";
	        return jdbcTemplate.query(sqlSelect, new MetricsWithExtractor());
	    }
	    class MetricsWithExtractor implements ResultSetExtractor<List<Metrics>> {

	        @Override
	        public List<Metrics> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            Map<Integer, Metrics> map = new HashMap<>();
	            Metrics metrics = null;
	            while (rs.next()) {
	                Integer id = rs.getInt("idmetrics");
	                metrics = map.get(id);
	                if (metrics == null) {
	                    metrics = new Metrics();
	                    metrics.setIdmetrics(id);
	                    metrics.setAverageUsersForRooms(rs.getInt("average_user_room"));
	                    metrics.setQuantityOfRooms(rs.getInt("quantity_rooms"));
	                    metrics.setQuantityOfUsers(rs.getInt("quantity_user"));
	                    metrics.setDateOfFirstLogin(rs.getDate("date_first_login"));

	                    
	                    map.put(id, metrics);

	                }

	            }
	            return new ArrayList<Metrics>(map.values());
	        }

	    }

}