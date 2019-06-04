package com.projectOne.interactiveMessaging.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import java.net.*;

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
	
	@PostMapping("/")
	public String loginAdmin(@RequestParam("email") String mail,@RequestParam("password") String password) {
		
		if(mail.equalsIgnoreCase("soporte.soft.inc@gmail.com") && password.equalsIgnoreCase("grupo3info")) {
			return "chat";
		}else
		
		return "loginAdmi";
	}
	
	
	@RequestMapping("/signIn")
    public String signIn() {
        return "loginUser";
    }

    @PostMapping("/signIn")
    public String sendMail( @RequestParam("email") String mail){

       emailBussines.sendMail("soporte.soft.inc@gmail.com",mail,"Invitacion","te invitamos por medio de este link:   ");

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
	
	@RequestMapping(value="/invite", method=RequestMethod.POST )
	public String invitePost(@Valid EmailForm emailForm, BindingResult bindingResult, Model model, @RequestParam("nameGroup") String nameGroup) throws UnknownHostException {
		if(bindingResult.hasErrors()) {
			model.addAttribute("emailForm", new EmailForm());
	        return "invite";
		}else {
			String ip = "192.168.1.120";
			String[] emails = emailForm.getEmailsSel();
			int idGroup = groupBusiness.saveGroup(nameGroup);
			int idUser;
			for (int i = 0; i < emails.length; i++) {
				idUser = userBusiness.save(emails[i]);
				groupBusiness.saveUserRoleRoom(idUser,3,idGroup);
				String linkChat = "http://"+ip+":8080/msn/chat?idUser="+idUser;
	    		emailBussines.sendMail("soporte.soft.inc@gmail.com",emails[i],"Invitación a Chat\n",linkChat);
	    	}
			return "invite";
		}
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
		
	  //fin enviar correos a varias personas 
	
}