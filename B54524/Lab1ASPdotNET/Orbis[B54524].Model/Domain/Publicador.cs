using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB54524.Model.Domain
{
    public class Publicador
    {
        public int IdPublicador { get; internal set; }
        public string NombrePublicador { get; internal set; }
        public string UrlSitioWeb { get; internal set; }

        public Publicador(int idPublicador, string nombrePublicador, string urlSitioWeb)
        {
            IdPublicador = idPublicador;
            NombrePublicador = nombrePublicador;
            UrlSitioWeb = urlSitioWeb;
        }

        public Publicador()
        {
        }

        public Publicador(int idPublicador)
        {
            IdPublicador = idPublicador;
        }
    }
}
