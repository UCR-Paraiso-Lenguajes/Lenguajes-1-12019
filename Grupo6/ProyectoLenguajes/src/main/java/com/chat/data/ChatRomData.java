package com.chat.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;
import com.chat.domain.User;
import com.chat.domain.form.ChatRoomForm;

@Repository
public class ChatRomData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public void addBook(ChatRoomForm charRoom) throws SQLException {
		
		System.out.println(charRoom.toString());
		
		String sqlInsertBook = "Insert into Room(name,version,url) values (?,?,?)";	
		
		Connection conexion = null;
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
		
		try {
		PreparedStatement statementInsertBook = conexion.prepareStatement(sqlInsertBook, Statement.RETURN_GENERATED_KEYS);
		
	    statementInsertBook.setString(1, charRoom.getName());
	    statementInsertBook.setInt(2, charRoom.getVersion());
	    statementInsertBook.setString(3, charRoom.getUrl());
	  //  statementInsertBook.setObject(4, charRoom.getUserList());
	    
		int filas = statementInsertBook.executeUpdate();
		
		conexion.commit();
		
		if (filas == 0) {
            throw new SQLException("Inserción de ChatRoom fallida.");
        }

        try (ResultSet generatedKeys = statementInsertBook.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            	charRoom.setCodChat(generatedKeys.getInt(1));
            	
            	addUserByChatRoom(charRoom.getCodChat(),charRoom);
            	
            }
            else {
                throw new SQLException("No se tienen PK generadas.");
            }
        }
		}catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				}catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		  }
	    }
	

	@Autowired(required = false)
	public void addUserByChatRoom(int idChatRoom, ChatRoomForm chatRoom) throws SQLException {
		
		String sqlInsertUserByChatRoom = "Insert into Room_User(idChatRoom,idUser, idRole) values (?,?,?)";
		
		Connection conexion = null;
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
		try {
		
        PreparedStatement statementInsertUserByChat = conexion.prepareStatement(sqlInsertUserByChatRoom);
        List<User> listaUser = chatRoom.getListaChat();
        
        
		for (int i = 0; i < chatRoom.getListaChat().size(); i++) {
					
			int id_Role = Integer.parseInt(chatRoom.getListaChat().get(i).toString());
			int id_User = Integer.parseInt(listaUser.get(i).toString());
			System.out.println(id_User);
			statementInsertUserByChat.setInt(1, idChatRoom);
			statementInsertUserByChat.setInt(2, id_User);
			statementInsertUserByChat.setInt(2, id_Role);
			
			statementInsertUserByChat.addBatch();				
		}

		statementInsertUserByChat.executeBatch();
		
		conexion.commit();
	       }catch (SQLException e) {
				throw new RuntimeException(e);
	       }
		}
	
	@Transactional(readOnly = true)
	public Iterator<ChatRoom> findChatRoomByUser(int idUser) {
		String sqlSelect = "Select id,name,url,version,idUser " + "From ChatRoom " + "Where idUser ="
				+ idUser;

		return jdbcTemplate.query(sqlSelect, new ChatRoomExtractor());
	}
	
}

class ChatRoomExtractor implements ResultSetExtractor<Iterator<ChatRoom>> {
	@Override
	public Iterator<ChatRoom> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, ChatRoom> map = new HashMap<Integer, ChatRoom>();
		ChatRoom chatRoom = null;
		while (rs.next()) {
			Integer id = rs.getInt("id");
			chatRoom = map.get(id);
			if (chatRoom == null) {
				chatRoom = new ChatRoom();
				chatRoom.setId(id);;
				chatRoom.setName(rs.getString("name"));
				chatRoom.setUrl(rs.getString("url"));
				chatRoom.setVersion(rs.getInt("version"));
				map.put(id, chatRoom);
			}
		}
		return new ArrayList<ChatRoom>(map.values()).iterator();
	}
}
