using System;
using System.Collections.Generic;
using System.Text;

namespace model.Domain
{
    public class Pelicula
    {
        public Pelicula()
        {

        }

        public Pelicula(int id, string nombre, string urlImagen)
        {
            Id = id;
            Nombre = nombre;
            UrlImagen = urlImagen;
        }

        private string nombre;
        public string Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido.");
                if (string.IsNullOrWhiteSpace(value)) throw new Exception("No puede ingresar solo espacios");

                nombre = value;
            }
        }

        private string urlImagen;
        public string UrlImagen
        {
            get
            {
                return urlImagen;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("URL es requerida.");

                urlImagen = value;
            }
        }

        private int id;
        public int Id
        {
            get
            {
                return id;
            }
            set
            {
                if(value== 0) throw new Exception("Identificador es requerido.");

                id = value;
            }
        }

    }
}



