package com.projectOne.interactiveMessaging.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.GroupData;

@Service
public class GroupBusiness {
	@Autowired
	private GroupData groupData;
	
	public String getNameGroupTableMessages(int idGroup) {
		return groupData.getNameGroupTableMessages(idGroup);
	}
}
