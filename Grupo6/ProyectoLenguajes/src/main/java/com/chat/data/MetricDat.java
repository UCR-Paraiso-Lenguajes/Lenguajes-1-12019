package com.chat.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;
import com.chat.domain.*;
import com.chat.data.*;
import com.chat.domain.UserClient;


@Repository
public class MetricDat {
	
	@Autowired
	private DataSource dataSource;

	@Transactional
	public void addQuantityRoom() {

		Connection conexion = null;
		try {
			String sqlInsertQuantityRoom = "Insert into Metric(quantity_room) values (?)";
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			PreparedStatement statementQuantityRoom = conexion.prepareStatement(sqlInsertQuantityRoom);
			//debe de ser el metric actualizado
			statementQuantityRoom.setInt(1, 8);

			statementQuantityRoom.executeUpdate();
			conexion.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
	public int getQuantityRooms() {

		Connection conexion = null;
		ResultSet rs = null;
		int quantityRooms=0;
		try{

			String selectSql = "SELECT room_id FROM Room";
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(selectSql);
			
			rs = statement.executeQuery();
			if (rs.last()) {
				quantityRooms = rs.getRow();
				 rs.beforeFirst();
			}
			
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		//System.out.println(quantityRooms);
		return quantityRooms;
	}

	@Transactional
	public int getQuantityUser() {

		Connection conexion = null;
		ResultSet rs = null;
		int quantityUsers=0;
		try{
			String selectSql = "SELECT id FROM user_client";
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(selectSql);
			
			rs = statement.executeQuery();
			if (rs.last()) {
				quantityUsers = rs.getRow();
				 rs.beforeFirst();
			}
			
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		//System.out.println(quantityUsers);
		return quantityUsers;
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Integer> getIdRoom() {
		ArrayList<Integer> idRooms = new ArrayList<Integer>();
		String sql = "SELECT id_room FROM room_user";
		Connection conexion = null;
		ResultSet rs = null;
		try{
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()) {
				idRooms.add(rs.getInt("id_room"));
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return idRooms;
	}
	
	
	@Transactional
	public int getAvgUserPerGroup() {

		ArrayList<ChatRoom> chatRooms = new ArrayList<>();
		ChatRoomData chatData = new ChatRoomData();
		chatRooms = (ArrayList<ChatRoom>) chatData.getRooms();
		
		ArrayList<UserClient> users = new ArrayList<>();
		UserData userData = new UserData();
		users = (ArrayList<UserClient>) userData.getUser();
		
		ArrayList<Integer> cantidadUsuariosPorChat = new ArrayList<>();
		
/*
		int cantidadRooms=0;
		for (int i = 0; i < chatRooms.size(); i++) {
			int cantidadUsuarios=0;

			for (int j = 0; j < users.size(); j++) {
				if(chatRooms.get(i).getId() == 0//debe de comparar con el id_room de user_room
						) {
				cantidadUsuarios++;
				}
			}			}
			cantidadUsuariosPorChat.add(i,cantidadUsuarios);
			cantidadRooms++;
		}
		
		int promedioUsuarios=0;
		for (int i = 0; i < cantidadUsuariosPorChat.size(); i++) {
			promedioUsuarios+=cantidadUsuariosPorChat.get(i);
		}
		promedioUsuarios=(promedioUsuarios/cantidadUsuariosPorChat.size())*100;
		
		return promedioUsuarios;*/
		return 1;
	}

	public String getFechaUltimoMensaje(ChatRoom chatRoom) {
		
		ChatRoomData chatData = new ChatRoomData();
		MessageData messagesData = new MessageData();
		
		String mensaje = "";
		
		ArrayList<ChatRoom> rooms = chatData.getAllNameRooms();
		ArrayList<Message> ultimosMensajes = new ArrayList<Message>();
		
		for (int i = 0; i < rooms.size(); i++) {
			messagesData = (MessageData) messagesData.getUltimosMessages(rooms.get(i));
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechaActual;
		try {
			fechaActual = (Date) format.parse("2000-01-01 00:00:00");
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		for (int i = 0; i < ultimosMensajes.size(); i++) {
			if(fechaActual.compareTo(ultimosMensajes.get(i).getDate()) > 0) {
				fechaActual=ultimosMensajes.get(i).getDate();
			}	
		}
		mensaje = fechaActual.toString();
		
		return mensaje;
	}
	
	public String getFechaPrimerLogueo() {
		HistorialLogueoData historialLogueoData = new HistorialLogueoData();
		String fecha="";
		ArrayList<HistorialLogueo> logueos = historialLogueoData.getLogin();
		
		fecha = logueos.get(logueos.size()).getFecha();
		
		return fecha;
	}
	
	public String getUsuarioMasMensajes() {
		String usuario="";
		int cantidadMensajes=0;
		
		ChatRoomData chatData = new ChatRoomData();
		MessageData messagesData = new MessageData();
		
		ArrayList<ChatRoom> rooms = chatData.getAllNameRooms();
		ArrayList<UserClient> usuarioMensajes = new ArrayList<UserClient>();
		
		for (int i = 0; i < rooms.size(); i++) {
			if(cantidadMensajes < rooms.get(i).getListMessage().size()) {
				cantidadMensajes = rooms.get(i).getListMessage().size();
				usuarioMensajes = (ArrayList<UserClient>) rooms.get(i).getListUsers();
			}
		}
		usuario= usuarioMensajes.toString();
	return usuario;
	}
	
}
