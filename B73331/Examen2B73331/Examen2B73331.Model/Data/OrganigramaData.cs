using Examen2B73331.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Data
{
    public class OrganigramaData
    {
        public OrganigramaData() { }
        private BDOrganigrama bdOrganigramas = new BDOrganigrama();
        public void organigramaMemoria()
        {
            DepartamentoRaiz departamentoRaiz = new DepartamentoRaiz(1,"Departamento Gerencial", false);
            Organigrama organigrama = new Organigrama(departamentoRaiz,1);

            organigrama.setDepartamentoLista(2,"Departamento Juridico",false, "Departamento Gerencial");
            organigrama.setDepartamentoLista(3, "Departamento Contaduria", false, "Departamento Gerencial");
            organigrama.setDepartamentoLista(4, "Departamento Admnistrativo", false, "Departamento Gerencial");

            organigrama.setDepartamentoLista(5, "Departamento Civil", false, "Departamento Juridico");
            organigrama.setDepartamentoLista(6, "Departamento Penal", false, "Departamento Juridico");
            organigrama.setDepartamentoLista(7, "Departamento Tierras", false, "Departamento Juridico");

            organigrama.setDepartamentoLista(8, "Departamento Auxiliar", false, "Departamento Contaduria");
            organigrama.setDepartamentoLista(9, "Departamento Facturas", false, "Departamento Contaduria");

            organigrama.setDepartamentoLista(10, "Departamento Secretariado", false, "Departamento Admnistrativo");

            organigrama.setDepartamentoLista(11, "Departamento Denuncias", false, "Departamento Penal");

            organigrama.setDepartamentoLista(12, "Departamento Laborales", false, "Departamento Denuncias");
            organigrama.setDepartamentoLista(13, "Departamento Domestico", false, "Departamento Denuncias");

            bdOrganigramas.append(organigrama);
        }
        public void crearOrganigrama(DepartamentoRaiz departamentoRaiz, int idOrganigrama)
        {
            Organigrama organigrama = new Organigrama(departamentoRaiz, idOrganigrama);
            bdOrganigramas.append(organigrama);
        }
        public List<Organigrama> getAll()
        {
            organigramaMemoria();
            return bdOrganigramas.getList();
        }
        public Organigrama getSpecifico(int idOrganigrama)
        {
            foreach (Organigrama organigrama in bdOrganigramas.getList())
            {
                if (organigrama.OrganigramaId == idOrganigrama) return organigrama;
            }
            return new Organigrama(new DepartamentoRaiz(1,"NO ENCONTRADO", false),555);
        }

    }
}
