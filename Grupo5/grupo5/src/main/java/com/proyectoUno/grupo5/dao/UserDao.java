package com.proyectoUno.grupo5.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.proyectoUno.grupo5.business.UserBusiness;
import com.proyectoUno.grupo5.domain.Room;
import com.proyectoUno.grupo5.domain.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private NotificationService notificationService;

	public Boolean insertUser(User user) {
		String query = "insert into user(email, hash) values(?,?)";

		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getHash());

				return ps.execute();

			}
		});
	}

	public Boolean invitar(String emails) throws SQLException {

		String[] invitados = emails.split(",");
		List<User> users = getIdUser();
		int idUser = users.get(0).getIdUser() + 1;


		

			Connection connection = dataSource.getConnection();
			String sqlInsert = "insert into user(email, hash) values(?,?)";
			
			for (int i = 0; i < invitados.length; i++) {
				
			CallableStatement statement = connection.prepareCall(sqlInsert);
			statement.setString(1, invitados[i]);
			statement.setString(2, "localhost:8080/msn/?idUser=" + idUser);
    		notificationService.sendNotification(invitados[i], "localhost:8080/msn/?idUser=" + idUser);

			statement.execute();
			
		}
		
			connection.close();

		return true;
	}

	public List<User> getIdUser() {

		String queryGetId = "SELECT MAX(id_user) as id_user, email FROM user;";
		return jdbcTemplate.query(queryGetId, new UserWithExtractorMax());

	}

	class UserWithExtractor implements ResultSetExtractor<List<User>> {

		@Override
		public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

			Map<Integer, User> map = new HashMap<>();
			User user = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_user");
				user = map.get(id);
				if (user == null) {
					user = new User();
					user.setIdUser(id);
					user.setEmail(rs.getString("email"));
					user.setHash(rs.getString("hash"));
					map.put(id, user);

				}

			}
			return new ArrayList<User>(map.values());
		}
	}

	class UserWithExtractorMax implements ResultSetExtractor<List<User>> {

		@Override
		public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

			Map<Integer, User> map = new HashMap<>();
			User user = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_user");
				user = map.get(id);
				if (user == null) {
					user = new User();
					user.setIdUser(id);
					map.put(id, user);

				}

			}
			return new ArrayList<User>(map.values());
		}

	}

	public List<User> getUsers(int id_room) {
		String queryGetId = "select ur.id_user,user.email from user_room as ur join user where ur.id_room=" + id_room
				+ " && ur.id_user=user.id_user";
		return jdbcTemplate.query(queryGetId, new UserRoomExtractor());
	}

	class UserRoomExtractor implements ResultSetExtractor<List<User>> {

		@Override
		public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

			Map<Integer, User> map = new HashMap<>();
			User user = null;
			while (rs.next()) {
				Integer id = rs.getInt("id_user");
				user = map.get(id);
				if (user == null) {
					user = new User();
					user.setIdUser(id);
					user.setEmail(rs.getString("email"));
					map.put(id, user);

				}

			}
			return new ArrayList<User>(map.values());
		}

	}

}
