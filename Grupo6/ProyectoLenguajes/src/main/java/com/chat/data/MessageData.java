package com.chat.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.domain.ChatRoom;
import com.chat.domain.Message;

@Repository
public class MessageData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*@Transactional(readOnly = true)
	public Iterator<Message> getMessages(int begin, int end, int room) {
		List<Message> messages = new ArrayList<Message>();
		String selectSql = "SELECT message_id, message_description, message_date, id_sending_user "
				+ "FROM Message g "
				+ "WHERE message_id > ? AND message_id < ? AND receiver = ? "
				+ "ORDER BY message_id ASC";
		jdbcTemplate
				.query(selectSql, new Object[] { begin, end },
						(rs, row) -> new Message(rs.getInt("message_id"), rs.getString("message_description"),
								rs.getString("message_date"), rs.getInt("id_sending_user")))
				.forEach(entry -> messages.add(entry));
		return messages.iterator();
	}*/

	@Transactional
	public void save(Message message, ChatRoom chatRoom)
	{
		Connection conexion = null;
		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			String sqlInsert = "INSERT INTO messages_"+chatRoom.getName()+" (message_description, message_date, id_sending_user, receiver) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement statementInser = conexion.prepareStatement(sqlInsert);
			statementInser.setString(1, message.getMessage());
			statementInser.setString(2, message.getDate());
			statementInser.setInt(3, message.getIdSendingUser());
			statementInser.setInt(4, chatRoom.getId());
			statementInser.executeUpdate();
			//TODO Falta actualizar metricas
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}