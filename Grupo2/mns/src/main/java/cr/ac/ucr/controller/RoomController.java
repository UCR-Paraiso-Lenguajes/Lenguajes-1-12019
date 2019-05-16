package cr.ac.ucr.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {




	@RequestMapping(value = "/createGrupo", method = RequestMethod.GET)
	public String showForm() throws SQLException {
		
			return "createGrupo";
		}
		
	}

	