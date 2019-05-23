package com.projectOne.interactiveMessaging.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Role;
import com.projectOne.interactiveMessaging.domain.User;

@Repository
public class MessageData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//Este metodo me trae los mensajes por rango
	@Transactional(readOnly = true)
	public Iterator<Message> getMessagesByRange(int inicio, int fin, Iterator<User> userList, String nameMessageTableGroup) {
		List<Message> messagesTemp = new ArrayList<>();
		List<Message> messages = new ArrayList<>();
		List<Integer> messagesUserId = new ArrayList<>();
		String selectMysql;
		selectMysql = "SELECT id,messageM,idUser,dateM,size " + "FROM "+nameMessageTableGroup+" "
				+ "WHERE id >= ? AND id <= ? " + "ORDER BY id";
		jdbcTemplate
				.query(selectMysql, new Object[] { inicio, fin }, (rs, row) -> new Message(rs.getInt("id"),
						rs.getString("messageM"), rs.getTimestamp("dateM"), rs.getInt("size")))
				.forEach(entry -> messagesTemp.add(entry));
		selectMysql = "SELECT idUser " + "FROM LosMagnificosMessages " + "WHERE id >= ? AND id <= ? " + "ORDER BY id";
		jdbcTemplate.query(selectMysql, new Object[] { inicio, fin }, (rs, row) -> new Integer(rs.getInt("idUser")))
				.forEach(entry -> messagesUserId.add(entry));
		ArrayList<User>userArray = convertIteratorToArray(userList);
		for (int i = 0; i < messagesTemp.size(); i++) {

			Message tempMessage = messagesTemp.get(i);
			User temp = getUser(messagesUserId.get(i), userArray);
			if (temp.getUser_id() != 0) {
				tempMessage.setUserTransmitter(temp);
				messages.add(tempMessage);
			}

		}

		return messages.iterator();
	}

	private User getUser(int idUser, ArrayList<User> userList) {
		for (int i = 0; i < userList.size(); i++) {
			User temp = userList.get(i);
			if (temp.getUser_id() == idUser) {
				return temp;
			}
		}
		return new User(0, "--", 0);
	}
	private ArrayList<User> convertIteratorToArray(Iterator<User> userList){
		ArrayList<User>array = new ArrayList<>();
		while (userList.hasNext()) {
			
			array.add(userList.next());
		}
		return array;
	}
	//
	public ArrayList<Message> convertIteratorToArrayMessage(Iterator<Message> userList){
		ArrayList<Message>array = new ArrayList<>();
		while (userList.hasNext()) {
			
			array.add(userList.next());
		}
		return array;
	}
}
