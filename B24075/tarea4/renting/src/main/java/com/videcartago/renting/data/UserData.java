package com.videcartago.renting.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.videcartago.renting.domain.Pelicula;
import com.videcartago.renting.domain.Role;
import com.videcartago.renting.domain.User;

@Repository
public class UserData 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public User findByEmail(String email)
	{
		String sqlSelect = "SELECT us.id,us.email,us.password,us.name as user_name, role.role_id, role.name as role_name"
				+ " FROM Users us "
				+ "  left join user_role ur on us.id = ur.user_id"
				+ "  left join role1 role on ur.role_id = role.role_id"
				+ " WHERE us.email = '"+email.trim() + "' ";
		try 
		{
			return jdbcTemplate.query(sqlSelect, new UsesWithRoleExtractor());
		}
		catch (UncategorizedSQLException e) 
		{
			return null;
		}
	}
}


class UsesWithRoleExtractor implements ResultSetExtractor<User> {
	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		if(rs == null) return null; 
			
		User user = null;
		
		rs.next();
		
		int id = rs.getInt("id");
		String email= rs.getString("email");
		String password= rs.getString("password");
		String name= rs.getString("user_name");
		
		ArrayList<Role> roles =new  ArrayList<Role>();
		
		int idRole = rs.getInt("role_id");
		String roleName= rs.getString("role_name");
		roles.add(new Role(idRole, roleName));

		while (rs.next()) 
		{
			idRole = rs.getInt("role_id");
			roleName= rs.getString("role_name");
			roles.add(new Role(idRole, roleName));
		} 
		return new User(id,name,email, password, roles);
	} 
}