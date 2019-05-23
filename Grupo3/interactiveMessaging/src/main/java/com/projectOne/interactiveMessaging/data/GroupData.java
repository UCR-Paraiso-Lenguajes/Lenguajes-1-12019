package com.projectOne.interactiveMessaging.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Room;

@Repository
public class GroupData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserData userData;

	@Transactional(readOnly = true)
	public String getNameGroupTableMessages(int idGroup) {
		String nameTable = "";
		String selectMysql;
		selectMysql = "SELECT `RoomApp`.`nameMessageTable` " + "FROM `IF4100_Proyecto_JAJME`.`RoomApp` "
				+ "WHERE id = ?;";
		nameTable = jdbcTemplate
				.query(selectMysql, new Object[] { idGroup }, (rs, row) -> new String(rs.getString("nameMessageTable")))
				.get(0);

		return nameTable;
	}

	public List<Room> getGroupsOfUser(int idUserRoom) {
		List<Room> listOfRooms = new ArrayList<>();
		Iterator<Integer> idGroupsOfUsr = userData.getIdGroupsOfUsr(idUserRoom);
		while (idGroupsOfUsr.hasNext()) {
			listOfRooms.add(getSpecificGroup(idGroupsOfUsr.next()));
		}
		return listOfRooms;
	}

	@Transactional(readOnly = true)
	public Room getSpecificGroup(int idGroup) {
		String nameTable = "";
		String selectMysql;
		List<Room> listOfRooms = new ArrayList<>();
		selectMysql = "SELECT `RoomApp`.`id`, " + "`RoomApp`.`descripcion`, " + "`RoomApp`.`dateCreated`, "
				+ "`RoomApp`.`nameMessageTable` " + "FROM `IF4100_Proyecto_JAJME`.`RoomApp` " + "WHERE id = ?;";
		jdbcTemplate.query(selectMysql, new Object[] { idGroup },
				(rs, row) -> new Room(rs.getInt("id"),rs.getString("descripcion"),rs.getTimestamp("dateCreated"))).forEach(entry -> listOfRooms.add(entry));
		Timestamp temp = listOfRooms.get(0).getDateCreate();
		temp.setHours(listOfRooms.get(0).getDateCreate().getHours()+1);
		listOfRooms.get(0).setDateCreate(temp);
		return listOfRooms.get(0);
	}
}
