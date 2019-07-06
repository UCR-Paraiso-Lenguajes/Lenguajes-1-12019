using System;
using System.Collections.Generic;
using System.Text;
using Examen2_Clases.Data;
using Examen2_Clases.Domain;

namespace Examen2_Clases.Business
{
    public class OrganigramaBusiness
    {
        OrganigramaData organigramaData = new OrganigramaData();
        public IEnumerable<Organigrama> Listar()
        {
            return organigramaData.Listar();
        }
        public void Actualizar( Organigrama organigramaNuevo)
        {
            organigramaData.Update(organigramaNuevo);
        }
        public void Eliminar(Organigrama organigrama)
        {
            organigramaData.Delete(organigrama);
        }
        public void Agregar( Organigrama organigrama)
        {
            organigramaData.Add(organigrama);
        }
    }
}
