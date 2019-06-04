package com.chat.controller.rest;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.data.MetricDat;
import com.chat.domain.ChatRoom;
import com.chat.domain.UserClient;

@RestController
public class MetricControllerRest {
	@Autowired
	private MetricDat metricData;
	
	@Autowired
	private ChatRoomBussines chatRoomBussines;
	
	@RequestMapping(value="api/Metric", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom()
	{
		metricData.getQuantityRooms();
		//metricData.addQuantityRoom();
	}
	@RequestMapping(value="api/MectricUser", method=RequestMethod.GET )
	public @ResponseBody Iterator<UserClient> listUser(@RequestBody ChatRoom chatRoom, HttpServletRequest servlet){
		HttpSession sesion = servlet.getSession();
		
		return chatRoomBussines.listUser(chatRoom).iterator();
	}
	
	/*
	@RequestMapping(value="api/Metric", method=RequestMethod.GET )
	public @ResponseBody void viewQuant()
	{
		metricData.getQuantityRooms();
	}*/
}
