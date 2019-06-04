package com.projectOne.interactiveMessaging.domain;

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
		tableGroups.chargeEmptyTable();
		//groupBusiness.chargeUserGroupTable();
		ArrayList<GroupUser> table = tableGroups2.getListOfSingleGroups();
	}
}
