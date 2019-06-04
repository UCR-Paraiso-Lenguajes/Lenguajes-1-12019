package cr.ac.ucr.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.domain.User;


@Repository
public class UserData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	
	public List<User> findUsers() {
		String sqlSelect = "SELECT u.id_user,u.name,u.email"
				+ " FROM User u";
		return jdbcTemplate.query(sqlSelect, new ListUsers());
	}
	
	
	
	public User save(User user) throws SQLException {
			
		Connection conexion = null;
			
		conexion = dataSource.getConnection();
	
		
		String insertUser = "INSERT INTO User  (hash, mail)  VALUES(?,?)";
		
		PreparedStatement prest;
		prest = conexion.prepareStatement(insertUser,Statement.RETURN_GENERATED_KEYS);
		prest.setString(1,user.getHash() );
		prest.setString(2, user.getEmail());
		prest.executeUpdate();
		
		ResultSet rs = prest.getGeneratedKeys();
        if(rs.next())
        {
            int last_inserted_id = rs.getInt(1);
        }
		
		
		
		
		
		
		
		
		
		conexion.close();
		return user;
	
	}
	
	
	public User create(final User user) {
		final String insertUser = "INSERT INTO User  (hash, mail) VALUES(:hash,:mail)";
		KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("hash", user.getHash())
					.addValue("mail", user.getEmail());
			jdbcTemplate.update(insertUser, parameters, holder);
			user.setIdUser(holder.getKey().intValue());
			return user;
	}

	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		new SimpleJdbcCall(dataSource)
		.withCatalogName("dbo")
		.withProcedureName("Add")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(new SqlOutParameter("@idUser", Types.INTEGER))
		.declareParameters(new SqlParameter("@email", Types.VARCHAR));
		
   }
	
	
}

class ListUsers implements ResultSetExtractor<List<User>> {
	
	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, User> map = new HashMap<Integer, User>();
		User user = null;
		while (rs.next()) {
			Integer id = rs.getInt("id_user");
			user = map.get(id);
			if (user == null) { 
				user = new User();
				user.setIdUser(id);
				user.setEmail(rs.getString("email"));
				map.put(id, user);
			} 
		} // while
		return new ArrayList<User>(map.values());
	} // extractData

}


