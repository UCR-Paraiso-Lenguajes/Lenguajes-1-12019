using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExamenPriscilla.Domain
{
    public class Departamento
    {
        
      

          public String id { get; set; }
        public String nombre { get; set; }
        public Departamento jefatura { get; set; }
        public bool marcado { get; set; }

        public Departamento(Departamento jefatura, string nombre,  String id, bool marcado)
        {
            this.jefatura = jefatura;
            this.nombre = nombre;
            this.id = id;
            this.marcado = marcado;
        }

        public Departamento( string nombre, String id, bool marcado)
        {
        
            this.nombre = nombre;
            this.id = id;
            this.marcado = marcado;
        }

        public Departamento()
        {
        }
    }
}
