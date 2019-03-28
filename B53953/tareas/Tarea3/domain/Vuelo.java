package domain;

public class Vuelo {//cap 6:Objetos de transferencia de datos

	private int numeroVuelo;
	private String horaSalida;
	private String horaLlegada;
    private String aeropuertoSalida;
    private String aeropuertoDestino;

    
    
	public Vuelo() {
		super();
		
	}


	public Vuelo(int numeroVuelo, String horaSalida, String horaLlegada, String aeropuertoSalida,
			String aeropuertoDestino) {
		super();
		//cap 7: Proporcionar contexto con excepciones
		//cap 7: Utilice excepciones no marcadas
		
		if(horaSalida == null || horaSalida.trim().equals("")) throw new RuntimeException("La hora de salida es requerida");
		if(horaLlegada == null || horaLlegada.trim().equals("")) throw new RuntimeException("La hora de llegada es requerida");
		if(aeropuertoSalida == null || aeropuertoSalida.trim().equals("")) throw new RuntimeException("El aeropuerto de salida es requerido");
		if(aeropuertoDestino == null || aeropuertoDestino.trim().equals("")) throw new RuntimeException("El aeropuerto de destino es requerido");
		
		if(numeroVuelo <= 0) throw new RuntimeException("El numero del vuelo debe ser mayor a 0");
		
		this.numeroVuelo = numeroVuelo;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoDestino = aeropuertoDestino;
		
	}


	public int getNumeroVuelo() {
		return numeroVuelo;
	}


	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public String getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public String getAeropuertoSalida() {
		return aeropuertoSalida;
	}


	public void setAeropuertoSalida(String aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}


	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}


	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}



    
    
    
	
}
