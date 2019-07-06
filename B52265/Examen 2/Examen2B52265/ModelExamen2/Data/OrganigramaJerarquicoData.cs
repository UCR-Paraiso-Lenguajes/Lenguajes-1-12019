using System;
using System.Collections.Generic;
using System.Text;
using ModelExamen2.Domain;
namespace ModelExamen2.Data
{
   public class OrganigramaJerarquicoData
    {
        public List<OrganigramaJerarquico> organigrama = new List<OrganigramaJerarquico>();
        public List<OrganigramaJerarquico> GetOrganigramasJerarquicos()
        {
            return this.organigrama;
        }
        public OrganigramaJerarquico GetOrganigramaPorId(int id)
        {
            OrganigramaJerarquico newOrganigrama = null;
            foreach (OrganigramaJerarquico organigramaJerarquico in this.organigrama)
            {
                if (organigramaJerarquico.ID == id)
                {
                    newOrganigrama = organigramaJerarquico;
                }
                else
                {
                    throw new Exception("No se encontro el departamento");
                }
            }
            return newOrganigrama;
        }
        public void InsertarOrganigrama(OrganigramaJerarquico organigrama)
        {
            this.organigrama.Add(organigrama);
        }
        public void ActualizarOrganigrama(OrganigramaJerarquico organigrama, int id)
        {
            OrganigramaJerarquico borrarOrganigrama = GetOrganigramaPorId(id);
            this.organigrama.Remove(borrarOrganigrama);
            this.organigrama.Add(organigrama);
        }
        public void BorrarOrganigrama(int id)
        {
            OrganigramaJerarquico borrarOrganigrama = GetOrganigramaPorId(id);
            this.organigrama.Remove(borrarOrganigrama);
        }
    
        public List<OrganigramaJerarquico> EstadoInicial()
        {
             List<OrganigramaJerarquico> organigramas = new List<OrganigramaJerarquico>();
             OrganigramaJerarquico organigramaJ = new OrganigramaJerarquico("Organigrama Examen");
            Departamentos departamento1 = new Departamentos("Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos("Gerente General", departamento1 );
            Departamentos departamento3 = new Departamentos("Departamento Administrativo", departamento2);
            Departamentos departamento4 = new Departamentos("Contabilidad", departamento3);
            Departamentos departamento5 = new Departamentos("Cartera", departamento3);
            Departamentos departamento6 = new Departamentos("Tesoreria", departamento3);
            Departamentos departamento7 = new Departamentos("Recursos Humanos", departamento3);
            Departamentos departamento8 = new Departamentos("Departamento Comercial", departamento2);
            Departamentos departamento9 = new Departamentos("Comprars Nacionales", departamento8);
            Departamentos departamento10 = new Departamentos("Importaciones", departamento8);
            Departamentos departamento11 = new Departamentos("Ventas", departamento8);
            Departamentos departamento12 = new Departamentos("Sede Principal", departamento11);
            Departamentos departamento13 = new Departamentos("Sucursales", departamento11);
            Departamentos departamento14 = new Departamentos("Web Site", departamento11);
            Departamentos departamento15 = new Departamentos("Departamento de Operaciones", departamento2);
            Departamentos departamento16 = new Departamentos("Bodegaje", departamento15);
            Departamentos departamento17 = new Departamentos("Reempaque", departamento15);
            Departamentos departamento18 = new Departamentos("Despachos", departamento15);
            organigramaJ.AgregarDepartamento(departamento1);
            organigramaJ.AgregarDepartamento(departamento2);
            organigramaJ.AgregarDepartamento(departamento3);
            organigramaJ.AgregarDepartamento(departamento4);
            organigramaJ.AgregarDepartamento(departamento5);
            organigramaJ.AgregarDepartamento(departamento6);
            organigramaJ.AgregarDepartamento(departamento7);
            organigramaJ.AgregarDepartamento(departamento8);
            organigramaJ.AgregarDepartamento(departamento9);
            organigramaJ.AgregarDepartamento(departamento10);
            organigramaJ.AgregarDepartamento(departamento11);
            organigramaJ.AgregarDepartamento(departamento12);
            organigramaJ.AgregarDepartamento(departamento13);
            organigramaJ.AgregarDepartamento(departamento14);
            organigramaJ.AgregarDepartamento(departamento15);
            organigramaJ.AgregarDepartamento(departamento16);
            organigramaJ.AgregarDepartamento(departamento17);
            organigramaJ.AgregarDepartamento(departamento18);

            organigramas.Add(organigramaJ);


            return organigramas;
        }
    }
}
