using ExamenPriscilla.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExamenPriscilla.Data
{
    public class OrganigramaData
    {
        public List<Organigrama> organigramas;

        public OrganigramaData(List<Organigrama> organigramas)
        {
            this.organigramas = organigramas;
        }

        public OrganigramaData()
        {
            this.organigramas = new List<Organigrama>();

            List<Departamento> departamentos = new List<Departamento>();
            Departamento d1 = new Departamento("asamblea socios", "1", false);
            Departamento d2 = new Departamento(d1, "gerente general", "2", false);
            Departamento d3 = new Departamento(d2, "dpto administrativo", "3", false);
            Departamento d4 = new Departamento(d2, "dpto comercial", "4", false);
            Departamento d5 = new Departamento(d2, "dpto de operaciones", "5", false);

            departamentos.Add(d1);
            departamentos.Add(d2);
            departamentos.Add(d3);
            departamentos.Add(d4);
            departamentos.Add(d5);

            Organigrama organigrama = new Organigrama("organigramaprueba1", 1);
            Organigrama organigrama2 = new Organigrama(departamentos,"organigramaprueba2", 2);

            organigramas.Add(organigrama);
            organigramas.Add(organigrama2);

        }

        public Organigrama agregarOrganigrama(Organigrama organigrama)
        {
            organigramas.Add(organigrama);
            return organigrama;
        }

        public List<Organigrama> obtenerOrganigramas()
        {
            return organigramas;
        }

        public Organigrama obtenerOrganigrama(int id)
        {
            foreach (var org in organigramas)
                if (org.id == id)
                    return org;
            return null;


        }

        public Organigrama actualizarOrganigrama(int id, Organigrama organigrama)
        {
            List<Organigrama> orgAct = organigramas;

            Organigrama nuevo = organigrama;
            nuevo.id = id;
            organigramas.Add(nuevo);
            foreach (var depto in orgAct)
                if (depto.id == id)
                    orgAct.Remove(item: depto);

            return nuevo;


        }


        public void eliminarOrganigrama(int id)
        {
            List<Organigrama> orgAct = organigramas;

            foreach (var org in orgAct)
                if (org.id == id)
                    orgAct.Remove(item: org);


            organigramas = orgAct;





        }
    }
}
