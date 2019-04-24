/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2lenguajes;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniela
 */
public class Condominio {
    
    private List<Cliente> listaClientes = new ArrayList<Cliente>(); //capitulo 2(Use Pronounceable Names)
    

    public Condominio() {
        
    }
    
    public void ingresarCliente(Cliente cliente){// capitulo 2(Method Names) , capitulo 3(Small)
        listaClientes.add(cliente);
    }
    
    public void eliminarCliente(Cliente cliente){//capitulo 3(Use Descriptive Names)
        listaClientes.remove(cliente);
    }
       
    
    public  List<Cliente> getCliente (){//capitulo 2(Add Meaningful Context)
    return  listaClientes;
}
}
