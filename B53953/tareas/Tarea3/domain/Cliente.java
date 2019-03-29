package domain;

public class Cliente {
    //cap 6:{//cap 6:Abstracción de datos
	//cap 6: La ley de demeter
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
		
		//cap 7:Utilice excepciones en lugar de c�digos de retorno
		
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidos == null || apellidos.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		if(correo == null || correo.trim().equals("")) throw new RuntimeException("El correo es requerido");
		if(identificacion == null || identificacion.trim().equals("")) throw new RuntimeException("La identificación es requerida");
		if(direccion == null || direccion.trim().equals("")) throw new RuntimeException("La dirección es requerida");
		if(numeroPasaporte <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.numeroPasaporte = numeroPasaporte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}


	public String getApellidos() {
		
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		if(apellidos == null || apellidos.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		if(correo == null || correo.trim().equals("")) throw new RuntimeException("El correo es requerido");
		this.correo = correo;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		if(identificacion == null || identificacion.trim().equals("")) throw new RuntimeException("La identificación es requerida");
		this.identificacion = identificacion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		if(direccion == null || direccion.trim().equals("")) throw new RuntimeException("La dirección es requerida");
		this.direccion = direccion;
	}


	public int getNumeroPasaporte() {
		return numeroPasaporte;
	}


	public void setNumeroPasaporte(int numeroPasaporte) {
		if(numeroPasaporte <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		this.numeroPasaporte = numeroPasaporte;
	}
    
	
	
    
}
