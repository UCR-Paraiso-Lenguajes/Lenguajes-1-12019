package domain;

public class Reservacion {

	private int codigo;
	private float pago;
	private String fecha;
	private Cliente cliente;
	private Vuelo vuelo;
	
	public Reservacion() {
		super();
	}

	public Reservacion(int codigo, float pago, String fecha, Cliente cliente, Vuelo vuelo) {
		super();
		
		if(fecha == null || fecha.trim().equals("")) throw new RuntimeException("La fecha es requerida");
		if(codigo <= 0) throw new RuntimeException("El codigo debe ser mayor a 0");
		if(pago <= 0) throw new RuntimeException("El pago debe ser mayor a 0");
		
		this.codigo = codigo;
		this.pago = pago;
		this.fecha = fecha;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPago() {
		return pago;
	}

	public void setPago(float pago) {
		this.pago = pago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
	
	
}
