package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.User;
import com.chat.domain.form.UserForm;

@Repository
public class UserData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	@Transactional
	public void addUser(UserForm user) throws SQLException {
		Connection conexion = null;
		try {
			String sqlInsertUser = "Insert into User(password) values (?)";
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			PreparedStatement statementInsertUser = conexion.prepareStatement(sqlInsertUser);
			statementInsertUser.setString(1, user.getPassword());
			statementInsertUser.executeUpdate();
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

	public void update(int id, User user) {
		String sqlSelect = "UPDATE User SET password = '" + user.getPassword() + "' where id = " + id;
		jdbcTemplate.batchUpdate(sqlSelect);
	}

}
