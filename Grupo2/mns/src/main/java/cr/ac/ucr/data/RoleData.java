package cr.ac.ucr.data;

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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.domain.Role;

@Repository
public class RoleData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Transactional(readOnly=true)
	public List<Role> ListarLibros(int inicio,int _final){
		String sqlSelect = "SELECT top "+inicio+" l.id_libro, l.titulo, l.ano, l.precio "
				+ " FROM Libro l";
		return jdbcTemplate.query(sqlSelect, new RolesEstractor());
	}
	
	
	
	
	
	class RolesEstractor implements ResultSetExtractor<List<Role>>{

		@Override
		public List<Role> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			Map<Integer, Role> map = new HashMap<Integer, Role>();
			Role role = null;
			
			while(rs.next()) {
				
				Integer id = rs.getInt("idRole");
				role = map.get(id);
				
				if(role == null) {
					
					role = new	Role();
					role.setIdRole(rs.getInt("idRole"));
					role.setDetail(rs.getString("titulo"));
					map.put(id, role);
					
				}//if
			}//while
			return new ArrayList<Role>(map.values());
		}//extractData
	}
	
}
