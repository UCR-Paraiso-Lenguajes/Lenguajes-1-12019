package cr.ac.ucr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import cr.ac.ucr.domain.Room;

@Repository
public class RoomData {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
		.withCatalogName("dbo")
		.withProcedureName("Create_Romm")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(new SqlOutParameter("@idRoom", Types.INTEGER))
		.declareParameters(new SqlParameter("@name", Types.VARCHAR))
		.declareParameters(new SqlParameter("@version", Types.INTEGER))
		.declareParameters(new SqlParameter("@idRoomAdministrator", Types.INTEGER))
		.declareParameters(new SqlParameter("@idRoomOwner", Types.INTEGER));
		
   }
	
	@Transactional
	
	public Room save(Room room) throws SQLException{
		String sqlSelect = "CREATE TABLE"+room.getName()+"("+"id_room int,"+"id_room_administrator int,"+"id_room_owner int,"+"version int,"
	    +"PRIMARY KEY id_room,"+"FOREIGN KEY(id_room_administrator) REFERENCES User(user_id),"
		+"FOREIGN KEY(id_room_owner) REFERENCES User(user_id),";
		
		String sqlSelect1 = "INSERT INTO"+room.getName()+"(id_room,id_room_administrator,id_room_owner,version) values("
		+room.getIdRoom()+","+room.getRoomAdministrator().getIdUser()+","+room.getRoomOwner().getIdUser()+","+room.getVersion()+")";
	
		
		return room;
		
	}
	
@Transactional(readOnly=true)
	
	public List<Room> encontrarRooms() {
		String sqlSelect = "SELECT r.nombre"
				+ " FROM Room r";
		return jdbcTemplate.query(sqlSelect, new ListaRooms());
	}
}

class ListaRooms implements ResultSetExtractor<List<Room>> {
	@Override
	public List<Room> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Room> map = new HashMap<Integer, Room>();
		Room room = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_room");
			room = map.get(id);
			if (room == null) { 
				room = new Room();
				room.setIdRoom(id);
				room.setName(rs.getString("name"));
			} 
		} // while
		return new ArrayList<Room>(map.values());
	} // extractData
	
	
	
}
