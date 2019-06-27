using Microsoft.AspNetCore.Mvc.Rendering;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB63685Model.Domain
{
    public class Editorial
    {

        public int idEditorial;
        public string nombreEditorial;
        public string urlDelSitio;


        public Editorial(int idEditorial, string nombreEditorial)
        {
            this.idEditorial = idEditorial;
            this.nombreEditorial = nombreEditorial;
        }

        public Editorial()
        {
        }

        public int IdEditorial { get => idEditorial; set => idEditorial = value; }
        public string NombreEditorial { get => nombreEditorial; set => nombreEditorial = value; }
        public string UrlDelSitio { get => urlDelSitio; set => urlDelSitio = value; }
        public List<SelectListItem> Editoriales { get; set; }


      



    }

}
