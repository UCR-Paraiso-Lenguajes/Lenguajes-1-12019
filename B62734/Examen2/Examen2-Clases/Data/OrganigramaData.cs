using System;
using System.Collections.Generic;
using System.Text;
using Examen2_Clases.Domain;

namespace Examen2_Clases.Data
{
   public class OrganigramaData
    {
        private static List<Organigrama> organigramas = new List<Organigrama>();
        public IEnumerable<Organigrama> Listar()
        {
            return organigramas;
        }

        public void Add(Organigrama organigrama)
        {

            if (organigrama == null) throw new Exception("El organigrama es requerido.");
            organigramas.Add(organigrama);
        }

        public void Delete(Organigrama organigrama)
        {

            if (organigrama == null) throw new Exception("El organigrama es requerido.");
            organigramas.Remove(organigrama);
        }
        public void Update( Organigrama organigramaNuevo)
        {

            if (organigramaNuevo == null) throw new Exception("El organigrama es requerido.");
            int cont = 0;
            int posicion=0;
            foreach (var organigrama in organigramas)
            {
                if (organigrama.Id==organigramaNuevo.Id)
                {
                    posicion = cont;
                }
                cont++;
            }
            organigramas.Insert(posicion, organigramaNuevo);
        }
    }
}
