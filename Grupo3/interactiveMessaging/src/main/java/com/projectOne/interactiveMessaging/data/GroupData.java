package com.projectOne.interactiveMessaging.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;

@Repository
public class GroupData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserData userData;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	//@Transactional(readOnly = true)
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

	//@Transactional(readOnly = true)
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
	@Transactional
	public void saveUserRoleRoom(int idUser, int idRole, int idRoom) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			int idUserAux = 0,idRoleAux=0,idRoomAux=0;
			
			String sqlExistRegs = "select idUser,idRole,idRoomUR from UserRoleRoom where idUser="+idUser+" and idRole="+idRole+" and idRoomUR="+idRoom;
		    Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery(sqlExistRegs);
		    while(rs.next()) {
		    	idUserAux = rs.getInt("idUser");
		    	idRoleAux = rs.getInt("idRole");
		    	idRoomAux = rs.getInt("idRoomUR");
		    }
		    if(idUser!=idUserAux && idRole!=idRoleAux && idRoom!=idRoomAux) {
			
				String sqlSaveGroup = "insert into UserRoleRoom values(?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sqlSaveGroup);
				stmt.setInt(1, idUser);
				stmt.setInt(2, idRole);
				stmt.setInt(3, idRoom);
				stmt.execute();
				
				connection.commit();
		    }
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	@Transactional
	public void saveGroup(String nameGroup) {
		//select id from RoomApp order by id desc limit 1
		//insert into RoomApp values(5,'Los Patitos',now(),'LosPatitosMessages')
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			Room group = new Room(0, "", null);
			int latestIdRoom=0;
			

			String sqlId = "select id from RoomApp order by id desc limit 1";
		    Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery(sqlId);
		    while(rs.next())
		    	latestIdRoom = rs.getInt("id");


		
			int idNewGroup=latestIdRoom+1;
			String sqlSaveGroup = "insert into RoomApp values(?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sqlSaveGroup);
			stmt.setInt(1, idNewGroup);
			stmt.setString(2, nameGroup);
			stmt.setTimestamp(3, timestamp);
			stmt.setString(4, nameGroup+"Messages");
			stmt.execute();
			
			connection.commit();
			return idNewGroup;
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	//@Transactional(readOnly = true)
	public Iterator<Room> getGroups() {
		String nameTable = "";
		String selectMysql;
		List<Room> listOfRooms = new ArrayList<>();
		selectMysql = "SELECT `RoomApp`.`id`, " + "`RoomApp`.`descripcion`, " + "`RoomApp`.`dateCreated`, "
				+ "`RoomApp`.`nameMessageTable` " + "FROM `IF4100_Proyecto_JAJME`.`RoomApp`;" ;
		jdbcTemplate.query(selectMysql, new Object[] { },
				(rs, row) -> new Room(rs.getInt("id"),rs.getString("descripcion"),rs.getTimestamp("dateCreated"))).forEach(entry -> listOfRooms.add(entry));
		Timestamp temp = listOfRooms.get(0).getDateCreate();
		temp.setHours(listOfRooms.get(0).getDateCreate().getHours()+1);
		listOfRooms.get(0).setDateCreate(temp);
		return listOfRooms.iterator();
	}
	
}
