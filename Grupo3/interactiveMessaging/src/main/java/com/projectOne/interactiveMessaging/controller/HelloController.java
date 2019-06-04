package com.projectOne.interactiveMessaging.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.projectOne.interactiveMessaging.bussines.EmailBussines;
import com.projectOne.interactiveMessaging.bussines.GroupBusiness;
import com.projectOne.interactiveMessaging.bussines.UserBusiness;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.form.EmailForm;

@Controller
public class HelloController {

	@Autowired
    private EmailBussines emailBussines;

	@Autowired
	private GroupBusiness groupBusiness;
	
	@Autowired
	private UserBusiness userBusiness;
	
	@Autowired
	private MetricsController metricsController;
	
	@RequestMapping("/")
    public String login() {
        return "loginAdmi";
    }
	
	@PostMapping("/")
	public String loginAdmin(@RequestParam("email") String mail,@RequestParam("password") String password,Model model) {
		
		if(mail.equalsIgnoreCase("soporte.soft.inc@gmail.com") && password.equalsIgnoreCase("grupo3info")) {
			return metricsController.metrics(model);
		}else
		
		return "errorPage";
	}
	
	
	@RequestMapping("/signIn")
    public String signIn() {
        return "loginUser";
    }

    
    
	@PostMapping("/signIn")
    public String sendMail( @RequestParam("email") String mail){
    	String ip="192.168.1.120";
    	int idUser = userBusiness.save(mail);
    	String linkToParticipateInChat = "http://"+ip+":8080/msn/chat?idUser="+idUser; 
    	emailBussines.sendMail("soporte.soft.inc@gmail.com",mail,"Invitación\n","Te invitamos por medio de este link:   \n"+linkToParticipateInChat);

        return "loginUser";
    }
	
	
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
    public String chat(Model model, @RequestParam("idUser") int idUser) {

		//ArrayList<Message> messages=

		//messageBusiness.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(2),"LosMagnificosMessages",idUser);///Aqui cambiar el usuario y grupo
		//model.addAttribute("messages",messages);
		model.addAttribute("idUserRoom",idUser);///Aqui cambiar el usuario
		List<Room> groups = groupBusiness.getGroupsOfUser(idUser);///Aqui cambiar el id usuario
		model.addAttribute("groups",groups);
        return "chat";
    }
	
	
	@RequestMapping(value="/invite", method=RequestMethod.POST )
	public String invitePost(@Valid EmailForm emailForm, BindingResult bindingResult, Model model, @RequestParam("nameGroup") String nameGroup)  {
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
		public String inviteGet(EmailForm emailForm, Model model,@RequestParam("idUserRoom") int idUser) {
			model.addAttribute("emailForm", new EmailForm());
			model.addAttribute("idUserRoom",idUser);///Aqui cambiar el usuario
			List<Room> groups = groupBusiness.getGroupsOfUser(idUser);///Aqui cambiar el id usuario
			model.addAttribute("groups",groups);
	        return "invite";
	    }
		
	  //fin enviar correos a varias personas 
	
}