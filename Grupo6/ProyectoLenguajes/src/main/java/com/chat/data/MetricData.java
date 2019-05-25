package com.chat.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.Metric;


@Repository
public class MetricData {

	@Autowired
	private DataSource dataSource;

	@Transactional(readOnly = true)
	public int getQuantityRooms() {
		Metric metric = new Metric();
		
		int quantityRooms=0;
		
		String selectSql = "SELECT count(room_id) quantityRooms FROM chat_db.room";
		
		Connection conexion = null;
		ResultSet rs = null;
		try{
			conexion = dataSource.getConnection();
			PreparedStatement statement = conexion.prepareStatement(selectSql);
			rs = statement.executeQuery();
			quantityRooms=rs.getInt(1);

		}catch (Exception e){
			throw new RuntimeException(e);
		}
		metric.setQuantityRoom(quantityRooms);
		return quantityRooms;
	}

}