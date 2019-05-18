package cr.ac.ucr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cr.ac.ucr.business.RecoverStateBusiness;



@SpringBootApplication
public class MnsApplication {
	@Autowired
	private static	RecoverStateBusiness reb;
	
	public static void main(String[] args) {
		SpringApplication.run(MnsApplication.class, args);
		//RecoverStateBusiness reb = new RecoverStateBusiness();
		reb.retrieveState();
	}

}
