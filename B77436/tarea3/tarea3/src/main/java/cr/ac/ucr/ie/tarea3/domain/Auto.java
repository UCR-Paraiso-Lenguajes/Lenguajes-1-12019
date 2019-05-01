package cr.ac.ucr.ie.tarea3.domain;


/*Tip 3:
 * Objectos de transferencia de datos. Basado en la pagina 100
 * */
public class Auto {
	
	/*se implementan las variables de tipo privado para mantener seguro los datos*/
	private String marca;
	private String modelo;
	private int año;
	private String placa;
	private String numeroChasis;
	private String estiloAuto;
	
	//se implementan metodos para recuperacion de los datos
	public Auto(String marca, String modelo, int año, String placa, String numeroChasis, String estiloAuto) {
		if(marca.equals("") || modelo.equals("") || placa.equals("") || numeroChasis.equals("") || estiloAuto.equals("")) throw new RuntimeException("No se ingresaron datos en las variables");
		if(año ==0) throw new RuntimeException("No se ingreso un datos en la variable año");
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.placa = placa;
		this.numeroChasis = numeroChasis;
		this.estiloAuto = estiloAuto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public String getEstiloAuto() {
		return estiloAuto;
	}

	public void setEstiloAuto(String estiloAuto) {
		this.estiloAuto = estiloAuto;
	}
	
	

}
