package com.proyectoUno.grupo5.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.proyectoUno.grupo5.domain.User;

@Repository
public class UserDao {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Autowired
	    private DataSource dataSource;
	    
	public Boolean insertUser(User user){
        String query="insert into user(email, hash, id_role ) values(?,?,?)";

        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setString(1,user.getEmail());
                ps.setString(2,user.getHash());
                ps.setInt(3,user.getRoleUser().get(0).getIdRole());

                return ps.execute();

            }
        });
    }

        
    class UserWithExtractor implements ResultSetExtractor<List<User>> {

        @Override
        public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        	
        
        	Map<Integer, User> map = new HashMap<>();
            User user = null;
            while (rs.next()) {
                Integer id = rs.getInt("iduser");
                user = map.get(id);
                if (user == null) {
                    user = new User();
                    user.setIdUser(id);
                    user.setEmail(rs.getString("email"));
                    user.setHash(rs.getString("hash"));
                    map.put(id, user);

                }

            }
            return new ArrayList<User>(map.values());
        }

		
    }
}

        

