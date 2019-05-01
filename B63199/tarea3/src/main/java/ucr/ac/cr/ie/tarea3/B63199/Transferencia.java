package ucr.ac.cr.ie.tarea3.B63199;


//Data Transfer Objects pág. 101
public class Transferencia {

	private Object cliente;
	private String numTarjeta;
	private double montoTotal;
	private double montoTranferido;
	public Transferencia(Object cliente, String numTarjeta, double montoTotal, double montoTranferido) {
		if(cliente!=null) throw new RuntimeException("El cliente debe no es valido");
		this.cliente = cliente;
		if(numTarjeta.lenght()<4) throw new RuntimeException("El numero de tarjeta debe de contener al menos 4 dígitos");
		this.numTarjeta = numTarjeta;
		if(montoTranferido>0) throw new RuntimeException("El monto transferido debe de ser mayor a 0");
		this.montoTranferido = montoTranferido;
		if(montoTotal>=montoTranferido) throw new RuntimeException("El monto total debe de ser mayor o igual al monto transferido");
		this.montoTotal = montoTotal;

	}
	public Object getCliente() {
		return cliente;
	}
	public void setCliente(Object cliente) {
		this.cliente = cliente;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public double getMontoTranferido() {
		return montoTranferido;
	}
	public void setMontoTranferido(double montoTranferido) {
		this.montoTranferido = montoTranferido;
	}
	
	

}



