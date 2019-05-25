package cr.ac.ucr.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomForm {

	//private int idRoom;
	
	@NotNull
	@Size(max =100)//revisar
	private String name;

	/*
	 * public int getIdRoom() { return idRoom; }
	 * 
	 * public void setIdRoom(int idRoom) { this.idRoom = idRoom; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
