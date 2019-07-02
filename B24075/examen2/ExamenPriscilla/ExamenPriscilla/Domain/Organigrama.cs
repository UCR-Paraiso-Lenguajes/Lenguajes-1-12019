using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExamenPriscilla.Domain
{
    public class Organigrama
    {
        public List<Departamento> departamentos{ get; set; }
        public String nombre { get; set; }

        public int id { get; set; }

        public Organigrama(List<Departamento> departamentos, string nombre, int id)
        {
            this.departamentos = departamentos;
            this.nombre = nombre;
            this.id = id;
        }

        public Organigrama( string nombre, int id)
        {
            this.nombre = nombre;
            this.id = id;
        }

        public Organigrama()
        {
        }


    }
}
