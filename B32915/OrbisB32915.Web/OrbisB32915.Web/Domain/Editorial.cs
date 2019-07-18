using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Domain
{
    public class Editorial
    {
        private int id_editorial;
        private string nombre;
        private string direccion;
        private string telefono;
        private string url_sitio;

        public Editorial(int id_editorial, string nombre, string direccion, string telefono, string url_sitio)
        {
            Id_editorial = id_editorial;
            Nombre = nombre;
            Direccion = direccion;
            Telefono = telefono;
            Url_sitio = url_sitio;
    }

        public int Id_editorial { get; internal set; }
        public string Nombre { get; internal set; }
        public string Direccion { get; internal set; }
        public string Telefono { get; internal set; }
        public string Url_sitio { get; internal set; }
    }
}
