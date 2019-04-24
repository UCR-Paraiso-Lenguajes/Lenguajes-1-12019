package cr.ac.ucr.ie.app.domain;

public class Empleado
{	
	private int id;
	private String nombre;
	private String apellidos;
	private Departamento departamento;
	
	public Empleado(int id, String nombre, String apellidos, Departamento departamento)
	{
		this(id, nombre,departamento);
		if(apellidos != null && apellidos.trim().equals("")) throw new RuntimeException("El apellidos es requerido");		

		this.apellidos = apellidos;
		this.departamento = departamento;
	}
	
	public Empleado(int id, String nombre, Departamento departamento)
	{
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(departamento == null) throw new RuntimeException("El departamento es requerido");
		
		this.departamento=departamento;
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		if(nombre != null && nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		if(apellidos != null && apellidos.trim().equals("")) throw new RuntimeException("El apellidos es requerido");	
		this.apellidos = apellidos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		if(departamento == null) throw new RuntimeException("El departamento es requerido");
		this.departamento = departamento;
	}
	
	
	
}
