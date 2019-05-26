package com.chat.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.data.MetricDat;
import com.chat.domain.ChatRoom;
import com.chat.domain.Metric;

@RestController
public class MetricControllerRest {
	@Autowired
	private MetricDat metricData;
	
	@RequestMapping(value="api/Metric", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom()
	{
		metricData.getQuantityRooms();
		//metricData.addQuantityRoom();
	}
	/*
	@RequestMapping(value="api/Metric", method=RequestMethod.GET )
	public @ResponseBody void viewQuant()
	{
		metricData.getQuantityRooms();
	}*/
}
