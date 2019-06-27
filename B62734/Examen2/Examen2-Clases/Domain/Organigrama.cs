using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2_Clases.Domain
{
    public class Organigrama
    {
        public Organigrama(string id, string nombre)
        {
            if (id == null && nombre == null) throw new Exception("organigrama vacio");
            this.Id = id;
            this.Nombre = nombre;
        }
        public string Id { get; set; }
        public string Nombre { get; set; }
    }
}
