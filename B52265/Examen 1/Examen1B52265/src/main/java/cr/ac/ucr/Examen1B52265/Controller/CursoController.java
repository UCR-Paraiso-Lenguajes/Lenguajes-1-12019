package cr.ac.ucr.Examen1B52265.Controller;

import cr.ac.ucr.Examen1B52265.Business.CursoPlanBusiness;
import cr.ac.ucr.Examen1B52265.Business.PlanesBusiness;
import cr.ac.ucr.Examen1B52265.Domain.Curso;
import cr.ac.ucr.Examen1B52265.Domain.CursosPlan;
import cr.ac.ucr.Examen1B52265.Domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("ucr/api/cursos")
public class CursoController {
    @Autowired
    CursoPlanBusiness cursoPlan;
    @Autowired
    PlanesBusiness planes;

    ArrayList<CursosPlan> cursosPlans = new ArrayList<>();
    @GetMapping("/{carrera}/{curso}")
    public ResponseEntity<ArrayList<Curso>> buscarPlanPorNombre(@PathVariable("curso") final String nombreCurso, @PathVariable("carrera")final String carrera){
        ArrayList<Curso> cursoBuscado = buscarCursoPorPlan(nombreCurso);
        return new ResponseEntity<ArrayList<Curso>>(cursoBuscado, HttpStatus.OK);
    }
    public ArrayList<Curso> buscarCursoPorPlan(String planName){
        ArrayList<Curso> cursosPlan = cursoPlan.getCursos();
        ArrayList<Curso> cursoEncontrado = new ArrayList<Curso>();
        for(Curso curso:cursosPlan){
            if(curso.getNombre().equals(planName)){
                cursoEncontrado.add(curso);
                break;
            }
        }

        return cursoEncontrado;
    }
    @PostMapping(value="/{carrera}/insertCursoPorPlan")
    public ResponseEntity<Curso> crearPlan(@RequestBody final Curso cursoNuevo, @PathVariable("carrera")final String carrera){
        Curso curso = null;
        ArrayList<Plan> allPlan = planes.getPlanes();
        ArrayList<Curso> cursoNew = cursoPlan.getCursos();
        if(cursoNew.contains(cursoNuevo)){
            new RuntimeException("Curso ya existe");
        }else{
        cursoNew.add(cursoNuevo);
        }
        for(Plan plan: allPlan){
            if(plan.getNombre().equals(carrera)){
                cursoPlan.insertaCurso(plan,cursoNew);
            }
        }
        return new ResponseEntity<Curso>(curso,HttpStatus.CREATED);
    }

    @PutMapping(value="/{carrera}/{idCurso}/actualizarCurso")
    public ResponseEntity<Curso> actualizarPlan(@RequestBody  final Curso actualizaCurso,@PathVariable("carrera")final String carrera,@PathVariable("idCurso")final int idCurso){
        Curso cursoAAcutalizar=null;
        ArrayList<Plan> allPlan = planes.getPlanes();
        for(Plan plan: allPlan){
            if(plan.getNombre().equals(carrera)){
                for(Curso curso: cursoPlan.getCursos()){
                    if(curso.getId()==idCurso){
                        curso.setNombre(actualizaCurso.getNombre());
                        curso.setCreditos(actualizaCurso.getCreditos());
                        curso.setCursoFinal(actualizaCurso.isCursoFinal());
                        curso.setCursoInicial(actualizaCurso.isCursoInicial());
                        curso.setSiglas(actualizaCurso.getSiglas());
                        curso.setRequisitoSigla(actualizaCurso.getRequisitoSigla());

                    }
                }
                planes.setPlanes(allPlan);
            }
        }

        return new ResponseEntity<Curso>( cursoAAcutalizar,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{carrera}/{curso}")
    public ResponseEntity<Curso> borrarPlan(@PathVariable("id") final Integer idPlan, @PathVariable("carrera")final String carrera){
        ArrayList<Plan> allPlan = planes.getPlanes();
        for(Plan plane: allPlan){
            if(plane.getNombre().equals(carrera)){
                planes.getPlanes();
            }
        }
        return new ResponseEntity<Curso>(HttpStatus.NO_CONTENT);
    }
}
