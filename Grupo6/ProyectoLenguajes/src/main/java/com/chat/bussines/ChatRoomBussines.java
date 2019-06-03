package com.chat.bussines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.*;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
import com.chat.domain.Rooms;
import com.chat.domain.UserClient;

@Service
public class ChatRoomBussines {

	@Autowired
	private ChatRoomData chatRomData;

	@Autowired
	private MessageData messageData;
	
	@Autowired
	private UserData userData;

	public void addRom(ChatRoom chatRoom) {
		chatRomData.add(chatRoom);
	}

	public ArrayList<ChatRoom> getRoomsByGuess(String email, int room){

		ArrayList<ChatRoom> rooms = chatRomData.getRoomsByUserEmail(email, room);
		if(rooms.isEmpty()) {
			UserClient user = userData.getUserByEmail(email);
			if(user.getId() < 0) {
				userData.addUserClient(user);
			}else {
				user = userData.getUserByEmail(email);
			}
			chatRomData.addUserByChatRoom(room, user.getId(), 1);
		}
		return rooms;
	}


	public Iterator<ChatRoom> getRooms(){

		String img[] = {
				"https://i.ibb.co/VBv9d6q/lucky-egg.png","https://i.ibb.co/tL2x31d/lucky-eggs.png",
				    "https://i.ibb.co/pygvb9y/egg-incubator-1.png","https://i.ibb.co/ZS3q4f5/fight.png",
					"https://i.ibb.co/yyVc5HM/fist.png","https://i.ibb.co/Bcvddz2/gear.png",
					"https://i.ibb.co/WnFQRVH/gotcha.png","https://i.ibb.co/ccWG9L2/heart.png",
					"https://i.ibb.co/ZzLX3H0/hyper-potion.png","https://i.ibb.co/5BFTK5M/incense.png",
					"https://i.ibb.co/nfw0pkx/incenses.png","https://i.ibb.co/TrwHZ6K/incense-score.png",
					"https://i.ibb.co/WyD6r5N/insignia.png","https://i.ibb.co/K21r9qG/insignia-1.png",
					"https://i.ibb.co/GVYMrHx/instinct.png","https://i.ibb.co/F6jXyMS/instinct-1.png",
					"https://i.ibb.co/BqRPNxD/mega-ball.png","https://i.ibb.co/P46nWcM/money-bag.png",
					"https://i.ibb.co/hCnPJs6/mystic.png","https://i.ibb.co/CWcd6v4/mystic-1.png",
					"https://i.ibb.co/WfhVSSy/new.png","https://i.ibb.co/1GPyBkT/open-pokeball.png",
					"https://i.ibb.co/CHJ8gQ8/pikachu.png","https://i.ibb.co/rMGMr4t/pointer.png",
					"https://i.ibb.co/4dMz3GY/pokebag.png","https://i.ibb.co/zXFnsD8/pokeball.png",
					"https://i.ibb.co/LtkCm4y/pokeballs.png","https://i.ibb.co/h9ddsg6/pokecoin.png",
					"https://i.ibb.co/54tTDWM/pokecoins.png","https://i.ibb.co/dB1mRPz/pokecoins-1.png",
					"https://i.ibb.co/PCcXX4n/pokestop.png","https://i.ibb.co/hZbpWLN/pokestop-1.png",
					"https://i.ibb.co/NWqScpN/pokestop-2.png","https://i.ibb.co/rt61yF6/pokestop-3.png",
					"https://i.ibb.co/DLg4DXL/potion.png","https://i.ibb.co/34fhmHH/red-team.png",
					"https://i.ibb.co/N6TLmNn/smartphone.png","https://i.ibb.co/hsWxpnH/star.png",
					"https://i.ibb.co/3mynX85/star-1.png","https://i.ibb.co/nBsNtJT/superball.png",
					"https://i.ibb.co/cws7yFF/super-potion.png","https://i.ibb.co/HdMJ8w7/tornado.png",
					"https://i.ibb.co/rvCVfQm/tornado-1.png","https://i.ibb.co/jLfj7xT/ultra-ball.png",
					"https://i.ibb.co/wgV0BXn/up-arrow.png","https://i.ibb.co/RhM2tPy/valor-1.png"};


		ArrayList<ChatRoom> rooms = chatRomData.getRooms();
		for (ChatRoom chatRoom : rooms) {
			Random r = new Random();
			int min = 0;
			int max = 45;
			int valueAvatar = r.nextInt((max - min) + 1) + min;
			String avatar = img[valueAvatar];
			chatRoom.setAvatar(avatar);
			chatRoom.setListMessage(messageData.getMessages(chatRoom));
			System.out.println(chatRoom.toString());
		}
		return rooms.iterator();
	}

	public Iterator<Message> loadMessages(ChatRoom room){
		return messageData.getMessages(room).iterator();
	}

	public List<UserClient> listUser(ChatRoom room) {
		ArrayList<ChatRoom> rooms = chatRomData.getRooms();
		List<UserClient> users = new ArrayList<>();
		

		for (int i = 0; i < rooms.size(); i++) {

			if (room.getId() == rooms.get(i).getId()) {
				users = rooms.get(i).getListUsers();

			}

		}

		return users;

	}

}
