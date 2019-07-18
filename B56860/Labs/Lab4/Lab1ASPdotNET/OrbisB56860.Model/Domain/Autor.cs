using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB56860.Model.Domain
{


    public class Autores
    {
        private List<Autor> listaAutores;

        public List<Autor> ListaAutores
        {
            get { return listaAutores; }
            set { listaAutores = value ?? throw new Exception("La lista de autores no puede ser nula"); }
        }

    }


    public class Autor
    {

        private int idAutor;

        public int IdAutor
        {
            get { return idAutor; }
            set {
                if (value < 0) throw new Exception("El id no puede ser negativo.");
                idAutor = value;
            }
        }


        private string nombre;

        public string Nombre
        {
            get { return nombre; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El nombre no puede estar vacío");
                nombre = value;
            }
        }

        private string primerApellido;

        public string PrimerApellido
        {
            get { return primerApellido; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El primer apellido no puede estar vacío");
                primerApellido = value;
            }
        }


        private string segundoApellido;

        public string SegundoApellido
        {
            get { return segundoApellido; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El segundo apellido no puede estar vacío");
                segundoApellido = value;
            }
        }

        private Libros libros;

        public Libros Libros
        {
            get { return libros; }
            set { libros = value ?? throw new Exception("Los autores tienen libros asociados."); }
        }

    }
}
