package com.projectOne.interactiveMessaging.domain;

import java.util.ArrayList;
import java.util.List;

public class ClassListNewMessages {
	public static ArrayList<SingleGroupMessage> listOfSingleGroupMessages = new ArrayList<>();

	public ArrayList<SingleGroupMessage> getListOfSingleGroupMessages() {
		return listOfSingleGroupMessages;
	}

	public void setListOfSingleGroupMessages(ArrayList<SingleGroupMessage> listOfSingleGroupMessages) {
		ClassListNewMessages.listOfSingleGroupMessages = listOfSingleGroupMessages;
	}
	
	public void storeNewMessage(SingleGroupMessage message) {
		listOfSingleGroupMessages.add(message);
	}
	
	public ArrayList<SingleGroupMessage> extractLastMessages(int idGroup, int idUser) {
		ArrayList<SingleGroupMessage> subListOfSingleGroupMessages = new ArrayList<>();
		int position = 0;
		SingleGroupMessage singleGroupMessage;
		if( listOfSingleGroupMessages.size()!=0) {
			boolean cae = true;
		}
		for (int i = 0; i < listOfSingleGroupMessages.size(); i++) {
			singleGroupMessage = listOfSingleGroupMessages.get(i);
			if(singleGroupMessage.getIdGroup()==idGroup&&singleGroupMessage.getMessage().getUserTransmitter().getUser_id()!=idUser) {
				int sizeUsrsIds = singleGroupMessage.getUsersIDs().size();
				for (int j = 0; j < sizeUsrsIds; j++) {
					if(singleGroupMessage.getUsersIDs().get(j)==idUser) {
						subListOfSingleGroupMessages.add(singleGroupMessage);
						singleGroupMessage.getUsersIDs().remove(j);
						j = sizeUsrsIds;
					}
				}
				
				
				if(singleGroupMessage.getUsersIDs().size()==0) {
					listOfSingleGroupMessages.remove(position);
				}
				
			}
			
		}
		
		
		return subListOfSingleGroupMessages;
	}
}
