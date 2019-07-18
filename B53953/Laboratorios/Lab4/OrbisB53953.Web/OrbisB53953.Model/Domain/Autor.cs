using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB53953.Web.Domain
{
    public class Autor
    {

        private int idAutor;
        public int IdAutor
        {
            get
            {
                return idAutor;
            }
            set
            {
                if (value <= 0) throw new Exception("El id debe ser positivo.");
                idAutor = value;
            }
        }

        private string nombreAutor;
        public string NombreAutor
        {
            get
            {
                return nombreAutor;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido.");
                nombreAutor = value;
            }
        }

        private string primerApellidoAutor;
        public string PrimerApellidoAutor
        {
            get
            {
                return primerApellidoAutor;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Primer apellido es requerido.");
                primerApellidoAutor = value;
            }
        }

        private string segundoApellidoAutor;
        public string SegundoApellidoAutor
        {
            get
            {
                return segundoApellidoAutor;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Segundo apellido es requerido.");
                segundoApellidoAutor = value;
            }
        }

        public Autor(int idAutor, string nombreAutor, string primerApellidoAutor, string segundoApellidoAutor)
        {
            IdAutor = idAutor;
            NombreAutor = nombreAutor;
            PrimerApellidoAutor = primerApellidoAutor;
            SegundoApellidoAutor = segundoApellidoAutor;
        }
    }
}
