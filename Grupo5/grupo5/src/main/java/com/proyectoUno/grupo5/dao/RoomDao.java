package com.proyectoUno.grupo5.dao;

import com.proyectoUno.grupo5.dao.MessageDao.MessageWithExtractor;
import com.proyectoUno.grupo5.domain.Message;
import com.proyectoUno.grupo5.domain.Role;
import com.proyectoUno.grupo5.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;
    
    private List<Message> listMessages;
    private List<List> rooms;

    public Boolean insertRoom(Room r){
        String query="insert into room(room_name,version) values(?,?)";

        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setString(1,r.getRoomName());
                ps.setInt(2,r.getVersion());

                return ps.execute();

            }
        });
        
       
        
    }
    
    public List<Room> listRoomsForIdUser(int idUser){
    	
    	
    	/*
    	 *SELECT column-names
  FROM table-name1 JOIN table-name2 
    ON column-name1 = column-name2
 WHERE condition
    	 */
    	
    	String sqlSelect = "SELECT room.id_room, room.room_name, room.version from room JOIN user_room WHERE id_user=" +idUser+" group by id_room";
    			 
    			
    	
    			
    			
    	
    			;
		
		return jdbcTemplate.query(sqlSelect, new RoomWithExtractor());
    	
    }
}

    class RoomWithExtractor implements ResultSetExtractor<List<Room>> {

        @Override
        public List<Room> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Room> map = new HashMap<>();
            Room room = null;
            while (rs.next()) {
                Integer id = rs.getInt("id_room");
                room = map.get(id);
                if (room == null) {
                    room = new Room();
                    room.setIdRoom(id);
                    room.setRoomName(rs.getString("room_name"));
                    room.setVersion(rs.getInt("version"));

                    map.put(id, room);

                }

            }
            return new ArrayList<Room>(map.values());
            
            
        }

    }
    
    
    
   

