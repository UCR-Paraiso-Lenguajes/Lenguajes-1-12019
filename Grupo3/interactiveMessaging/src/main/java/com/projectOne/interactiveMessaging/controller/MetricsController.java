package com.projectOne.interactiveMessaging.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.projectOne.interactiveMessaging.bussines.GroupBusiness;
import com.projectOne.interactiveMessaging.bussines.MessageBusiness;
import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.bussines.UserBusiness;
import com.projectOne.interactiveMessaging.data.UserData;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;


@Controller
public class MetricsController {
	
	@Autowired
	private UserData userData;
	
	@Autowired
	private GroupBusiness groupBusiness;
	
	@Autowired
	private MessageBusiness messageBusiness;
	
	@Autowired
	private MetricsBusiness metricsBusiness;
	
	@RequestMapping(value="/metrics", method=RequestMethod.GET)
    public String metrics(Model model) {
		Iterator<Metrics> metrics = metricsBusiness.recoverMetricsData();
		
		ArrayList<Message> messages=

				messageBusiness.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(2),"LosMagnificosMessages",1);///Aqui cambiar el usuario y grupo
						model.addAttribute("messages",messages);
						model.addAttribute("idUserRoom",1);///Aqui cambiar el usuario
						List<Room> groups = groupBusiness.getGroupsOfUser(1);///Aqui cambiar el id usuario
						model.addAttribute("groups",groups);
		
		model.addAttribute("metrics", metrics.next());
		return "homeAdmi";
    }
}
