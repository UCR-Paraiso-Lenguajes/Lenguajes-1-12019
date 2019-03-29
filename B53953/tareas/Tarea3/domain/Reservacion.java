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
		if(cliente == null) throw new RuntimeException("El cliente es requerido");
		if(vuelo == null) throw new RuntimeException("El vuelo es requerido");
		
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
		if(codigo <= 0) throw new RuntimeException("El codigo debe ser mayor a 0");
		this.codigo = codigo;
	}

	public float getPago() {
		return pago;
	}

	public void setPago(float pago) {
		if(pago <= 0) throw new RuntimeException("El pago debe ser mayor a 0");
		this.pago = pago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		if(fecha == null || fecha.trim().equals("")) throw new RuntimeException("La fecha es requerida");
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if(cliente == null) throw new RuntimeException("El cliente es requerido");
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		if(vuelo == null) throw new RuntimeException("El vuelo es requerido");
		this.vuelo = vuelo;
	}
	
	
	
	
	
	
}
