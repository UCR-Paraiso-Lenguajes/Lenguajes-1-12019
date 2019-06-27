package cr.ac.ucr.Examen1B52265.Business;

import cr.ac.ucr.Examen1B52265.Domain.Curso;
import cr.ac.ucr.Examen1B52265.Domain.CursosPlan;
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

    public ArrayList<CursosPlan> estadoIinicial(){
        ArrayList<Curso> cursos = new ArrayList<>();
        //plan
        Plan plan = new Plan(1,"Innovacion de la UCR");
        //estretegia e innovacion
        Curso curso1 = new Curso(1,"Teoria Organizacional", "TO", 3, null,true,false);
        Curso curso2 = new Curso(2,"Gestion Publica", "GP", 3, "TO",false,false);
        Curso curso3 = new Curso(3,"Gestion Social", "GS", 3, null,false,false);
        Curso curso4 = new Curso(4,"Gestion de Proyectos", "GEP", 4, null,false,false);
        Curso curso5 = new Curso(5,"Gestion Estrategica", "GES", 4, "GP",false,false);
        Curso curso6 = new Curso(6,"Plan De Negocios", "PN", 4, "GES",false,true);
    //analisis e investigacion
        Curso curso7 = new Curso(7,"Metodos de investigacion cualitativa", "MIC", 4, null,true,false);
        Curso curso8 = new Curso(8,"Bases Legales para la Gestion", "BLG", 5, "MIC",false,false);
        Curso curso9 = new Curso(9,"Seminario de Investigacion", "SI", 3, "BLG",false,false);
        Curso curso10 = new Curso(10,"Seminario de Investigacion II", "SI2", 4, "SI",false,true);
        Curso curso11 = new Curso(11,"Metodos de Investigacion Cualitativa", "MEIC", 3, null,true,false);
        Curso curso12 = new Curso(12,"Economia Aplicada a la Gestion", "EAG", 3, null,true,false);
        Curso curso13 = new Curso(13,"Economia Aplicada a la Gestion II", "EAG2", 4, "EAG",false,false);
        //Habilidades Gerenciales
        Curso curso14 = new Curso(14,"Taller de Habilidades Gerenciales", "THG", 2, null,true,false);
        Curso curso15 = new Curso(15,"Taller de Habilidades Gerenciales 2", "THG2", 2, "THG",false,false);
        Curso curso16 = new Curso(16,"Taller de Habilidades Gerenciales 3", "THG3", 2, "THG2",false,true);
        //Etica y sostenibilidad
        Curso curso17 = new Curso(17,"Etica de Gestion", "EG", 2, null,true,false);
        Curso curso18 = new Curso(18,"Desarrollo  y Responsabilidad Social", "DRS", 3, "EG",false,true);
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);
        cursos.add(curso7);
        cursos.add(curso8);
        cursos.add(curso9);
        cursos.add(curso10);
        cursos.add(curso11);
        cursos.add(curso12);
        cursos.add(curso13);
        cursos.add(curso14);
        cursos.add(curso15);
        cursos.add(curso16);
        cursos.add(curso17);
        cursos.add(curso18);
        CursosPlan cursosPlan1  = new CursosPlan(plan,cursos);



        ArrayList<CursosPlan> cursosPlans = new ArrayList<>();

        cursosPlans.add(cursosPlan1);

        return cursosPlans;
    }

}
