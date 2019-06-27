package cr.ac.ucr.ie.lenguajes.domain;

public class Role {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id <= 0) throw new RuntimeException("no puede ser negativo ");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.trim().toLowerCase().equals("")) throw new RuntimeException("no puede ser vacio");
		this.name = name;
	}
	public Role(int id, String name) {
		setName(name);
		this.id = id;
	}
	
	
}
