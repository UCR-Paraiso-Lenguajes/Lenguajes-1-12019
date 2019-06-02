package cr.ac.ucr.TareaTres.domain;

/*
 * Objetos de transferencia de datos
 * Son estructuras muy útiles para comunicarse con bases de datos 
 * o analizar mensajes de conexiones.
 * Tiene variables privadas manipuladas por métodos de establecimiento y recuperación.
 */

public class Producto {

	/*
	 * Abstracción de datos
	 * No hay que mostrar los detalles de los datos,
	 * sino expresarlos en términos abstractos, por ejemplo no mostrar 
	 * la unidad en que se guarda el peso del producto o no mostrar
	 * cuales son las categorías en las que se dividen los productos.
	 */
	private int id;
	private String nombre;
	private String categoria;
	private int peso;

	public Producto(int id, String nombre, String categoria, int peso) {
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido.");
		if(categoria == null) throw new RuntimeException("La categoria es requerida.");
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.peso = peso;
	}
	
	/*
	 * Antisimetría de datos y objetos:
	 * Los objetos ocultan sus datos tras abstracciones y muestran funciones que operan en dichos datos.
	 * Habrá ocasiones en las que queramos añadir nuevos tipos de datos en lugar de nuevas funciones. 
	 * Por otra parte, en ocasiones tendremos que añadir nuevas funciones en lugar de tipos de datos.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		/*
		 * Ofrecer contexto junto a las excepciones
		 * Las excepciones que genere deben proporcionar el contexto adecuado
		 * para que se determine el origen y la ubicación del error.
		 */
		if(id <= 0) throw new RuntimeException("Para agregar o modificar un producto el código debe ser mayor a 0.");
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null && nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido.");
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		if(categoria != null && categoria.trim().equals("")) throw new RuntimeException("La categoria es requerida");
		this.categoria = categoria;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		if(id <= 0) throw new RuntimeException("El peso debe ser mayor a 0.");
		this.peso = peso;
	}

}

