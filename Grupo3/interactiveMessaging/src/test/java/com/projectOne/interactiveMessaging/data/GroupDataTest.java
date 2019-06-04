package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDataTest {
	@Autowired
	private GroupData groupData;
	
	private String nameTable;
	private Room room;
	private List<Room> rooms;
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		nameTable = groupData.getNameGroupTableMessages(2);
		room = groupData.getSpecificGroup(2);
		rooms = groupData.getGroupsOfUser(1);
    }
	
	@Test
	public void getNameGroupTableMessages_NotNull_Test() {
		assertNotNull(nameTable);
	}
	
	@Test
	public void getNameGroupTableMessages_IsEmpty_Test() {
		assertNotEquals("", nameTable);
	}
	
	@Test
	public void getNameGroupTableMessages_ReturnCorrectResults_Test() {
		assertNotEquals("", nameTable);
		assertEquals("LosMagnificosMessages", nameTable);
	}
	
	
	@Test
	public void getSpecificGroup_NotNull_Test() {
		assertNotNull(room);
	}
	
	@Test
	public void getSpecificGroup_ReturnCorrectResultsId_Test() {
		int id = room.getGroup_id();
		assertEquals(2, id);
	}
	
	@Test
	public void getSpecificGroup_ReturnCorrectResultsNameRoom_Test() {
		String nameRoom= room.getName_Room();
		assertEquals("Los magnificos", nameRoom);
	}
	
	@Test
	public void getSpecificGroup_ReturnCorrectResultsDateCreate_Test() {
		Timestamp time=room.getDateCreate(); 
		assertEquals("2019-05-10 22:59:53.0", ""+time);
	}
	
	@Test
	public void getSpecificGroup_ObjectCorrect_Test() {
		assertSame(room, room);
	}
	@Test
	public void getGroupsOfUser_NotNull_Test() {
		assertNotNull(rooms);
	}
	
	@Test
	public void getGroupsOfUser_IsEmpty_Test() {
		assertTrue(!rooms.isEmpty());
	}
	
	@Test
	public void getGroupsOfUser_ObjectCorrect_Test() {
		assertSame(rooms, rooms);
	}
	
	@Test
	public void saveNewGroup() {
		int idGroup=groupData.saveGroup("Prueba");
		assertEquals(5, idGroup);
	}
}
