package com.proyectoUno.grupo5.dao;

import java.sql.PreparedStatement;
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
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.proyectoUno.grupo5.domain.Message;
@Repository

public class MessageDao {
	
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;

	    public Boolean createTableMessage(String tableNameMessage){
	    	
	    	
	        String query="CREATE TABLE"+ tableNameMessage 
	        		+"id_message INT(50) NOT NULL AUTO_INCREMENT,"
	        		+ "content VARCHAR(30) NOT NULL,"
	        		+"dateMessage DATETIME,"
	        		+ "id_user INT(50) NOT NULL";

	        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
	            @Override
	            public Boolean doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {
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
	                	message.setContenido(rs.getString("content"));
	                    message.setFecha(rs.getDate("dateMessage"));

	                    map.put(id, message);

	                }

	            }
	            return new ArrayList<Message>(map.values());
	        }

	    }
	    
	    public List<Message> getMessagesByIdRoom(int idRoom){
	    	
	    	
	    	String sqlSelect = "SELECT id_message,date_fecha,contenido,id_user,id_room from message WHERE id_room="+idRoom;
			
			return jdbcTemplate.query(sqlSelect, new MessageWithExtractor());
	    	
	    	 
	    }
}
