package com.proyectoUno.grupo5.business;

import com.proyectoUno.grupo5.dao.RoleDao;
import com.proyectoUno.grupo5.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleBusiness {
    @Autowired
    private RoleDao roleDao;

    public List<Role> gerRolePerId (int id) {
        return roleDao.getRolePerId(id);
    }
    
   
}
