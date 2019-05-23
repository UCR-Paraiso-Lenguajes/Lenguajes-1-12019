package cr.ac.ucr.controller.rest;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.business.MessageBusiness;
import cr.ac.ucr.domain.Message;

@RestController
public class MessageControllerRest {
	@Autowired
	private MessageBusiness messageBusiness;	

 	@RequestMapping(value="/api/insertMessage", method=RequestMethod.PUT )
	public @ResponseBody void insertMessage(
			@RequestBody Message message) throws SQLException
	{
 		messageBusiness.insertMessage(message);
	}

}
