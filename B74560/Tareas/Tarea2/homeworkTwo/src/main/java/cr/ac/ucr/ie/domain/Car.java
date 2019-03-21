package cr.ac.ucr.ie.domain;

/* Capitulo 2 - Tip 1
 * Usar nombres correctos y verificar que 
 * no sean nombres reservados en algunos lenguajes. 
 * Estos podrán generar confusiones sino se usan 
 * correctamente. 
 */

public class Car {
	
	private short idCar = 0;
	private String brandCar = "";
	private String styleCar = "";
	private String license_plateCar="";
	
	public Car() {}
	
	public Car(short idCar, String brandCar, String styleCar, String license_plateCar) {
		
		if (brandCar==null || brandCar.trim().equals("")) 
			throw new RuntimeException("The text field of the brand of the car is empty, fill correctly.");
		if (styleCar==null || styleCar.trim().equals("")) 
			throw new RuntimeException("The text field of the style of the car is empty, fill correctly.");
		if (license_plateCar==null || license_plateCar.trim().equals("")) 
			throw new RuntimeException("The text field of the License plate of the car is empty, fill correctly.");
		if (idCar<=0 && idCar>100) 
			throw new RuntimeException("The text field of the License plate of the car is empty, fill correctly.");
			
		this.idCar = idCar;
		this.brandCar = brandCar;
		this.styleCar = styleCar;
		this.license_plateCar = license_plateCar;
	}
	
	public short getIdCar() {
		return idCar;
	}
	public void setIdCar(short idCar) {
		this.idCar = idCar;
	}
	public String getBrandCar() {
		return brandCar;
	}
	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}
	public String getStyleCar() {
		return styleCar;
	}
	public void setStyleCar(String styleCar) {
		this.styleCar = styleCar;
	}
	public String getLicense_plateCar() {
		return license_plateCar;
	}
	public void setLicense_plateCar(String license_plateCar) {
		this.license_plateCar = license_plateCar;
	}

	@Override
	public String toString() {
		return "Id Car:" + idCar + "\nBrand Car:" + brandCar + "\nStyle Car:" + styleCar + "\nLicense Plate Car:"
				+ license_plateCar;
	}  
	
	
	
}
