package com.proyectoUno.grupo5.dao;

import com.proyectoUno.grupo5.dao.MessageDao.MessageWithExtractor;
import com.proyectoUno.grupo5.domain.Message;
import com.proyectoUno.grupo5.domain.Role;
import com.proyectoUno.grupo5.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	private List<Message> listMessages;
	private List<List> rooms;

	public Boolean insertRoom(Room room) {
		
		String query = "insert into room(room_name,version) values(?,?)";

		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, room.getRoomName());
				ps.setInt(2, room.getVersion());

				return ps.execute();

			}
		});

	}

	public List<Room> listRoomsForIdUser(int idUser) {

		String sqlSelect = "SELECT room.id_room, room.room_name, room.version from room JOIN user_room WHERE id_user="
				+ idUser + " group by id_room";

		;

		return jdbcTemplate.query(sqlSelect, new RoomWithExtractor());

	}

	public List<Room> listRooms() {

		String sqlSelect = "SELECT room.id_room, room.room_name, room.version from room ";

		return jdbcTemplate.query(sqlSelect, new RoomWithExtractor());

	}
	
	public Integer idRoom() {

		String sqlSelect = "select MAX(id_room) as id_room from room";

		return jdbcTemplate.query(sqlSelect, new RoomIDExtractor());

	}

	public void assignRoom(int id_user) {
		int id_room=idRoom();
		
		String query = "insert into user_room(id_user,id_room) values(?,"+id_room+")";

		 jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				

				return ps.execute();

			}
		});
		
	}
	

}

class RoomWithExtractor implements ResultSetExtractor<List<Room>> {

	@Override
	public List<Room> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Room> map = new HashMap<>();
		Room room = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_room");
			room = map.get(id);
			if (room == null) {
				room = new Room();
				room.setIdRoom(id);
				room.setRoomName(rs.getString("room_name"));
				room.setVersion(rs.getInt("version"));

				map.put(id, room);

			}

		}
		return new ArrayList<Room>(map.values());

	}
	
	


}

class RoomIDExtractor implements ResultSetExtractor<Integer> {

	@Override
	public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		
			Integer id = rs.getInt("id_room");
			
		
		return id;

	}
	
	


}
