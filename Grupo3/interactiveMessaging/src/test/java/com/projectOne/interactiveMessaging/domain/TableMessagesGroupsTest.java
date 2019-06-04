package com.projectOne.interactiveMessaging.domain;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.bussines.GroupBusiness;
import com.projectOne.interactiveMessaging.data.GroupData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableMessagesGroupsTest {
	@Autowired
	private GroupBusiness groupBusiness;
	@Autowired
	private GroupData groupData;
	
	
	
	@Test
	public void testChargedTable() {
		TableMessagesGroups tableGroups = new TableMessagesGroups();
		TableMessagesGroups tableGroups2 = new TableMessagesGroups();
		Iterator<Room> groups = groupData.getGroups();
		
		while(groups.hasNext()) {
			tableGroups.storeNewGroup(new GroupUser(groups.next().getGroup_id()));
		}
		//tableGroups.chargeEmptyTable();
		//groupBusiness.chargeUserGroupTable();
		ArrayList<GroupUser> table = tableGroups2.getListOfSingleGroups();
		tableGroups.changeGroup(3, 2, true);
		tableGroups.changeGroup(3, 6, true);
		tableGroups.changeGroup(2, 3, true);
		tableGroups.changeGroup(2, 4, true);
		table = tableGroups2.getListOfSingleGroups();
		boolean existsUser = tableGroups2.existUserOnGroup(3,6);
		tableGroups.changeGroup(3, 6, false);
		table = tableGroups2.getListOfSingleGroups();
		existsUser = tableGroups2.existUserOnGroup(3,6);
		existsUser = tableGroups2.existUserOnGroup(2,3);
		tableGroups.deleteUserFromAnyGroup(3);
		existsUser = tableGroups2.existUserOnGroup(2,3);
		existsUser = tableGroups2.existUserFromAnyGroup(3);
		existsUser = tableGroups2.existUserFromAnyGroup(4);
		assertNotNull(table);
	}
}
