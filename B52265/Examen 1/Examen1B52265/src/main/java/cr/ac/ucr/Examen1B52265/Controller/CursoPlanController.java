package cr.ac.ucr.Examen1B52265.Controller;

import cr.ac.ucr.Examen1B52265.Business.CursoPlanBusiness;
import cr.ac.ucr.Examen1B52265.Business.PlanesBusiness;
import cr.ac.ucr.Examen1B52265.Domain.Curso;
import cr.ac.ucr.Examen1B52265.Domain.CursosPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class CursoPlanController {
    @Autowired
    PlanesBusiness planesBusiness;
    @RequestMapping(value = "/verPlan", method = RequestMethod.GET)
    public String verPlan(Model model){
        ArrayList<Curso> cursos = new ArrayList<>();
        for (CursosPlan cursosPlan: planesBusiness.estadoIinicial()){
            if(cursosPlan.getCursosDelPlan().isEmpty()){
                System.out.println("si");
            }
           for(Curso auxCurso:cursosPlan.getCursosDelPlan()){
               cursos.add(auxCurso);
           }
        }
        model.addAttribute("cursos", cursos);
        return "verPlan";
    }
}
