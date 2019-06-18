using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB40894.Model.Domain
{
   public class Publicador
    {
        private int id_publicador;

        public int Id_publicador { get; private set; }

        public string Nombre { get; private set; }

        private string nombre;
        private string url_sitio_web;

        public Publicador(int id_publicador, string nombre)
        {
            Id_publicador = id_publicador;
            Nombre = nombre;
         
  
        }

    }
}
