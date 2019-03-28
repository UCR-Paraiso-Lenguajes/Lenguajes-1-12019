package cr.ac.ucr.domain;

import java.util.Date;

public class Empleado {

	private int codigo;
	private int identificacion;
	private String nombre;
	private String apellidos;
	private Date fechaInicioLabores;
	private Date fechaFinalizacionLabores;
	private double salario;
	private String direccion;
	private Date fechaNacimiento;
	
	public Empleado() {
		
	}
	
	public Empleado(int codigo, int identificacion, String nombre, String apellidos, Date fechaInicioLabores,
			Date fechaFinalizacionLabores, double salario, String direccion, Date fechaNacimiento) {
		
		this.codigo = codigo;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaInicioLabores = fechaInicioLabores;
		this.fechaFinalizacionLabores = fechaFinalizacionLabores;
		this.salario = salario;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaInicioLabores() {
		return fechaInicioLabores;
	}
	public void setFechaInicioLabores(Date fechaInicioLabores) {
		this.fechaInicioLabores = fechaInicioLabores;
	}
	public Date getFechaFinalizacionLabores() {
		return fechaFinalizacionLabores;
	}
	public void setFechaFinalizacionLabores(Date fechaFinalizacionLabores) {
		this.fechaFinalizacionLabores = fechaFinalizacionLabores;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDirecion() {
		return direccion;
	}
	public void setDirecion(String direcion) {
		this.direccion = direcion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", identificacion=" + identificacion + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", fechaInicioLabores=" + fechaInicioLabores
				+ ", fechaFinalizacionLabores=" + fechaFinalizacionLabores + ", salario=" + salario + ", direcion="
				+ direccion + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
