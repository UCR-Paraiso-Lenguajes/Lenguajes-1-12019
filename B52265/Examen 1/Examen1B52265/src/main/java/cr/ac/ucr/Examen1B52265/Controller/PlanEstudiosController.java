package cr.ac.ucr.Examen1B52265.Controller;

import cr.ac.ucr.Examen1B52265.Business.PlanesBusiness;
import cr.ac.ucr.Examen1B52265.Domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ucr/api/carreras")
public class PlanEstudiosController {

    @Autowired
    PlanesBusiness planes;

    @GetMapping("/{carrera}")
    public ResponseEntity<ArrayList<Plan>> buscarPlanPorNombre(@PathVariable("carrera") final String nombrePlan){
    ArrayList<Plan> planBuscado = buscarPlan(nombrePlan);
        return new ResponseEntity<ArrayList<Plan>>(planBuscado, HttpStatus.OK);
    }
    public ArrayList<Plan> buscarPlan(String planName){
        ArrayList<Plan> allPlan = planes.getPlanes();
        ArrayList<Plan> planEncontrado = new ArrayList<Plan>();
        for(Plan plan:allPlan){
        if(plan.getNombre().equals(planName)){
            planEncontrado.add(plan);
        }
        }
        return planEncontrado;
    }
    @PostMapping(value="/insertPlan")
    public ResponseEntity<Plan> crearPlan(@RequestBody final Plan planNuevo){
        Plan nuevoPlan= null;
            planes.getPlanes().add(nuevoPlan);
        return new ResponseEntity<Plan>(nuevoPlan,HttpStatus.CREATED);
    }

    @PutMapping(value="/{carrera}/{id}/actualizarPlan")
    public ResponseEntity<Plan> actualizarPlan(@RequestBody  final Plan actualizaPlan, @PathVariable("id") final int  idPlan){
        Plan planActualizar=null;
        ArrayList<Plan> allPlan = planes.getPlanes();
        for(Plan plan: allPlan) {
            if (plan.getId() == idPlan) {
                plan.setNombre(actualizaPlan.getNombre());
                planes.setPlanes(allPlan);
            }
        }
        return new ResponseEntity<Plan>( planActualizar,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{carrera}")
    public ResponseEntity<Plan> borrarPlan(@PathVariable("carrera") final String  carrera){
        ArrayList<Plan> allPlan = planes.getPlanes();
        for(Plan plane: allPlan){
            if(plane.getNombre()==carrera){
                planes.getPlanes().remove(plane);
            }
        }
        return new ResponseEntity<Plan>(HttpStatus.NO_CONTENT);
    }
}
