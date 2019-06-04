package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;

public class GroupUser {
	private int idGroup;
	private ArrayList<Integer>ids;
	
	public GroupUser(int idGroup, ArrayList<Integer> ids) {
		this.idGroup = idGroup;
		this.ids = ids;
	}
	public GroupUser() {
		this.idGroup = 0;
		this.ids = new ArrayList<>();
	}
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public ArrayList<Integer> getIds() {
		return ids;
	}
	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}
	public void setId(int id) {
		this.ids.add(id);
	}
	
}
