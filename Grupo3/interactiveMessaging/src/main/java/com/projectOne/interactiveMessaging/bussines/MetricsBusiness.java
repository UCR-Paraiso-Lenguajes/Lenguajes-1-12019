package com.projectOne.interactiveMessaging.bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.data.UserData;
import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class MetricsBusiness {
	
	@Autowired
	private MetricsData metricsData;
	@Autowired
	private GroupData groupData;
	@Autowired
	private UserData userData;
	Metrics metrics = Metrics.getInstance();
	
//	public Metrics recoverMetricsData(){
//		return metricsData.recoverMetricsData();
//	}
	
	public Metrics findMetrics(int idMetrics) {
		return metricsData.findMetrics(idMetrics);
	}
	/**
	 * Este metodo se debe de llamar cada vez que se envie y guarde en nuevo mensaje a la base
	 * compara el mensaje nuevo que se envia con el que esta en base de datos paraver si es el mas
	 * extenso o no
	 * @param newMessage
	 */
	public void updateMessageMetrics(String newMessage) {
		if(metrics.compareLongerMessage(newMessage)) {
			metrics.setLongestMessage(newMessage); 
			//TODO falta que vuleva a guardar en la base, ya actualiza ahora guarde
		}
	}
	/**
	 * Metodo que actualiza la cantidad de usuarios de la aplicacion
	 */
	public void updateNumbersOfUsers() {
		int contUsers = 0;
		Iterator<User> usersAll=userData.findAllTheUsers();
		while(usersAll.hasNext()) {
			contUsers++;
			usersAll.next();
		}
		metrics.setNumberOfUsers(contUsers);;
	}
	/**
	 * Metodo cuenta la cantidad de grupos creados en la aplicacion, TODOS los grupos
	 */
	public void updateNumbersOfRooms() {
		int contGroup = 0;
		Iterator<Room> roomsGeneral=groupData.getGroups();
		while(roomsGeneral.hasNext()) {
			contGroup++;
			roomsGeneral.next();
		}
		metrics.setNumberOfRooms(contGroup);
	}
	/**
	 * Metodo debe ser llamado cuando se cree un nuevo grupoo se elimine algun usuario de del grupo
	 * @param sumOfUsers
	 */
	public void updateAverageOfUsersPerRoom(int sumOfUsers) {
		metrics.setSumOfUsersPerGroup(sumOfUsers + 14/*metrics.getSumOfUsersPerGroup()*/);
		float average = metrics.getSumOfUsersPerGroup() / 5 /*metrics.getNumberOfRooms()*/ ;
		metrics.setAverageOfUsersPerRoom(average);
	}
	/**
	 *
	 * actualiza la fecha de cada ultimo mensaje
	 * debe ser llamado cada que se realice el ultimo mensaje
	 * @param newDate
	 */
	public void updateDateLastMessage(Timestamp newDate) {
			metrics.setDateLastMessage(newDate);
	}
	/**
	 * Metodo busca la fecha de login del primer usuario
	 * a conveniencia se tomara la fecha del grupo apenas se crea
	 * por tanto debe de ser llamado cuando se crea un nuevo grupo
	 * se debe llamar cuandocargue la app
	 * @param dateFirstLogin
	 */
	public void updateDateFirstLogin() {
		List<Room> rooms = new ArrayList<>(); 
		groupData.getGroups().forEachRemaining(rooms::add);
		metrics.setDateFirstLogin(rooms.get(0).getDateCreate());
	}
	
	/**
	 * Metodo debe de ser llamado cuando se accione el boton de ver metricas
	 */
	public void updateLastGroupCreate() {
		List<Room> rooms = new ArrayList<>(); 
		groupData.getGroups().forEachRemaining(rooms::add);
		metrics.setLastRoomCreated(rooms.get(rooms.size()-1).getName_Room());
	}
	
}