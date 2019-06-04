package com.projectOne.interactiveMessaging.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectOne.interactiveMessaging.bussines.EmailBussines;
import com.projectOne.interactiveMessaging.bussines.GroupBusiness;
import com.projectOne.interactiveMessaging.bussines.MessageBusiness;
import com.projectOne.interactiveMessaging.bussines.UserBusiness;
import com.projectOne.interactiveMessaging.data.UserData;

import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;
import com.projectOne.interactiveMessaging.bussines.EmailBussines;
import com.projectOne.interactiveMessaging.form.EmailForm;

@Controller
public class HelloController {

	@Autowired
    private EmailBussines emailBussines;
	@Autowired

	private MessageBusiness messageBusiness;

	@Autowired

	private UserData userData;
	@Autowired
	private GroupBusiness groupBusiness;
	
	@Autowired
	private UserBusiness userBusiness;
	
	@RequestMapping("/")
    public String login() {
        return "loginAdmi";
    }
	
	@RequestMapping("/signIn")
    public String signIn() {
        return "loginUser";
    }

	
	//@PostMapping("/signIn")
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
    public String sendMail( @RequestParam("email") String mail){
    	String linkToParticipateInChat = "http://localhost:8080/msn/chat"; 
    	emailBussines.sendMail("soporte.soft.inc@gmail.com",mail,"Invitación\n","Te invitamos por medio de este link:   \n"+linkToParticipateInChat);

        return "loginUser";
    }
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
    public String chat(Model model) {

		ArrayList<Message> messages=

		messageBusiness.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(2),"LosMagnificosMessages",1);///Aqui cambiar el usuario y grupo
				model.addAttribute("messages",messages);
				model.addAttribute("idUserRoom",1);///Aqui cambiar el usuario
				List<Room> groups = groupBusiness.getGroupsOfUser(1);///Aqui cambiar el id usuario
				model.addAttribute("groups",groups);
        return "chat";
    }
	
	@RequestMapping(value="/chatSetting", method=RequestMethod.GET)
    public String chatSetting(Model model, @RequestParam("id") int id, @RequestParam("id_role") int id_role) {
		Iterator<User> user = userBusiness.findUsersOwnerOrAdmin(id, id_role);
		model.addAttribute("user", user);
        return "setting";
    }
	
	
	
	
	//enviar correos a varias personas!
		@RequestMapping(value="/invite", method=RequestMethod.GET )
		public String inviteGet(EmailForm emailForm, Model model) {
			model.addAttribute("emailForm", new EmailForm());
			model.addAttribute("idUserRoom",1);///Aqui cambiar el usuario
			List<Room> groups = groupBusiness.getGroupsOfUser(1);///Aqui cambiar el id usuario
			model.addAttribute("groups",groups);
	        return "invite";
	    }
		@RequestMapping(value="/invite", method=RequestMethod.POST )
		public String invitePost(@Valid EmailForm emailForm, BindingResult bindingResult, Model model, @RequestParam("nameGroup") String nameGroup) {
			if(bindingResult.hasErrors()) {
				model.addAttribute("emailForm", new EmailForm());
		        return "invite";
			}else {
				String linkChat = "";
				String[] emails = emailForm.getEmailsSel();
				for (int i = 0; i < emails.length; i++) {
		    		emailBussines.sendMail("soporte.soft.inc@gmail.com",emails[i],"Invitación a Chat",linkChat);
		    	}
				return "invite";
			}
		}
	  //fin enviar correos a varias personas 
	
}