package com.chat.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.Message;

@Repository
public class MessageData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Transactional(readOnly = true)
	public List<Message> getMessages(int begin, int end)
	{
		List<Message> messages = new ArrayList<Message>();
		String selectSql = 
			"SELECT message_id, message_description, message_date, id_sending_user "
			+ "FROM Message g "
			+ "WHERE message_id > ? AND message_id < ? order by message_id ASC";
				jdbcTemplate.query(
						selectSql, 
						new Object[] {begin, end}, 
						(rs, row) -> new Message(rs.getInt("message_id"),
										rs.getString("message_description"), 
										rs.getString("message_date"), 
										rs.getInt("id_sending_user"))
							)
						.forEach(entry -> messages.add(entry)
				);
		return messages;
	}
	
	@Transactional
	public Message save(Message message)
	{
		String sqlInsert = "INSERT INTO Message (message_description, message_date, id_sending_user) "
				+ "VALUES ('"+message.getMessage()+"', '"+message.getDate()+"', "+message.getIdSendingUser()+")";
		jdbcTemplate.execute(sqlInsert);
		return message;
	}
}