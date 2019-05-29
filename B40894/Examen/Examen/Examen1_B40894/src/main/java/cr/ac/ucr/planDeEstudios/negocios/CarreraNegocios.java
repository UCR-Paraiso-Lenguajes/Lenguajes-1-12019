package cr.ac.ucr.planDeEstudios.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.planDeEstudios.datos.CarreraDatos;
import cr.ac.ucr.planDeEstudios.dominio.Carrera;


@Service
public class CarreraNegocios {


	@Autowired
	private CarreraDatos carreraDatos;
	


	public List<Carrera> listarCarreras() {
		return carreraDatos.listarCarreras();
	}

}
