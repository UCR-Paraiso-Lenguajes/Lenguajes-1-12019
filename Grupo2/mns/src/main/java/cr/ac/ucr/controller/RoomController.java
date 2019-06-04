package cr.ac.ucr.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cr.ac.ucr.business.RoomBusiness;
import cr.ac.ucr.domain.Room;
import cr.ac.ucr.domain.User;
import cr.ac.ucr.form.RoomForm;
import cr.ac.ucr.form.UserForm;


@Controller
public class RoomController {

	@Autowired
	private RoomBusiness roomBusiness;
	private static int id=0;
	

	@RequestMapping(value = "/createEmptyRoom", method = RequestMethod.GET)
	public String showFormEmptyRoom(Model model,RoomForm roomForm)  {
		
		    model.addAttribute("roomForm",roomForm);
			return "createEmptyRoom";
	}
	
	@RequestMapping(value = "/createEmptyRoom", method = RequestMethod.POST)
	public String save(@Valid RoomForm roomForm, BindingResult bindingResult, Model model) throws SQLException {
		
		Room room = new Room();
		BeanUtils.copyProperties(roomForm, room);
		System.out.println(roomForm.toString());
		System.out.println(room.toString());
//	     roomBusiness.save(roomForm.getName(), 3, 5, 5, 8);
//		
			return "chat";
	}
	
	
	@RequestMapping(value = "/createRoom", method = RequestMethod.GET)
	public String showForm(Model model)  {
			
		model.addAttribute("rooms", roomBusiness.staticRooms);
		
		return "createRoom";
	}
	
	
	@RequestMapping(value = "/createRoom", method = RequestMethod.POST)
	public String createRoom(Model model,RoomForm roomForm)  {
		
		model.addAttribute("rooms", roomBusiness.staticRooms);
		
		
		
		Room room = new Room(new User());
		room.setName(roomForm.getName());
		
		roomBusiness.addRoom(room);
		
		
		return "chat";
	}
	
	
	
}
	