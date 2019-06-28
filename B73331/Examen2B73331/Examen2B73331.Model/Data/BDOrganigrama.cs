using Examen2B73331.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Data
{
    public class BDOrganigrama
    {
        public static List<Organigrama> organigramas = new List<Organigrama>();
        public BDOrganigrama(){}
        public void append(Organigrama organigrama)
        {
            organigramas.Add(organigrama);
        }
        public void update(Organigrama organigramaNuevo, Organigrama organigramaViejo)
        {
            organigramas.Remove(organigramaViejo);
            organigramas.Add(organigramaNuevo);
        }
        public bool delete(Organigrama organigrama)
        {
            return organigramas.Remove(organigrama);
        }
        public List<Organigrama> getList()
        {
            return organigramas;
        }

    }
}
