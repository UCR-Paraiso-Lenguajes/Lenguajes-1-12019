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

import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Grupo;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;



@Repository
public class GrupoData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  SimpleJdbcCall simpleJdbcCall;
	private DataSource dataSource;
	@Autowired
	public  void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.simpleJdbcCall=new	SimpleJdbcCall( dataSource);
	}
	@Transactional(readOnly=true)
	public void save(Grupo grupo) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			
			  if (grupo.getListaMensajes().isEmpty()==true) {
			  crearTablaMensajes(grupo.getNombre());
			  }
			 
			String sqlInsertrol = "INSERT INTO GRUPO(nombre,numeroParticipantes,idOwner,idAdmin) VALUES(?,?,?,?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1, grupo.getNombre());
			statementrol.setInt(2, grupo.getNumeroParticipantes());
			statementrol.setInt(3, grupo.getDueno().getId());
			statementrol.setInt(3, grupo.getAdministrador().getId());
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
	public void crearTablaMensajes(String nombreGrupo) {
		String sql = "create table MENSAJE"+nombreGrupo+"(id integer PRIMARY KEY AUTO_INCREMENT,"
				+ " idGrupo integer, contenido varchar(50), version integer, idUsuario integer);";
 		jdbcTemplate.batchUpdate(sql);
	}
	
	@Transactional(readOnly=true)
	public void delete(Grupo grupo) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "DELETE FROM GRUPO WHERE id=(?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setInt(1, grupo.getId());
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
	public void update(Grupo grupo) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "UPDATE GRUPO SET nombre=(?),"
					+ "numeroParticipantes=(?),cantidadMensajes=(?)  WHERE id=(?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setString(1, grupo.getNombre());
			statementrol.setInt(2, grupo.getNumeroParticipantes());
			statementrol.setInt(3, grupo.getCantidadMensajes());
			statementrol.setInt(4, grupo.getId());

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
	public ArrayList<Mensaje> buscarMensajes(){
		
		String sqlSelect="select id,version,contenido from MENSAJE" ;
		return (ArrayList<Mensaje>) jdbcTemplate.query(sqlSelect, new MensajeWithGrupoExtractor());
	}
	
	
}

class MensajeWithGrupoExtractor implements ResultSetExtractor<List<Mensaje>>{

	@Override
	public List<Mensaje> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Mensaje> list = new LinkedList<>();
		Mensaje mensaje = null;
		while(rs.next()) {
			Integer idMensajeActual = rs.getInt("id");
				mensaje = new Mensaje();
				mensaje.setId(idMensajeActual);
				mensaje.setVersion(rs.getInt("version"));
				mensaje.setContenido(rs.getString("contenido"));
				list.add(mensaje);
			}
		
		
		return list;
	}
}

