package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.User;
import com.chat.domain.form.UserForm;


@Repository
public class UserData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public void addUser(UserForm user) {
		
		System.out.println(user.toString());
		
		String sqlInsertUser = "Insert into User(password) values (?)";	
		
		Connection conexion = null;
		
		try {
		
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
			
		PreparedStatement statementInsertUser = conexion.prepareStatement(sqlInsertUser, Statement.RETURN_GENERATED_KEYS);
		
		statementInsertUser.setString(1, user.getPassword());
	    
		int filas = statementInsertUser.executeUpdate();
		
		conexion.commit();
		
		if (filas == 0) {
            throw new SQLException("Inserción de Usuario fallida.");
        }

        try (ResultSet generatedKeys = statementInsertUser.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            	user.setCodUser(generatedKeys.getInt(1));
            	
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
	
	public void update(int id, User user) 
	{
		String sqlSelect = "UPDATE User SET password = '"+
	user.getPassword()
		+"' where id = "+id;
		jdbcTemplate.batchUpdate(sqlSelect);
	}	


}
