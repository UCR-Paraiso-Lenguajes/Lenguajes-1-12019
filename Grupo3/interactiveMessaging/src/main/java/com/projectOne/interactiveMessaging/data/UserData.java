package com.projectOne.interactiveMessaging.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projectOne.interactiveMessaging.domain.Role;
import com.projectOne.interactiveMessaging.domain.User;

@Repository
public class UserData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<User> userList = new ArrayList<>();
	private ArrayList<Role> rolesUser = new ArrayList<>();
	public Iterator<User> findUsersCertainRoom(int roomID) {// Trae los usuarios de un grupo en especifico con sus debidos roles en el grupo

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
			.query(selectMysql, new Object[] { userListTemp.get(i).getUser_id(),roomID },
					(rs, row) -> new Role(rs.getInt("id"), rs.getString("descripcion")))
			.forEach(entry -> rolesUser.add(entry));
			User temp = userListTemp.get(i);
			temp.setRoles(rolesUser);
			userList.add(temp);
		}

		return userList.iterator();
	}
}
