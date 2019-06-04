package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.List;

public class TableMessagesGroups {
	public static ArrayList<GroupUser> listOfGroupUsers = new ArrayList<>();

	public ArrayList<GroupUser> getListOfSingleGroupMessages() {
		return listOfGroupUsers;
	}

	public void setListOfSingleGroupMessages(ArrayList<GroupUser> listOfGroupUsers) {
		TableMessagesGroups.listOfGroupUsers = listOfGroupUsers;
	}
	
	public void storeNewMessage(GroupUser groupUsr) {
		listOfGroupUsers.add(groupUsr);
	}
	
	public void changeGroup(int idGroup, int idUser, boolean action) {//si la accion es 0 significa que sale del grupo, pero si es 1 es por que entro al grupo
		for (int i = 0; i < listOfGroupUsers.size(); i++) {
			
			if(listOfGroupUsers.get(i).getIdGroup()==idGroup) {
				int sizeListId = listOfGroupUsers.get(i).getIds().size();
				for (int j = 0; j < sizeListId; j++) {
					if(listOfGroupUsers.get(i).getIds().get(j)==idUser) {
						if(!action) {
							listOfGroupUsers.get(i).getIds().remove(j);
						}else{
							listOfGroupUsers.get(i).getIds().add(idUser);
						}
						
					}
				}
			}
			
		}
		
	}
}
