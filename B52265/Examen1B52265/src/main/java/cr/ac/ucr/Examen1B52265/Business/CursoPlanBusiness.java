package cr.ac.ucr.Examen1B52265.Business;

import cr.ac.ucr.Examen1B52265.Domain.Curso;
import cr.ac.ucr.Examen1B52265.Domain.CursosPlan;
import cr.ac.ucr.Examen1B52265.Domain.Plan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CursoPlanBusiness {
    CursosPlan cursosPlan;

    public ArrayList<Curso> getCursos(){
        return cursosPlan.getCursosDelPlan();
    }
}
