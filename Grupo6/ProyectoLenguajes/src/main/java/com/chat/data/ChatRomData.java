package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
import com.chat.domain.Rol;
import com.chat.domain.User;
import com.chat.domain.form.ChatRoomForm;

@Repository
public class ChatRomData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

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
			statementInsert.setInt(3, chatRoom.getUser_creator().getId());
			// statementInsert.setObject(4, charRoom.getUserList());
			statementInsert.executeUpdate();
			String sqlmessages = "CREATE TABLE messages_" + chatRoom.getName() + " (" + "message_id INT "
					+ "message_description NVARCHAR(50) " + "message_date NVARCHAR(50)" + "id_sending_user INT "
					+ "receiver INT " + ")";
			PreparedStatement statementMessages = conexion.prepareStatement(sqlmessages);
			statementMessages.executeUpdate(sqlmessages);
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

	@Autowired(required = false)
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
			//List<User> listaUser = chatRoom.getListaChat();
			
			statementInsertUserByChat.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional(readOnly = true)
	public ConcurrentHashMap<Integer, Message> getMessages(int begin, int end, ChatRoom room) {
		ConcurrentHashMap<Integer, Message> messages = new ConcurrentHashMap<>();
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
				messages.put(messages.size(), message);
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return messages;
		/*jdbcTemplate
				.query(selectSql, new Object[] { begin, end },
						(rs, row) -> new Message(rs.getInt("message_id"), rs.getString("message_description"),
								rs.getString("message_date"), rs.getInt("id_sending_user")))
				.forEach(entry -> messages.put("", entry));
				//.forEach(entry -> messages.add(entry));*/
	}
	
	@Transactional(readOnly = true)
	public Iterator<ChatRoom> getRooms() {
		List<ChatRoom> rooms = new ArrayList<>();
		String sql = "SELECT room_id, room_name, version, room_user_creator "
				+ "FROM room";
		jdbcTemplate.query(sql, (rs, row) -> new ChatRoom(rs.getInt("room_id"), 
				rs.getString("room_name"), 
				rs.getInt("version"), 
				rs.getInt("room_user_creator")))
		.forEach(entry -> rooms.add(entry));
		return rooms.iterator();
	}
}