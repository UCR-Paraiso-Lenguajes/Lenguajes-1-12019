package ControllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Business.PlanEstudiosBusiness;

@RestController
public class PlanEstudiosControllerRest {

	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;
	
	@RequestMapping(value="/api/planEstudios", method=RequestMethod.GET)
	public @ResponseBody void verPlan(
			) {
		
	}
}
