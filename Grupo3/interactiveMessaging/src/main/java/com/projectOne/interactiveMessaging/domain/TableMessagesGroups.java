package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectOne.interactiveMessaging.data.GroupData;

public class TableMessagesGroups {

	public static ArrayList<GroupUser> listOfGroupUsers = new ArrayList<>();

	public ArrayList<GroupUser> getListOfSingleGroups() {
		return listOfGroupUsers;
	}

	public void chargeEmptyTable() {

	}

	public void setListOfGroupUsers(ArrayList<GroupUser> listOfGroupUsers) {
		TableMessagesGroups.listOfGroupUsers = listOfGroupUsers;
	}

	public void storeNewGroup(GroupUser groupUsr) {
		listOfGroupUsers.add(groupUsr);
	}

	public void changeGroup(int idGroup, int idUser, boolean action) {// si la accion es 0 significa que sale del grupo,
																		// pero si es 1 es por que entro al grupo
		for (int i = 0; i < listOfGroupUsers.size(); i++) {

			if (listOfGroupUsers.get(i).getIdGroup() == idGroup) {
				int sizeListId = listOfGroupUsers.get(i).getIds().size();
				if (action) {
					listOfGroupUsers.get(i).getIds().add(idUser);
				} else {
					for (int j = 0; j < sizeListId; j++) {
						if (listOfGroupUsers.get(i).getIds().get(j) == idUser) {

							listOfGroupUsers.get(i).getIds().remove(j);

						}

					}
				}

			}

		}

	}

	public boolean existUserOnGroup(int idGroup, int idUser) {
		for (int i = 0; i < listOfGroupUsers.size(); i++) {

			if (listOfGroupUsers.get(i).getIdGroup() == idGroup) {
				int sizeListId = listOfGroupUsers.get(i).getIds().size();

				for (int j = 0; j < sizeListId; j++) {
					if (listOfGroupUsers.get(i).getIds().get(j) == idUser) {

						return true;

					}

				}

			}

		}
		return false;
	}

	public void deleteUserFromAnyGroup(int idUser) {// si la accion es 0 significa que sale
													// del grupo,
		// pero si es 1 es por que entro al grupo
		for (int i = 0; i < listOfGroupUsers.size(); i++) {

			int sizeListId = listOfGroupUsers.get(i).getIds().size();

			for (int j = 0; j < sizeListId; j++) {
				if (listOfGroupUsers.get(i).getIds().get(j) == idUser) {

					listOfGroupUsers.get(i).getIds().remove(j);
					break;
				}

			}

		}

	}

	public boolean existUserFromAnyGroup(int idUser) {
		for (int i = 0; i < listOfGroupUsers.size(); i++) {

			int sizeListId = listOfGroupUsers.get(i).getIds().size();

			for (int j = 0; j < sizeListId; j++) {
				if (listOfGroupUsers.get(i).getIds().get(j) == idUser) {

					return true;
				}

			}

		}
		return false;

	}

}
