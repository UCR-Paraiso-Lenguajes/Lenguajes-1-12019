using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExamenPriscilla.Domain
{
    public class DevuelveDepartamento
    {
       
        public String id { get; set; }
        public String nombre { get; set; }

        public String jefatura { get; set; }
        public bool marcado { get; set; }

        public DevuelveDepartamento(String jefatura, string nombre, String id, bool marcado)
        {
            this.jefatura = jefatura;
            this.nombre = nombre;
            this.id = id;
            this.marcado = marcado;
        }

        public DevuelveDepartamento(string nombre, String id, bool marcado)
        {

            this.nombre = nombre;
            this.id = id;
            this.marcado = marcado;
        }

        public DevuelveDepartamento()
        {
        }
    }
}
