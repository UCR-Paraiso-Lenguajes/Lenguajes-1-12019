using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB54524.Model.Domain
{
    public class Autor
    {
        public int IdAutor { get; internal set; }
        public string NombreAutor { get; internal set; }
        public string PrimerApellido { get; internal set; }
        public string SegundoApellido { get; internal set; }

        public Autor(int idAutor, string nombreAutor, string primerApellido, string segundoApellido)
        {
            IdAutor = idAutor;
            NombreAutor = nombreAutor;
            PrimerApellido = primerApellido;
            SegundoApellido = segundoApellido;
        }
    }
}
