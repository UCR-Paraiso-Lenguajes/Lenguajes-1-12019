package com.projectOne.interactiveMessaging.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Role;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;

@Repository
public class UserData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<User> userList = new ArrayList<>();
	private ArrayList<Role> rolesUser = new ArrayList<>();
	//@Transactional(readOnly = true)
	public Iterator<User> findUsersCertainRoom(int roomID) {// Trae los usuarios de un grupo en especifico con sus
															// debidos roles en el grupo

		String selectMysql;
		List<User> userListTemp = new ArrayList<>();
		selectMysql = "SELECT u.id, u.correo, u.numberMessages " + "FROM UserApp u " + "inner join UserRoleRoom urr "
				+ "ON u.id = urr.idUser " + "WHERE urr.idRoomUR = ? " + "group by urr.idUser " + "order by u.id ASC";
		jdbcTemplate
				.query(selectMysql, new Object[] { roomID },
						(rs, row) -> new User(rs.getInt("id"), rs.getString("correo"), rs.getInt("numberMessages")))
				.forEach(entry -> userListTemp.add(entry));

		for (int i = 0; i < userListTemp.size(); i++) {
			rolesUser = new ArrayList<>();
			selectMysql = "SELECT r.id,r.descripcion " + "FROM RoleApp r " + "inner join UserRoleRoom urr "
					+ "ON r.id = urr.idRole " + "WHERE urr.idUser = ? " + "AND urr.idRoomUR = ?";
			jdbcTemplate
					.query(selectMysql, new Object[] { userListTemp.get(i).getUser_id(), roomID },
							(rs, row) -> new Role(rs.getInt("id"), rs.getString("descripcion")))
					.forEach(entry -> rolesUser.add(entry));
			User temp = userListTemp.get(i);
			temp.setRoles(rolesUser);
			userList.add(temp);
		}

		return userList.iterator();
	}

	public Iterator<Integer> getIdGroupsOfUsr(int idUser) {//Me trae todos los id de los grupos donde el usuario esta
		String selectMysql;
		List<Integer> idGroupsOfUsr = new ArrayList<>();

		selectMysql = "SELECT idRoomUR " + "FROM UserRoleRoom " + "WHERE idUser = ? " + "GROUP BY idRoomUR "
				+ "ORDER BY idRoomUR";
		jdbcTemplate.query(selectMysql, new Object[] { idUser }, (rs, row) -> new Integer(rs.getInt("idRoomUR")))
				.forEach(entry -> idGroupsOfUsr.add(entry));
		return idGroupsOfUsr.iterator();
	}
	
	//@Transactional
	public Iterator<User> findUsersOwnerOrAdmin(int idRoom, int idRole){
		ArrayList<User> listOfUserOwnerOrAdmin = new ArrayList<User>();
		String selectMySqlOwner = "select u.correo from UserApp u inner join UserRoleRoom usr on u.id=usr.idUser inner join RoomApp ro on usr.idRoomUR=ro.id inner " + 
				" join RoleApp rol on usr.idRole=rol.id where ro.id = ? and rol.id = ?";
		jdbcTemplate.query(selectMySqlOwner, new Object[] {idRoom, idRole}, (rs, row) -> new User(rs.getInt("id"), rs.getString("correo"), rs.getInt("numberMessages")))
			.forEach(entry -> listOfUserOwnerOrAdmin.add(entry));
		return listOfUserOwnerOrAdmin.iterator();
	}
	//@Transactional(readOnly = true)
	public User getSpecificUserById(int idUser) {
		List<User> listOfUser = new ArrayList<>();
		String selectMysql = "SELECT id,correo, numberMessages " + "FROM UserApp "
				+ "WHERE id = ?";
		jdbcTemplate.query(selectMysql, new Object[] { idUser },
				(rs, row) -> new User(rs.getInt("id"),rs.getString("correo"),rs.getInt("numberMessages")))
		.forEach(entry -> listOfUser.add(entry));
		return listOfUser.get(0);
	}
	
	@Transactional(readOnly = true)
	public Iterator<User> findAllTheUsers() {

		String selectMysql;
		List<User> userListTemp = new ArrayList<>();
		selectMysql = "SELECT u.id, u.correo, u.numberMessages " + "FROM UserApp u ";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new User(rs.getInt("id"), rs.getString("correo"), rs.getInt("numberMessages"))).iterator();
	}

}
