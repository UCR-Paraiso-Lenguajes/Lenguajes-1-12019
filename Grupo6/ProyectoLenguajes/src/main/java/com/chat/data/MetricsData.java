package com.chat.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;

@Repository
public class MetricsData {
	@Autowired
	private ChatRoomData chatRoomData;

	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public int getQuantityRooms() throws SQLException {

		String sqlSelect = "SELECT count(*) from chat_db.room";

		PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
		ResultSet result = ps.executeQuery();

		int total = 0;
		while (result.next()) {
			total = result.getInt(1);
		}

		dataSource.getConnection().close();

		return total;
	}

	@Transactional(readOnly = true)
	public int quantityUsers() throws SQLException {

		String sqlSelect = "select count(*) from user_client;";

		PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
		ResultSet result = ps.executeQuery();

		int total = 0;
		while (result.next()) {
			total = result.getInt(1);
		}

		dataSource.getConnection().close();

		return total;
	}

	@Transactional(readOnly = true)
	public String lastGroupCreated() throws SQLException {

		String sqlSelect = "SELECT *\r\n" + "FROM chat_db.room\r\n" + "ORDER BY room_id desc\r\n" + "LIMIT 1;";

		PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
		ResultSet result = ps.executeQuery();

		String total = "";
		while (result.next()) {
			total = result.getString(2);
		}

		dataSource.getConnection().close();
		System.out.println(total);

		return total;
	}

	@Transactional(readOnly = true)
	public String firtsLogin() throws SQLException {

		String sqlSelect = "SELECT *\r\n" + "FROM chat_db.user_client\r\n" + "ORDER BY id asc\r\n" + "LIMIT 1;";

		PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
		ResultSet result = ps.executeQuery();

		String total = "";
		while (result.next()) {
			total = result.getString(2);
		}

		dataSource.getConnection().close();

		return total;
	}

	
	
	 
	@Transactional(readOnly=true)
	public String getGroupMoreMessage() throws SQLException {

		String nameGroup = "";

		int roomMembers = 0;
		
		ArrayList<ChatRoom> rooms =  chatRoomData.getRooms();
		
		for (int i = 0; i < rooms.size(); i++) {
			
			String roomName = rooms.get(i).getName().toString();
			
			String sqlSelect = "Select count(message_id) AS numberMessages from messages_" + roomName ;
			
			PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
	        ResultSet result = ps.executeQuery();
	        
	        while (result.next()) {
	        	
	        	int numberMessages = result.getInt("numberMessages");
	        	
	        	if(numberMessages >= roomMembers) {
	        		
	        		roomMembers = numberMessages;
	        		
	        		nameGroup = roomName + "=" + numberMessages+ " msg";
	        	
	        	}
	        }
			
		}

		dataSource.getConnection().close();

		return nameGroup;
	}

	@Transactional(readOnly = true)
	public int getLongerMessage() throws SQLException {

		int longerMeesage = 0;

		ArrayList<ChatRoom> rooms = chatRoomData.getRooms();

		for (int i = 0; i < rooms.size(); i++) {

			String roomName = rooms.get(i).getName().toString();

			String sqlSelect = "Select message_description from messages_" + roomName;

			PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				String message = result.getString("message_description");

				int extension = message.length();

				if (extension >= longerMeesage) {

					longerMeesage = message.length();

				}
			}

		}

		dataSource.getConnection().close();

		return longerMeesage;
	}

	@Transactional(readOnly = true)
	public String dateLastMessage() throws SQLException {
		boolean first = true;
		long valueTime = 0;
		String dateLastMessage = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dateSystem = new Date();

		ArrayList<ChatRoom> rooms = chatRoomData.getRooms();

		for (int i = 0; i < rooms.size(); i++) {

			String roomName = rooms.get(i).getName().toString();

			String sqlSelect = "Select message_date from messages_" + roomName;

			PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				Date dateMessage = result.getDate("message_date");

				long valor = (Long) (dateMessage.getTime() - dateSystem.getTime());

				if (first == true) {
					valueTime = valor;

					first = false;

				} else if (first == false) {

					if (valor <= valueTime) {

						valueTime = valor;

						dateLastMessage = "" + dateMessage;
					}
				}

			}

		}
		return dateLastMessage;
	}
	@Transactional(readOnly=true)
	public int getUsersAverageRooms() throws SQLException
	{

		String sqlSelect = "Select room_id from room";
		
		PreparedStatement ps = dataSource.getConnection().prepareStatement(sqlSelect);
        ResultSet result = ps.executeQuery();
		
        int roomMembers =0;
        int count = 1;
        while (result.next()) {
            int room_id = result.getInt("room_id");
            
            String sqlSelectRoomMembers = "Select count(us.id) as roomMembers,room_id from user_client,room " + 
            		"INNER JOIN user_client us ON room.room_id=us.id " + 
            		"where room_id="+room_id;
            
            PreparedStatement psRoomMembers = dataSource.getConnection().prepareStatement(sqlSelectRoomMembers);
            ResultSet resultRoomMembers = psRoomMembers.executeQuery();
            int res=resultRoomMembers.getInt(1);
            roomMembers +=res;
            
            count++;
        }
        
        int prom = roomMembers/count;
        
        dataSource.getConnection().close();
        
		return prom;
	}
}
