package com.chat.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
import com.chat.domain.Rol;
import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;

@Repository
public class ChatRomData {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void add(ChatRoom chatRoom) {
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsert = "Insert into Room (room_name,version,room_user_creator) values (?,?,?)";
			PreparedStatement statementInsert = conexion.prepareStatement(sqlInsert);
			statementInsert.setString(1, chatRoom.getName());
			statementInsert.setInt(2, chatRoom.getVersion());
			//TODO CREADOR QUEMADO
			statementInsert.setInt(3, 1);
			// statementInsert.setObject(4, charRoom.getUserList());
			statementInsert.executeUpdate();
			String sqlmessages = "CREATE TABLE messages_" + chatRoom.getName() + " (" + "message_id INT, "
					+ "message_description NVARCHAR(50), " + "message_date NVARCHAR(50)," + "id_sending_user INT, "
					+ "receiver INT " + ") ENGINE = ARCHIVE;";
			PreparedStatement statementMessages = conexion.prepareStatement(sqlmessages);
			statementMessages.executeUpdate(sqlmessages);
			/*String alter = "ALTER TABLE message_" + chatRoom.getName() + " ENGINE = ARCHIVE ;" ;
			PreparedStatement alterStatement = conexion.prepareStatement(alter);
			alterStatement.executeUpdate();*/
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	//@Autowired(required = false)
	@Transactional
	public void addUserByChatRoom(int idChatRoom, int idUser, int idRol) throws SQLException {

		Connection conexion = null;
		try {
			String sqlInsertUserByChatRoom = "Insert into Room_User(ir_room, id_user, id_role) values (?,?,?)";
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			PreparedStatement statementInsertUserByChat = conexion.prepareStatement(sqlInsertUserByChatRoom);
			statementInsertUserByChat.setInt(1, idChatRoom);
			statementInsertUserByChat.setInt(2, idUser);
			statementInsertUserByChat.setInt(3, idRol);
			statementInsertUserByChat.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional(readOnly = true)
	public List<UserAdmin> getUsers(ChatRoom room) {
		List<UserAdmin> users = Collections.synchronizedList(new ArrayList<UserAdmin>());
		String selectSql = "SELECT u.user_id, u.user_name, u.user_email, u.user_password, "
				+ "r.role_id, r.role_name "
				+ "FROM user u JOIN room_user ru ON u.user_id = id_user "
				+ "JOIN role r ON r.role_id = ru.id_role "
				+ "WHERE ru.id_room = ? ";
		Connection conexion = null;
		ResultSet rs = null;
		try{
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(selectSql);
			statement.setInt(1, room.getId());
			rs = statement.executeQuery();
			while(rs.next()) {
				UserAdmin user = new UserAdmin();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				Rol rol = new Rol();
				rol.setId(rs.getInt("role_id"));
				rol.setName(rs.getString("role_name"));
				user.setRol(rol);
				users.add(user);
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return users;
	}

	@Transactional(readOnly = true)
	public List<Message> getMessages(int begin, int end, ChatRoom room) {
		List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());
		String selectSql = "SELECT message_id, message_description, message_date, id_sending_user "
				+ "FROM messages_"+room.getName()+" g "
				+ "WHERE message_id > ? AND message_id < ? "
				+ "ORDER BY message_id ASC";

		Connection conexion = null;
		ResultSet rs = null;
		try{
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(selectSql);
			statement.setInt(1, begin);
			statement.setInt(2, end);
			rs = statement.executeQuery();
			while(rs.next()) {
				Message message = new Message(
						rs.getInt("message_id"),
						rs.getString("message_description"),
						rs.getString("message_date"),
						rs.getInt("id_sending_user"));
				messages.add(message);
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return messages;
	}

	@Transactional(readOnly = true)
	public ArrayList<ChatRoom> getRooms() {
		String sql = "SELECT r.room_id, r.room_name, r.version, r.room_user_creator, "
				+ "ua.user_id, ua.user_name, ua.user_id "
				+ "FROM room r left join room_user ru on r.room_id = ru.id_room left join user_admin ua ON ru.id_user = ua.user_id;";
		return jdbcTemplate.query(sql, new RoomsWithMessagesAndUsersExtractor());
	}
}

class RoomsWithMessagesAndUsersExtractor implements ResultSetExtractor<ArrayList<ChatRoom>> {

	@Override
	public ArrayList<ChatRoom> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<Integer, ChatRoom> map = new HashMap<Integer, ChatRoom>();
		ChatRoom room = null;
		while(rs.next()) {
			Integer id = rs.getInt("room_id");
			room = map.get(id);
			if(room == null) { //new record
				room = new ChatRoom();
				room.setId(rs.getInt("room_id"));
				room.setName(rs.getString("room_name"));
				room.setVersion(rs.getInt("version"));
				UserAdmin user = new UserAdmin();
				user.setId(rs.getInt("room_user_creator"));
				room.setUser_creator(user);
				map.put(id, room);
			}
			int userId = rs.getInt("user_id");
			if(userId > 0) {
				UserClient user = new UserClient();
				user.setId(userId);
				user.setName(rs.getString("user_name"));
				room.getListUsers().add(user);
			}
		}
		return new ArrayList<ChatRoom>(map.values());
	}
}
