package com.chat.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		ChatRomData chatData = new ChatRomData();
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

	public String getFechaUltimoMensaje(int inicio, int fin, ChatRoom chatRoom) {
		String mensaje = "";
		
		ArrayList<Message> mensajes = new ArrayList<Message>();
		ChatRomData chatData = new ChatRomData();
		
		mensajes = (ArrayList<Message>) chatData.getMessages(inicio, fin, chatRoom);
		mensaje = mensajes.get(1).getDate();
		
		return mensaje;
	}
	
	public String getFechaPrimerLogueo() {
		HistorialLogueoData historialLogueoData = new HistorialLogueoData();
		String fecha="";
		ArrayList<HistorialLogueo> logueos = historialLogueoData.getLogin();
		
		fecha = logueos.get(logueos.size()).getFecha();
		
		return fecha;
	}
	
}
