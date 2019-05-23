package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.Rol;
import com.chat.domain.User;
import com.chat.domain.form.ChatRoomForm;

@Repository
public class RolData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public void addRol(Rol rol) {
		
		System.out.println(rol.toString());
		
		String sqlInsertRol = "Insert into Rol(id,name) values (?,?)";	
		
		Connection conexion = null;

		
		try {
			
		conexion = dataSource.getConnection();
		conexion.setAutoCommit(false);
	
		PreparedStatement statementInsertRol = conexion.prepareStatement(sqlInsertRol, Statement.RETURN_GENERATED_KEYS);
		
	    statementInsertRol.setString(1, rol.getName());
	    
		int filas = statementInsertRol.executeUpdate();
		
		conexion.commit();
		
		if (filas == 0) {
            throw new SQLException("Inserción de Rol fallida.");
        }

        try (ResultSet generatedKeys = statementInsertRol.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            	rol.setId(generatedKeys.getInt(1)); 
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

	
}
