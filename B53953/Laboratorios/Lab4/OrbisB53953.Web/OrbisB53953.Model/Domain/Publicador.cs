using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB53953.Web.Domain
{
    public class Publicador
    {

        private int idPublicador;
        public int IdPublicador
        {
            get
            {
                return idPublicador;
            }
            set
            {
                if (value <= 0) throw new Exception("El id debe ser positivo.");
                idPublicador = value;
            }
        }

        private string nombrePublicador;
        public string NombrePublicador
        {
            get
            {
                return nombrePublicador;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido.");
                nombrePublicador = value;
            }
        }

        private string urlSitioWeb;
        public string UrlSitioWeb
        {
            get
            {
                return urlSitioWeb;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Sitio web es requerido.");
                urlSitioWeb = value;
            }
        }

        public Publicador(int idPublicador, string nombrePublicador, string urlSitioWeb)
        {
            IdPublicador = idPublicador;
            NombrePublicador = nombrePublicador;
            UrlSitioWeb = urlSitioWeb;
        }


    }


}

