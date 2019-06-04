package com.lenguajes.ucrmsn.ucr.live.messenger.data;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lenguajes.ucrmsn.ucr.live.messenger.data.UsuarioData.UsuarioExtractor;
import com.lenguajes.ucrmsn.ucr.live.messenger.domain.Mensaje;

@Repository
public class MensajeData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UsuarioData usuarioData;
	@Transactional(readOnly=true)
	public void nuevoMensaje(Mensaje mensaje) {
		Connection conexion = null; 
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsertrol = "INSERT INTO MENSAJE(idGrupo,contenido,version,idUsuario) VALUES(?,?,?,?)";
			PreparedStatement statementrol = conexion.prepareStatement(sqlInsertrol);
			statementrol.setInt(1,mensaje.getGrupo().getId());
			statementrol.setString(2,mensaje.getContenido());
			statementrol.setInt(3,mensaje.getVersion());
			statementrol.setInt(4,mensaje.getUsuario().getId());
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
	public ArrayList<Mensaje> listarMensajesPorGrupo(int idGrupo){
		
		String sqlSelect="select id,idGrupo,contenido,version,idUsuario from MENSAJE where idGrupo="+idGrupo ;
		return (ArrayList<Mensaje>) jdbcTemplate.query(sqlSelect, new MensajeExtractor());
	}
	
	class MensajeExtractor implements ResultSetExtractor<List<Mensaje>>{

		@Override
		public List<Mensaje> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Mensaje> list = new ArrayList<>();
			Mensaje mensaje = null;
			while(rs.next()) {
				Integer idMensajeActual = rs.getInt("id");
					mensaje = new Mensaje();
					mensaje.setId(idMensajeActual);
					mensaje.setGrupo(null);
					mensaje.setUsuario(usuarioData.getUsuarioporId((rs.getInt("id"))));
					mensaje.setContenido(rs.getString("contenido"));
					mensaje.setVersion(rs.getInt("version"));
					list.add(mensaje);
				}
			
			
			return list;
		}
	
	}
}
