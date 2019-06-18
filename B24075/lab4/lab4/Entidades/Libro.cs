using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
   public class Libro
    {
        public int idLibro { get; set; }
        public String titulo { get; set; }
        public int anno { get; set; }
        public int precio { get; set; }
        public Publicador publicador { get; set; }

    }
}
