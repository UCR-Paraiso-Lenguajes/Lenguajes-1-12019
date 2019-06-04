package com.projectOne.interactiveMessaging.bussines;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.domain.GroupUser;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.TableMessagesGroups;

@Service
public class GroupBusiness {
	@Autowired
	private GroupData groupData;
	
	public String getNameGroupTableMessages(int idGroup) {
		return groupData.getNameGroupTableMessages(idGroup);
	}
	public List<Room> getGroupsOfUser(int idUserRoom) {
		return groupData.getGroupsOfUser(idUserRoom);
	}
	
	public int saveGroup(String nameGroup) {
		return groupData.saveGroup(nameGroup);
	}
	
	public void saveUserRoleRoom(int idUser, int idRole, int idRoom) {
		groupData.saveUserRoleRoom(idUser, idRole, idRoom);
	}
}
