package com.proyectoUno.grupo5.dao;

import com.proyectoUno.grupo5.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PruebaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Transactional(readOnly = true)
    public List<Role> getRole(int id) {
        String sqlSelect = "select * from role";
        return jdbcTemplate.query(sqlSelect, new RoleWithExtractor());
    }
    class RoleWithExtractor implements ResultSetExtractor<List<Role>> {

        @Override
        public List<Role> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Role> map = new HashMap<>();
            Role role = null;
            while (rs.next()) {
                Integer id = rs.getInt("idrole");
                role = map.get(id);
                if (role == null) {
                    role = new Role();
                    role.setIdRole(id);
                    role.setRoleType(rs.getString("role_type"));

                    map.put(id, role);

                }

            }
            return new ArrayList<Role>(map.values());
        }

    }

}
