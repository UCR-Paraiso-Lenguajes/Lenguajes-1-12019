using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB73331.Model.Domain
{
    public class Publicador
    {
        private int id_publicador;
        public int Id_publicador
        {
            get
            {
                return id_publicador;
            }
            set
            {
                if (value <= 0) throw new Exception("Dato invalido");
                id_publicador = value;
            }
        }

        private string nombre_publicador;
        public string Nombre_publicador
        {
            get
            {
                return nombre_publicador;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido");
                nombre_publicador = value;
            }
        }

        private string url_sitio_web;
        public string Url_sitio_web
        {
            get
            {
                return url_sitio_web;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Url es requerido");
                url_sitio_web = value;
            }
        }


        public Publicador(int id_publicador, string nombre_publicador, string url_sitio_web)
        {
            Id_publicador = id_publicador;
            Nombre_publicador = nombre_publicador;
            Url_sitio_web = url_sitio_web;
        }
    }
}
