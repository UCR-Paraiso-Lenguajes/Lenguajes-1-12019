/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2lenguajes;

/**
 *
 * @author daniela
 */
public class Cliente {// capitulo 2(Class Names)
    
   private String nombre; //Capitulo 2 (Use Intention-Revealing Names)
    private int edad;
    private String cedula; 
    private int salario;

    public Cliente() {
    }
    
    

    public Cliente(String nombre, int edad, String cedula, int salario) {
        if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");//cap 3:Blocks and Indenting
        if(cedula == null || cedula.trim().equals("")) throw new RuntimeException("La cedula es requerida");
        if(edad <= 0) throw new RuntimeException("La edad debe ser mayor a 0");
	if(salario <= 0) throw new RuntimeException("El alario debe ser mayor a 0");
			
        
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.salario = salario;
    }

    public String getNombre() {//capitulo 3 (One Level of Abstraction per Function)
        return nombre;
    }

    public void setNombre(String nombre) {//cap 3:Do One Thing
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + ", salario=" + salario + '}';
    }
    
    
    
    
}
