using System;
using System.Collections.Generic;
using System.Text;
using model.Domain;

namespace model.Data
{
   public class OrganigramaJerarquicoData
    {
       public List<Organigrama_Jerarquico> organigrama_Jerarquico = new List<Organigrama_Jerarquico>();

        /*public OrganigramaJerarquicoData()
        {
            this.organigrama_Jerarquico = Llenar();
        }
        */

        public IEnumerable<Organigrama_Jerarquico> GetListOrganigramaJerarquico()
        {
            return organigrama_Jerarquico;

        }

        public Organigrama_Jerarquico GetListOrganigramaJerarquicoByID(int id)
        {
            Organigrama_Jerarquico newOrganigramaJerarquico = null;
            bool encontrado = false;
            foreach (Organigrama_Jerarquico organigramaJerarquico in this.organigrama_Jerarquico)
            {

                if (organigramaJerarquico.IdOrganigrama == id && encontrado == false)
                {
                    newOrganigramaJerarquico = organigramaJerarquico;
                    encontrado = true;
                }
                

            }

            if (newOrganigramaJerarquico != null)
            {
                return newOrganigramaJerarquico;
            }
            else
            {
                throw new Exception("El organigrama no fue encontrado");
            }
        }

        public void InsertOrganigramaJerarquico(Organigrama_Jerarquico organigrama_Jerarquico)
        {
            this.organigrama_Jerarquico.Add(organigrama_Jerarquico);
        }


        public void EditOrganigramaJerarquico(Organigrama_Jerarquico organigrama_Jerarquico, int id)
        {
            Organigrama_Jerarquico borrarOrganigrama = GetListOrganigramaJerarquicoByID(id);
            this.organigrama_Jerarquico.Remove(borrarOrganigrama);
            this.organigrama_Jerarquico.Add(organigrama_Jerarquico);
        }

        public void DeleteOrganigramaJerarquico(int id)
        {
            Organigrama_Jerarquico borrarOrganigrama = GetListOrganigramaJerarquicoByID(id);
            this.organigrama_Jerarquico.Remove(borrarOrganigrama);

        }

        public List<Organigrama_Jerarquico> Llenar()
        {

            List<Organigrama_Jerarquico> organigramas = new List<Organigrama_Jerarquico>();
            Organigrama_Jerarquico organigrama = new Organigrama_Jerarquico(1, "UCR");
            Departamentos departamento1 = new Departamentos(1, "Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos(2, "Gerente General", departamento1);
            Departamentos departamento3 = new Departamentos(3, "Departamento Administrativo", departamento2);
            Departamentos departamento4 = new Departamentos(4, "Contabilidad", departamento3);
            Departamentos departamento5 = new Departamentos(5, "Cartera", departamento3);
            Departamentos departamento6 = new Departamentos(6, "Tesoreria", departamento3);
            Departamentos departamento7 = new Departamentos(7, "Recursos Humanos", departamento3);
            Departamentos departamento8 = new Departamentos(8, "Departamento Comercial", departamento2);
            Departamentos departamento9 = new Departamentos(9, "Comprars Nacionales", departamento8);
            Departamentos departamento10 = new Departamentos(10, "Importaciones", departamento8);
            Departamentos departamento11 = new Departamentos(11, "Ventas", departamento8);
            Departamentos departamento12 = new Departamentos(12, "Sede Principal", departamento11);
            Departamentos departamento13 = new Departamentos(13, "Sucursales", departamento11);
            Departamentos departamento14 = new Departamentos(14, "Web Site", departamento11);
            Departamentos departamento15 = new Departamentos(15, "Departamento de Operaciones", departamento2);
            Departamentos departamento16 = new Departamentos(16, "Bodegaje", departamento15);
            Departamentos departamento17 = new Departamentos(17, "Reempaque", departamento15);
            Departamentos departamento18 = new Departamentos(18, "Despachos", departamento15);
            organigrama.DepartamentosAgregar(departamento1);
            organigrama.DepartamentosAgregar(departamento2);
            organigrama.DepartamentosAgregar(departamento3);
            organigrama.DepartamentosAgregar(departamento4);
            organigrama.DepartamentosAgregar(departamento5);
            organigrama.DepartamentosAgregar(departamento6);
            organigrama.DepartamentosAgregar(departamento7);
            organigrama.DepartamentosAgregar(departamento8);
            organigrama.DepartamentosAgregar(departamento9);
            organigrama.DepartamentosAgregar(departamento10);
            organigrama.DepartamentosAgregar(departamento11);
            organigrama.DepartamentosAgregar(departamento12);
            organigrama.DepartamentosAgregar(departamento13);
            organigrama.DepartamentosAgregar(departamento14);
            organigrama.DepartamentosAgregar(departamento15);
            organigrama.DepartamentosAgregar(departamento16);
            organigrama.DepartamentosAgregar(departamento17);
            organigrama.DepartamentosAgregar(departamento18);

            organigramas.Add(organigrama);


            return organigramas;
        }

    }
}
