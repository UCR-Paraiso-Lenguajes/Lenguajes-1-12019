package com.projectOne.interactiveMessaging.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectOne.interactiveMessaging.domain.Message;

@Repository
public class GroupData {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly = true)
	public String getNameGroupTableMessages(int idGroup) {
		String nameTable = "";
		String selectMysql;
		selectMysql = "SELECT `RoomApp`.`nameMessageTable` " + 
				"FROM `IF4100_Proyecto_JAJME`.`RoomApp` " + 
				"WHERE id = ?;";
		nameTable=jdbcTemplate
		.query(selectMysql, new Object[] { idGroup }, (rs, row) -> new String(rs.getString("nameMessageTable")))
		.get(0);
	
		return nameTable;
	}
}
