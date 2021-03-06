package com.proyectoUno.grupo5.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoUno.grupo5.dao.MetricsDao.UserMoreMessageExtractor;
import com.proyectoUno.grupo5.domain.Message;
import com.proyectoUno.grupo5.domain.Room;
@Repository
public class MessageDao {
	
	
		@Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;

	    
	    private Map<Integer, Message> messages;

	    
	    private Room room;
	    
	    public Boolean insertMessage(Message message){
	    	
	    	updateMetricMesage(message.getContenido());
	    	  
	    	  String query="insert into message(containt,id_user,id_room) values(?,?,?)";
	    	 	//updateVersion(message.getIdRoom());
	          return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
	              @Override
	              public Boolean doInPreparedStatement(PreparedStatement ps)
	                      throws SQLException, DataAccessException {
	                  ps.setString(1,message.getContenido());
	                  ps.setInt(2,message.getUserSendThatMessage());
	                  ps.setInt(3,message.getIdRoom());

	                  
	                  return ps.execute();

	              }
	          });
	    }

	

		class MessageWithExtractor implements ResultSetExtractor<List<Message>> {

	        @Override
	        public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            Map<Integer, Message> map = new HashMap<>();
	            Message message = null;
	            while (rs.next()) {
	                Integer id = rs.getInt("id_message");
	                message = map.get(id);
	                if (message == null) {
	                	message = new Message();
	                	message.setIdMessage(id);;
	                	message.setContenido(rs.getString("containt"));
	                    message.setFecha(rs.getDate("date"));
	                    message.setIdRoom(rs.getInt("id_room"));
	                    message.setUserSendThatMessage(rs.getInt("id_user"));

	                    

	                    map.put(id, message);

	                }

	            }
	            return new ArrayList<Message>(map.values());
	        }

	    }
	    
	    public List<Message> getMessagesByIdRoom(int idRoom){
	    	
	    	
	    	String sqlSelect = "SELECT id_message,date,containt,id_user,id_room from message WHERE id_room="+idRoom;
			
			return jdbcTemplate.query(sqlSelect, new MessageWithExtractor());
	    	 
	    }
	    
	    
	    public Map<Integer, Message> getMessagesSincro(List<Message> message){
			
	    	Map<Integer, Message> messagesMap = new HashMap<>();
	    	
	    	for (Message messageList : message) {
				
	    		messagesMap.put(messageList.getIdMessage(), messageList );
	    		
			}
	    	
	        Map<Integer,Message> synchonizedMessage = Collections.synchronizedMap(messagesMap);

	    	
	    	return synchonizedMessage;
	    	
	    	
	    	/*for (Map.Entry<Integer, Message> entry : messages.entrySet()) {
	    		
	    		if(entry.getValue().getIdRoom()==idRoom) {
	    			
	    			filterHash.put(entry.getKey(), entry.getValue());
	    		}
	    		
	    		
	    	    
	    	}
	    	
	    	return filterHash;
	    	*/
	    }
	    

	    /*Metric Message*/
	    
	    @Transactional(readOnly = true)
	    public String updateMetricMessage() {
	        String sqlSelect = "select message from metrics";
	        return jdbcTemplate.query(sqlSelect, new MessageExtractor());
	    }
	    class MessageExtractor implements ResultSetExtractor<String> {

	        @Override
	        public String extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	String resultado = "";
	        	while (rs.next()) {
	               resultado= rs.getString("message");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	       private void updateVersion(int idRoom) {
			int version=versionFinal();
			version=version+1;
			updateVersionAct(idRoom,version);
			
		}
	       
	     //  @Transactional
	    private void updateVersionAct(int idRoom, int version) {
	    		String sqlSelect = "UPDATE room SET version="+version+"WHERE id_room="+idRoom+"";
				jdbcTemplate.batchUpdate(sqlSelect);
			
		}


		public void updateMetricMesage(String message) {
	    	String messageInMetrics = updateMetricMessage();
	    	
	    	if(message.length()>messageInMetrics.length()) {
	    		update(message);
	    	}
	    	
	    	
	    }
	    
	    @Transactional(readOnly = true)
	    public Integer versionFinal() {
	        String sqlSelect = "select version from room";
	        return jdbcTemplate.query(sqlSelect, new VersionExtractor());
	    }
	    class VersionExtractor implements ResultSetExtractor<Integer> {

	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	int resultado = 0;
	        	while (rs.next()) {
	               resultado= rs.getInt("version");
	                   

	                }

	         
	            return resultado;
	        }

	    }
	    
	    @Transactional
	    public void update(String message) 
		{
			String sqlSelect = "UPDATE metrics SET message=\""+message+"\"WHERE id_metrics=1";
			jdbcTemplate.batchUpdate(sqlSelect);
		}
	    
	    
}
