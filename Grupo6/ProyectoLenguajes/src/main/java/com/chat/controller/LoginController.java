package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.data.ChatRomData;
import com.chat.data.MetricDat;
import com.chat.domain.ChatRoom;


@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model)
	{
		/*MetricData metricData = new MetricData();
		int cantidad=0;
		cantidad = metricData.getQuantityRooms();
		System.out.println(cantidad);*/

		return "login";
    }

	@RequestMapping(value="/loginAdmin", method=RequestMethod.GET)
    public String loginAdmin(Model model)
	{
		return "loginAdmin";
    }
	
	@RequestMapping(value = "/admin/metrics", method = RequestMethod.POST)
	public String loginAdmin(String username, String password, Model model) {

	model.addAttribute("username", username);
	model.addAttribute("password", password);
	System.out.println(username + password);
	if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456")) {

	return "metric";
	}

	return "loginAdmin";
	}

}
