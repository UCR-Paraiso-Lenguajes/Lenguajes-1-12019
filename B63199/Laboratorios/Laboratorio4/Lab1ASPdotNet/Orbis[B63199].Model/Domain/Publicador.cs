using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Domain
{
    public class Publicador
    {
        public int idPublicador {internal set; get; }
        public string nombrePubicador { internal set; get; }
        public string urlSitioWeb { internal set; get; }

        public Publicador(int idPublicador, string nombrePubicador, string urlSitioWeb)
        {
            this.idPublicador = idPublicador;
            this.nombrePubicador = nombrePubicador;
            this.urlSitioWeb = urlSitioWeb;
        }
    }
}
