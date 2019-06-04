package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectOne.interactiveMessaging.data.GroupData;

public class TableMessagesGroups {
	@Autowired
	private GroupData groupData;
	public static ArrayList<GroupUser> listOfGroupUsers = new ArrayList<>();
	 
	public ArrayList<GroupUser> getListOfSingleGroups() {
		return listOfGroupUsers;
	}
	public void chargeEmptyTable() {
		Iterator<Room> groups = groupData.getGroups();
		
		while(groups.hasNext()) {
			listOfGroupUsers.add(new GroupUser(groups.next().getGroup_id()));
		}
	}
	public void setListOfGroupUsers(ArrayList<GroupUser> listOfGroupUsers) {
		TableMessagesGroups.listOfGroupUsers = listOfGroupUsers;
	}
	
	public void storeNewGroup(GroupUser groupUsr) {
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
