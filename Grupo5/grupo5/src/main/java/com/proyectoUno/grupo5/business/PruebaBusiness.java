package com.proyectoUno.grupo5.business;

import com.proyectoUno.grupo5.dao.PruebaDao;
import com.proyectoUno.grupo5.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaBusiness {
    @Autowired
    private PruebaDao prueba;

    public List<Role> gerRole () {
        return prueba.getRole();
    }
}
