                              package com.lenguajes.ucrmsn.ucr.live.messenger.data;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Usuario;

@Repository
public class UsuarioData {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly=true)
	public void save(Usuario usuario) {
		Connection conexion = null; 
		try {
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "INSERT INTO USUARIO(codigoHash,cantidadMensajes) VALUES(?,?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1,usuario.getHash());
			statementrol.setInt(2,usuario.getCantidadMensajes());

			statementrol.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e3) {
					throw new RuntimeException(e3);
				}
			}
		}
	}
	@Transactional(readOnly=true)
	public void eliminar(Usuario usuario) {
		Connection conexion = null; 
		try {
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "DELETE FROM USUARIO WHERE codigoHash=(?), cantidadUsuario=(?) ";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1,usuario.getHash());
			statementrol.setInt(2,usuario.getCantidadMensajes());

			statementrol.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e3) {
					throw new RuntimeException(e3);
				}
			}
		}
	}
	@Transactional(readOnly=true)
	public void updateCantidadUsuarios(Usuario usuario) {
		Connection conexion = null; 
		try {
			
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "UPDATE USUARIO WHERE codigoHash=(?) SET cantidadUsuario=(?) ";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1,usuario.getHash());
			statementrol.setInt(2,usuario.getCantidadMensajes());

			statementrol.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}finally {
			if(conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e3) {
					throw new RuntimeException(e3);
				}
			}
		}
	}
	@Transactional(readOnly=true)
	public ArrayList<Usuario> listarUsuarios(){
		
		String sqlSelect="select id,codigoHash,cantidadMensajes from USUARIO" ;
		return (ArrayList<Usuario>) jdbcTemplate.query(sqlSelect, new UsuarioExtractor());
	}
	class UsuarioExtractor implements ResultSetExtractor<List<Usuario>>{

		@Override
		public List<Usuario> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Usuario> list = new ArrayList<>();
			Usuario usuario = null;
			while(rs.next()) {
				Integer idUsuarioActual = rs.getInt("id");
					usuario = new Usuario();
					usuario.setId(idUsuarioActual);
					usuario.setHash(rs.getString("codigoHash"));
					usuario.setCantidadMensajes(rs.getInt("cantidadMensajes"));

					list.add(usuario);
				}
			
			
			return list;
		}
	}
}

