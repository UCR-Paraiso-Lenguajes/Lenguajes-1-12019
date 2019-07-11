using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class Organizacion
    {
        public Organizacion()
        {

        }

        public Organizacion(string descripcion,string lastUpdate)
        {
            Descripcion = descripcion;
            LastUpdate = lastUpdate;
        }

        private string descripcion;
        public string Descripcion
        {
            get
            {
                return descripcion;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("La descripcion es requerida");
                descripcion = value;

            }
        }

        private string lastUpdate;

        public string LastUpdate
        {
            get
            {
                return lastUpdate;
            }
            set
            {
                //if (string.IsNullOrEmpty(lastUpdate)) throw new Exception("La ultima fecha de modificacion es requerida");
                lastUpdate = value;
            }
        }

    }
}
