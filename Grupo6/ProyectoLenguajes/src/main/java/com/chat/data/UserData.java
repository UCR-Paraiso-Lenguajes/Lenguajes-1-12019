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

import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;
import com.chat.domain.form.UserForm;


@Repository
public class UserData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public int addUserClient(UserClient user) {
		
		String sqlInsertUser = "Insert into user_client(email) values (?)";	
		
		Connection conexion = null;
		
		try {
		
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
			
		PreparedStatement statementInsertUser = conexion.prepareStatement(sqlInsertUser, Statement.RETURN_GENERATED_KEYS);
		
		statementInsertUser.setInt(1, user.getId());
	    
		int filas = statementInsertUser.executeUpdate();
		
		conexion.commit();
		
		if (filas == 0) {
            throw new SQLException("Inserción de Usuario fallida.");
        }

        try (ResultSet generatedKeys = statementInsertUser.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            	user.setId(generatedKeys.getInt(1));
            	
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
		
		return user.getId();
	    }
	
	public void update(int id, UserAdmin user) 
	{
		String sqlSelect = "UPDATE user_client SET password = '"+
	user.getPassword()
		+"' where id = "+id;
		jdbcTemplate.batchUpdate(sqlSelect);
	}	


}
