package cr.ac.ucr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.domain.User;


@Repository
public class UserData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallUser;
	private DataSource dataSource;
	
	
	public List<User> findUsers() {
		String sqlSelect = "SELECT u.id_user,u.name,u.email"
				+ " FROM User u";
		return jdbcTemplate.query(sqlSelect, new ListUsers());
	}
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.simpleJdbcCallUser = new SimpleJdbcCall(dataSource)
		.withCatalogName("dbo")
		.withProcedureName("Add")
		.withoutProcedureColumnMetaDataAccess()
		.declareParameters(new SqlOutParameter("@idUser", Types.INTEGER))
		.declareParameters(new SqlParameter("@email", Types.VARCHAR));
		
   }
	
	@Transactional
	public User save(User user) throws SQLException{
		
		SqlParameterSource parameterSource = new MapSqlParameterSource()
		.addValue("@email", user.getEmail());
		
		Map<String, Object> outParameters = simpleJdbcCallUser.execute(parameterSource);
		user.setIdUser(Integer.parseInt(outParameters.get("@idUser").toString()));
		

		return user;
		

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


