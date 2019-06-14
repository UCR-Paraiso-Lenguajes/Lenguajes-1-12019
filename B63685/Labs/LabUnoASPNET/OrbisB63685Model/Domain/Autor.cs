using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB63685Model.Domain
{
    class Autor
    {

        private int idAutor;
        private string nombreAutor;
        private string primerApellidoAutor;
        private string segundoApellidoAutor;

        public int IdAutor { get => idAutor; set => idAutor = value; }
        public string NombreAutor { get => nombreAutor; set => nombreAutor = value; }
        public string PrimerApellidoAutor { get => primerApellidoAutor; set => primerApellidoAutor = value; }
        public string SegundoApellidoAutor { get => segundoApellidoAutor; set => segundoApellidoAutor = value; }
    }
}
