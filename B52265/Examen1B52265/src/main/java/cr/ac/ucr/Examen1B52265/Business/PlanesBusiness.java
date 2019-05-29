package cr.ac.ucr.Examen1B52265.Business;

import cr.ac.ucr.Examen1B52265.Domain.Plan;
import cr.ac.ucr.Examen1B52265.Domain.Planes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlanesBusiness {

   private Planes planes;


    public ArrayList<Plan> getPlanes(){
        return planes.getPlanes();
    }

    public void setPlanes(ArrayList<Plan> plan){
        planes.setPlanes(plan);
    }
}
