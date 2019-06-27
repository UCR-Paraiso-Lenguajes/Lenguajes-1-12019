using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB62722.Model.Domain
{
    public class Publicador
    {
        public Publicador()
        {

        }

        public Publicador(int id_publicador, string nombre_publicador, string url_sitio_web)
        {
            this.id_publicador = id_publicador;
            this.nombre_publicador = nombre_publicador;
            this.url_sitio_web = url_sitio_web;
        }
        public int id_publicador
        {
            get { return id_publicador;  }
            set { id_publicador = value; }
        }

        public string nombre_publicador
        {
            get { return nombre_publicador; }
            set { nombre_publicador = value; }
        }

        public string url_sitio_web
        {
            get { return url_sitio_web; }
            set { url_sitio_web = value; }
        }

    }
}
