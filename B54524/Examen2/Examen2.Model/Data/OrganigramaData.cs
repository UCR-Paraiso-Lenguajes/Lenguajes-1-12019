
using Examen2.Model.Domain;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen2.Model.Data
{
    public class OrganigramaData
    {
        private OrganigramaJerarquico organigrama;
        private Mock<OrganigramaJerarquico> mockOrganigrama;

        public OrganigramaData()
        {
            organigrama = new OrganigramaJerarquico();
            mockOrganigrama = new Mock<OrganigramaJerarquico>();
        }

        public void agregarOrganigrama(String nombreEmpresa, OrganigramaJerarquico organigrama)
        {
            organigrama.NombreEmpresa = nombreEmpresa;
            mockOrganigrama.Object.organigramasJerarquicos.Add(organigrama);    
        }

        public OrganigramaJerarquico buscarOrganigramaorId(int id)
        {
            OrganigramaJerarquico organigramaJerarquico = null;
            List<OrganigramaJerarquico> organigramas = mockOrganigrama.Object.organigramasJerarquicos;
            int cuentaOrganigrama = 0;
            foreach (OrganigramaJerarquico organigrama in mockOrganigrama.Object.organigramasJerarquicos)
            {
                if (organigramas.ElementAt(cuentaOrganigrama).IdOrganigrama == id)
                {
                    organigramaJerarquico = mockOrganigrama.Object.organigramasJerarquicos.ElementAt(cuentaOrganigrama);
                }
                cuentaOrganigrama++;
            }
            return organigramaJerarquico;
        }

        public void eliminarOrganigramaJerarquico(OrganigramaJerarquico OrganigramaJerarquico)
        {
            if (OrganigramaJerarquico == buscarOrganigramaorId(OrganigramaJerarquico.IdOrganigrama))
            {
                mockOrganigrama.Object.organigramasJerarquicos.Remove(OrganigramaJerarquico);
            }
        }
        public void modificarOrganigrama(OrganigramaJerarquico organigrama)
        {
            int cuentaDeptos = 0;
            foreach (OrganigramaJerarquico organ in mockOrganigrama.Object.organigramasJerarquicos)
            {
                if (mockOrganigrama.Object.organigramasJerarquicos.ElementAt(cuentaDeptos) == organigrama)
                {
                    mockOrganigrama.Object.organigramasJerarquicos.ElementAt(cuentaDeptos).NombreEmpresa = organigrama.NombreEmpresa;
                    mockOrganigrama.Object.organigramasJerarquicos.ElementAt(cuentaDeptos).organigramasJerarquicos = organigrama.organigramasJerarquicos;
                }
                cuentaDeptos++;
            }
        }

        public List<OrganigramaJerarquico> listar()
        {
            List<OrganigramaJerarquico> Organigramas = new List<OrganigramaJerarquico>();

            foreach (OrganigramaJerarquico organigrama in mockOrganigrama.Object.organigramasJerarquicos)
            {
                Organigramas.Add(organigrama);
            }

            return Organigramas;
        }



    }
}
