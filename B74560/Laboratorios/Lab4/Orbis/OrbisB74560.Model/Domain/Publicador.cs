using OrbisB74560.Model.ExceptionOrbis;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB74560.Model.Domain
{
    public class Publicador
    {


        private string nombre_publicador;
        private int id_publicador;
        private string url_sitio_web;

        public int Id_publicador
        {
            get
            {
                return id_publicador;
            }
            set
            {
                if (value <= 0) throw new ExceptionsOrbis("Dato invalido");
                id_publicador = value;
            }
        }
        public string Nombre_publicador
        {
            get
            {
                return nombre_publicador;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new ExceptionsOrbis("Nombre es requerido");
                nombre_publicador = value;
            }
        }
        public string Url_sitio_web
        {
            get
            {
                return url_sitio_web;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new ExceptionsOrbis("Url es requerido");
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
