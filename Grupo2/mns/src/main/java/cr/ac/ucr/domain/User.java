package cr.ac.ucr.domain;

import java.util.ArrayList;

import javax.swing.text.html.ImageView;

public class User {

	private int idUser;
	private String hash;
	private String nombre;
	private ImageView avatar;
	private String correo;
	private ArrayList<Rol> rolList;

	public User() {
		super();
		
	}

	public User(int idUser, String hash, String nombre, ImageView avatar, String correo, ArrayList<Rol> rolList) {
		super();
		this.idUser = idUser;
		this.hash = hash;
		this.nombre = nombre;
		this.avatar = avatar;
		this.correo = correo;
		this.rolList = rolList;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ImageView getAvatar() {
		return avatar;
	}
	public void setAvatar(ImageView avatar) {
		this.avatar = avatar;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Rol> getRolList() {
		return rolList;
	}
	public void setRolList(ArrayList<Rol> rolList) {
		this.rolList = rolList;
	}
	
	
}
