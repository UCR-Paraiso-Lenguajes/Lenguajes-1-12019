using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen3B56860.Pages
{
    public class Pelicula
    {

        public int IdPelicula { get; set; }

        public string Imagen { get; set; }

        public string Nombre { get; set; }


        public Pelicula(int id, string imagen, string nombre)
        {
            IdPelicula = id;
            Imagen = imagen;
            Nombre = nombre;
        }

    }
}
