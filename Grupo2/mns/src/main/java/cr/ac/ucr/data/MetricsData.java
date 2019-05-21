package cr.ac.ucr.data;

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

import cr.ac.ucr.domain.Metrics;

@Repository
public class MetricsData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	
	@Transactional(readOnly=true)
	public List<Metrics> ListMetrics(int amount){
		String sqlSelect = "SELECT TOP ? * "
				+ " FROM Metrics m";
		return jdbcTemplate.query(sqlSelect, 
				new Object[] {amount},new MetricsEstractor());
	}

	
	
	
	public void insertMetrics(Metrics instance)
	{
		// TODO Auto-generated method stub
		
	}

	
	public void setState(Metrics m)
	{
		/*	metrics.setState( 	
		
					rs.getInt("id_metrics"),
					rs.getInt("rooms_quantity"),
					rs.getInt("users_quantity"), 
					rs.getDate("last_message"), 
					rs.getDate("first_login"), 
					metrics.getLongestMessage().setId(rs.getInt("longest_message")), 
					metrics.getMostActiveUser().setIdUser(rs.getInt("most_active_user")), 
					rs.getInt("most_active_user_message_amount"), 
					metrics.getLastRoomCreated().setIdRoom(rs.getInt("last_room_created")), 
					metrics.getMostActiveRoom().setIdRoom(rs.getInt("most_active_room")), 
					rs.getInt("most_active_room_message_amount"), 
					rs.getDouble("users_promedy_by_room")
	
			);

		 */
	}
	
	
	
	class MetricsEstractor implements ResultSetExtractor<List<Metrics>>{

		@Override
		public List<Metrics> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Metrics> map = new HashMap<Integer, Metrics>();
			Metrics metrics = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("id_metrics");
				metrics = map.get(id);
				
				if(metrics == null) {
				/*	metrics.setState( 	
							
										rs.getInt("id_metrics"),
										rs.getInt("rooms_quantity"),
										rs.getInt("users_quantity"), 
										rs.getDate("last_message"), 
										rs.getDate("first_login"), 
										metrics.getLongestMessage().setId(rs.getInt("longest_message")), 
										metrics.getMostActiveUser().setIdUser(rs.getInt("most_active_user")), 
										rs.getInt("most_active_user_message_amount"), 
										metrics.getLastRoomCreated().setIdRoom(rs.getInt("last_room_created")), 
										metrics.getMostActiveRoom().setIdRoom(rs.getInt("most_active_room")), 
										rs.getInt("most_active_room_message_amount"), 
										rs.getDouble("users_promedy_by_room")
									
									);
					
					*/
					map.put(id, metrics);
					
				}//if
			}//while
			return new ArrayList<Metrics>(map.values());
		}
		
	}
}
