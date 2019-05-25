package cr.ac.ucr.domain;

public class Rol {

   private int idRol;
   private String detalle;
   
   
    public Rol() {
	   super();
	
    }


    public Rol(int idRol, String detalle) {
	  super();
	  this.idRol = idRol;
	  this.detalle = detalle;
    }


    public int getIdRol() {
	  return idRol;
    }


    public void setIdRol(int idRol) {
	  this.idRol = idRol;
    }


    public String getDetalle() {
	  return detalle;
    }
 

   public void setDetalle(String detalle) {
	 this.detalle = detalle;
   }
	
   
   
}
