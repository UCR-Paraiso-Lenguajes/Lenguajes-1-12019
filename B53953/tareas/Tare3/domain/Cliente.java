package domain;

public class Cliente {

	//cap 6: The Law of Demeter
    private String nombre;
    private String apellidos;
    private String correo;
    private String identificacion;
    private String direccion;
    private int numeroPasaporte;
    
    
    
    
	public Cliente() {
		super();
		
	}


	public Cliente(String nombre, String apellidos, String correo, String identificacion, String direccion,
			int numeroPasaporte) {
		super();
		
		//cap 7:Use Exceptions Rather Than Return Codes
		
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidos == null || apellidos.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		if(correo == null || correo.trim().equals("")) throw new RuntimeException("El correo es requerido");
		if(identificacion == null || identificacion.trim().equals("")) throw new RuntimeException("La identificacion es requerida");
		if(direccion == null || direccion.trim().equals("")) throw new RuntimeException("La direccion es requerida");
		if(numeroPasaporte <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.numeroPasaporte = numeroPasaporte;
	}


	public String getNombre() {//cap 6:Data Abstraction
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


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getNumeroPasaporte() {
		return numeroPasaporte;
	}


	public void setNumeroPasaporte(int numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}
    
	
	
    
}
