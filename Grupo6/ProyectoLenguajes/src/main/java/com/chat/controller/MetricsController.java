package com.chat.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.bussines.ChatRoomBussines;
import com.chat.bussines.MetricBussines;
import com.chat.data.MetricData;
import com.chat.data.MetricsData;

@Controller
public class MetricsController {

	@Autowired
	private ChatRoomBussines roomBusiness;

	@Autowired
	MetricsData metricsData;

	@RequestMapping(value = "/metric", method = RequestMethod.GET)
	public String metric(Model model) throws SQLException {

		model.addAttribute("rooms", roomBusiness.getRooms());

		model.addAttribute("firtsLogin", metricsData.firtsLogin());
		model.addAttribute("avgUser", 0);

		model.addAttribute("quantityRooms", metricsData.getQuantityRooms());
		model.addAttribute("quantityUser", metricsData.quantityUsers());
		model.addAttribute("lastMessage", metricsData.dateLastMessage());
		// model.addAttribute("lastGroup", metricsData.lastGroupCreated());
		model.addAttribute("lastGroup", 0);
		// model.addAttribute("longerMessage", metricsData.getLongerMessage());
		model.addAttribute("longerMessage", 0);
		model.addAttribute("moreGroup", metricsData.getGroupMoreMessage());
		// model.addAttribute("moreGroup",0);*/

		return "metric";
	}

	@RequestMapping(value = "/metric2", method = RequestMethod.GET)
	public String metric2(Model model) {
		return "metric2";
	}

}
