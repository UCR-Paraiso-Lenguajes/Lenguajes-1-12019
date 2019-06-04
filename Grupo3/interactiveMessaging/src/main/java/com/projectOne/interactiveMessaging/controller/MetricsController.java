package com.projectOne.interactiveMessaging.controller;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.bussines.UserBusiness;
import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;


@Controller
public class MetricsController {
	
	@Autowired
	private MetricsBusiness metricsBusiness;

	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private GroupData groupData;
	
	@RequestMapping(value="/metrics", method=RequestMethod.GET)
    public String metrics(Model model) {

//		Iterator<Metrics> metrics = metricsBusiness.recoverMetricsData();
//		model.addAttribute("metrics", metrics.next());
//		return "metrics";
		Metrics metrics = metricsBusiness.recoverMetricsData();

						model.addAttribute("idUserRoom",1);///Aqui cambiar el usuario
						//List<Room> groups = groupBusiness.getGroupsOfUser(4);///Aqui cambiar el id usuario
						Iterator<Room> groups = groupData.getGroups();
						model.addAttribute("groups",groups);
						
		//model.addAttribute("metrics", metrics.next());
		model.addAttribute("metrics", metrics);

		return "homeAdmi";
    }
	
	
	@RequestMapping(value="/metricsUser", method=RequestMethod.GET)
    public String metricsWhitUsers(Model model,  @RequestParam("group") int roomID) {

		Metrics metrics = metricsBusiness.recoverMetricsData();

						//model.addAttribute("idUserRoom",1);///Aqui cambiar el usuario
						//List<Room> groups = groupBusiness.getGroupsOfUser(4);///Aqui cambiar el id usuario
						//model.addAttribute("groups",groups);
						Iterator<User> users = userBusiness.findUsersCertainRoom(roomID);
						
		model.addAttribute("metrics", metrics);
		model.addAttribute("users", users);

		return "homeAdmiWhitUsers";
    }
	
	
	
}