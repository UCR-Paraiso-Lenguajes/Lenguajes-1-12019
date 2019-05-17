package com.videocartago.renting.domain;

public class ProductoraPelicula {
	
	private static ProductoraPelicula instance = new ProductoraPelicula();
	private String tipo;
	
	  private ProductoraPelicula(){
	        
	    }
	    
	    public static ProductoraPelicula getInstance(){
	        return instance;
	    }

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		@Override
		public String toString() {
			return "Productora tipo=" + tipo ;
		}
  
}
