package ucr.ac.cr.ie.tarea3.B63199;


//Data Transfer Objects pág. 101
public class Transferencia {

	private Object cliente;
	private String numTarjeta;
	private double montoTotal;
	private double montoTranferido;
	public Transferencia(Object cliente, String numTarjeta, double montoTotal, double montoTranferido) {
		this.cliente = cliente;
		this.numTarjeta = numTarjeta;
		this.montoTotal = montoTotal;
		this.montoTranferido = montoTranferido;
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



