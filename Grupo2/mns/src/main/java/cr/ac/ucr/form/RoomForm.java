package cr.ac.ucr.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomForm {

	private int id;
	
	@NotNull
	@Size(max =100)//revisar
	private String name;

	
	public int getIdRoom() { return id; }
 
	public void setIdRoom(int idRoom) { this.id = idRoom; }
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
