using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Domain
{
    public class Autor
    {
        public int idAutor { internal set; get; }
        public string nombreAutor { internal set; get; }
        public string primerApellido { internal set; get; }
        public string segundoApellido { internal set; get; }

        public Autor(int idAutor, string nombreAutor, string primerApellido, string segundoApellido)
        {
            this.idAutor = idAutor;
            this.nombreAutor = nombreAutor;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
        }
    }
}
