package com.proyectoUno.grupo5.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.dialect.lock.UpdateLockingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoUno.grupo5.domain.Metrics;
import com.proyectoUno.grupo5.domain.Role;
import com.proyectoUno.grupo5.domain.Room;

@Repository
public class MetricsDao {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;

	    @Transactional
	    public List<Metrics> getMetrics() throws SQLException {
	    	updateMetrics();
	        String sqlSelect = "Select id_metrics, quantity_rooms,quantity_users,message,average_user_per_group,date_last_message,date_first_login,user_with_more_message,quantity_meesage_user,message,last_group_created,group_with_more_message,quantity_meessage_room From metrics";
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
	                    metrics.setMessage(rs.getString("message"));
	                    metrics.setAverageUsersForRooms(rs.getInt("average_user_per_group"));
	                    metrics.setDate_last_message(rs.getDate("date_last_message"));
	                    metrics.setDate_first_login(rs.getDate("date_first_login"));
	                    metrics.setUser_with_more_message(rs.getString("user_with_more_message"));
	                    metrics.setQuantityOfMessageUser(rs.getInt("quantity_meesage_user"));
	                    metrics.setLast_group_created(rs.getString("last_group_created"));
	                    metrics.setGroup_with_more_message(rs.getString("group_with_more_message"));
	                    metrics.setQuantityOfMessageRoom(rs.getInt("quantity_meessage_room"));
	                    
	                     
	                

	                    
	                    map.put(id, metrics);

	                }

	            }
	            return new ArrayList<Metrics>(map.values());
	        }

	    }
	    
	    
	    public void updateMetrics() {
	    	
	    	update(updateMetricNumbersOfGroup(),updateMetricNumbersOfUsers(),updateMetricAveragaUsers(),updateMetricDateOfLastMessage(),updateMetricUserMoreMessage(),updateMetricQuantityUserMoreMessage(),updateMetricLastRoom(),updateMetricQuantityRoomMoreMessage(),updateMetricRoomMoreMessage()); 
	   
	    	System.out.print(updateMetricQuantityRoomMoreMessage());
	
	    }
	    
	    
	    @Transactional(readOnly = true)
	    public Integer updateMetricNumbersOfGroup() {
	        String sqlSelect = "Select Count(room_name) AS Number_Of_Groups  From room;";
	        return jdbcTemplate.query(sqlSelect, new NumbersOfGroupExtractor());
	    }
	    class NumbersOfGroupExtractor implements ResultSetExtractor<Integer> {

	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
	           int resultado = 0;
	        	while (rs.next()) {
	               resultado= rs.getInt("Number_Of_Groups");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public Integer updateMetricNumbersOfUsers() {
	        String sqlSelect = "Select Count(id_user) AS Number_Of_Users From user;";
	        return jdbcTemplate.query(sqlSelect, new NumbersOfUsersExtractor());
	    }
	    class NumbersOfUsersExtractor implements ResultSetExtractor<Integer> {

	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
	           int resultado = 0;
	        	while (rs.next()) {
	               resultado= rs.getInt("Number_Of_Users");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public double updateMetricAveragaUsers() {
	        String sqlSelect = "Select AVG(temporaryTable.Number_Of_Users) as AVG From (Select Count(id_user) AS Number_Of_Users From user_room Group by id_room) temporaryTable;";
	        return jdbcTemplate.query(sqlSelect, new AvgExtractor());
	    }
	    class AvgExtractor implements ResultSetExtractor<Double> {

	        @Override
	        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	double resultado = 0;
	        	while (rs.next()) {
	               resultado= rs.getDouble("AVG");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public Date updateMetricDateOfLastMessage() {
	        String sqlSelect = "select date from message where id_message=(select MAX(id_message) from message);";
	        return jdbcTemplate.query(sqlSelect, new DateExtractor());
	    }
	    class DateExtractor implements ResultSetExtractor<Date> {

	        @Override
	        public Date extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	Date resultado = null;
	        	while (rs.next()) {
	               resultado= rs.getDate("date");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public Integer updateMetricQuantityUserMoreMessage() {
	        String sqlSelect = "Select MAX(temporaryTable.Number_Of_Menssages) as quantity_of_message,temporaryTable.id_user  from (Select Count(id_message) AS Number_Of_Menssages, id_user From message Group by id_user) temporaryTable;";
	        return jdbcTemplate.query(sqlSelect, new QuantityUserMoreMessageExtractor());
	    }
	    class QuantityUserMoreMessageExtractor implements ResultSetExtractor<Integer> {

	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	int resultado = 1;
	        	while (rs.next()) {
	               resultado= rs.getInt("quantity_of_message");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public String updateMetricUserMoreMessage() {
	        String sqlSelect = "Select MAX(temporaryTable.Number_Of_Menssages) as quantity_of_message, email from (Select Count(id_message) AS Number_Of_Menssages, id_user From message Group by id_user) temporaryTable join user where temporaryTable.id_user=user.id_user;";
	        return jdbcTemplate.query(sqlSelect, new UserMoreMessageExtractor());
	    }
	    class UserMoreMessageExtractor implements ResultSetExtractor<String> {

	        @Override
	        public String extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	String resultado = "";
	        	while (rs.next()) {
	               resultado= rs.getString("email");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	  
	    @Transactional(readOnly = true)
	    public String updateMetricLastRoom() {
	        String sqlSelect = "select room_name from room where id_room=(select MAX(id_room) from room)";
	        return jdbcTemplate.query(sqlSelect, new LastRoomExtractor());
	    }
	    class LastRoomExtractor implements ResultSetExtractor<String> {

	        @Override
	        public String extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	String resultado = "";
	        	while (rs.next()) {
	               resultado= rs.getString("room_name");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	  
	    @Transactional(readOnly = true)
	    public Integer updateMetricQuantityRoomMoreMessage() {
	        String sqlSelect = "Select MAX(temporaryTable.Number_Of_Menssages) as quantity_of_message,room.room_name  from (Select Count(id_message) AS Number_Of_Menssages, id_room From message Group by id_room) temporaryTable join room where temporaryTable.id_room=room.id_room ;";
	        return jdbcTemplate.query(sqlSelect, new QuantityRoomMoreMessageExtractor());
	    }
	    class QuantityRoomMoreMessageExtractor implements ResultSetExtractor<Integer> {

	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	int resultado = 1;
	        	while (rs.next()) {
	               resultado= rs.getInt("quantity_of_message");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional(readOnly = true)
	    public String updateMetricRoomMoreMessage() {
	        String sqlSelect = "Select MAX(temporaryTable.Number_Of_Menssages) as quantity_of_message,room.room_name as room_name  from (Select Count(id_message) AS Number_Of_Menssages, id_room From message Group by id_room) temporaryTable join room where temporaryTable.id_room=room.id_room ;";
	        return jdbcTemplate.query(sqlSelect, new RoomMoreMessageExtractor());
	    }
	    class RoomMoreMessageExtractor implements ResultSetExtractor<String> {

	        @Override
	        public String extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	String resultado ="";
	        	while (rs.next()) {
	               resultado= rs.getString("room_name");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional
	    public void update(Integer quantity_rooms, Integer quantity_users, double average_user_per_group, Date date_last_message, String user_with_more_message, Integer quantity_meesage_user, String last_group_created, Integer quantity_meessage_room, String group_with_more_message) 
		{
			String sqlSelect = "UPDATE metrics SET quantity_rooms="+quantity_rooms+",quantity_users="+quantity_users+",average_user_per_group="+average_user_per_group+",date_last_message=\""+date_last_message+"\",user_with_more_message=\""+user_with_more_message+"\",quantity_meesage_user="+quantity_meesage_user+",last_group_created=\""+last_group_created+"\",group_with_more_message=\""+group_with_more_message+"\",quantity_meessage_room="+quantity_meessage_room+" WHERE id_metrics=1";
			jdbcTemplate.batchUpdate(sqlSelect);
		}

}