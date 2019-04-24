package com.orbis.b54524.dominio;

/**
 * Clase para simular un autor, se valida que los datos del constructor sean validos
 * @author Equipo
 *
 */
public class Autor {
	
	private int idAutor;
	private String nombreAutor;
	private String apellidosAutor;
	
	/**
	 * Para crear un nuevo Autor
	 * @param nombreAutor
	 * @param apellidosAutor
	 * @throws Exception 
	 */
	public Autor(String nombreAutor, String apellidosAutor) throws Exception {
		setNombreAutor(nombreAutor);
		setApellidosAutor(apellidosAutor);
	}
	
	/**
	 * Para guardar datos de la base de datos
	 * @param idAutor
	 * @param nombreAutor
	 * @param apellidosAutor
	 * @throws Exception 
	 */
	public Autor(int idAutor, String nombreAutor, String apellidosAutor) throws Exception {
		setIdAutor(idAutor);
		setNombreAutor(nombreAutor);
		setApellidosAutor(apellidosAutor);
	}

	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public String getApellidosAutor() {
		String result = apellidosAutor;
		return result;
	}

	public void setApellidosAutor(String apellidosAutor) throws Exception {
		if(apellidosAutor != null && !apellidosAutor.trim().equals("")) {
			this.apellidosAutor = apellidosAutor;
		}else {
			throw new Exception("El apellido del autor es invalido");
		}
	}

	public int getIdAutor() {
		int result = idAutor;
		return result;
	}

	public void setIdAutor(int idAutor) throws Exception {
		if(idAutor > 0) {
			this.idAutor = idAutor;
		}else {
			throw new Exception("El id del autor es invalido");
		}
	}

	public String getNombreAutor() {
		String result = nombreAutor;
		return result;
	}

	public void setNombreAutor(String nombreAutor) throws Exception {
		if(nombreAutor != null && !nombreAutor.trim().equals("")) {
			this.nombreAutor = nombreAutor;
		}else {
			throw new Exception("El nombre del autot debe ser valido");
		}
	}
}
