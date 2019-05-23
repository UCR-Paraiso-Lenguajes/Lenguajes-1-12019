package cr.ac.ucr.data;


import java.sql.Connection;
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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.domain.Message;


@Repository
public class MessageData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Transactional(readOnly=true)
	public List<Message> ListMessages(int amount){
		String sqlSelect = "SELECT * "
						+ " FROM Message m LIMIT "+amount;
		return jdbcTemplate.query(sqlSelect, new MessagesEstractor());
	}


	public void insertMessage(Message message)
	{
		
		Connection conexion = null;
		
		try {
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
		
			
			String insertMessage = "INSERT INTO Message/*atributes*/  VALUES(?,?,?,?)";
			
			PreparedStatement prest;
			prest = conexion.prepareStatement(insertMessage);
			
			prest.executeUpdate();
			
			
			

            
            
            
			String insertMetrics = "INSERT INTO Metrics  /*atributes*/  VALUES(?,?)";
			
			
			
			prest = conexion.prepareStatement(insertMetrics);
			
			
			
			
			
			conexion.commit();
		}catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException a) {
				throw new RuntimeException(a);
			}
			throw new RuntimeException(e);
		}
		finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException a) {
					throw new RuntimeException(a);
				}
			}
		}
		
		
	}
	
	
	
	class MessagesEstractor implements ResultSetExtractor<List<Message>>{

		@Override
		public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Message> map = new HashMap<Integer, Message>();
			Message message = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("idMensaje");
				message = map.get(id);
				
				if(message == null) {
					
					message = new Message();
					message.setId(rs.getInt("idMensaje"));
                    message.setContent(rs.getString("detalle"));
                    message.setDate(rs.getDate("fecha"));
					map.put(id, message);
					
				}//if
			}//while
			return new ArrayList<Message>(map.values());
		}//extractData
	}
}