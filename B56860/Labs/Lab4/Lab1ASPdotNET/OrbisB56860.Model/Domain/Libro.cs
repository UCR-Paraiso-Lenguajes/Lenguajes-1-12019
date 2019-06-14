using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB56860.Model.Domain
{




    public class Libros
    {
        private List<Libro> listaLibros= new List<Libro>();

        public List<Libro> ListaLibros
        {
            get { return listaLibros; }
            set { listaLibros = value ?? throw new Exception("La lista de libros no puede ser nula"); }
        }
        
    }




    public class Libro
    {

        public Libro(){}

        public Libro(int idLibro,string titulo, Int16 anoPublicacion,string isbn,Publicador publicador,Autores autores,double precio)
        {
            IdLibro = idLibro;
            Titulo = titulo;
            AnoPublicacion = anoPublicacion;
            Isbn = isbn;
            Publicador = publicador;
            Autores = autores;
            Precio = precio;
        }

        public Libro(int id, string titulo, double precio)
        {
            IdLibro = id;
            Titulo = titulo;
            Precio = precio;
        }

        private int idLibro;
        public int IdLibro
        {
            get { return idLibro; }
            set {
                if (value < 0) throw new Exception("El id no puede ser negativo.");
                idLibro = value;
            }
        }

        private string titulo;
        public string Titulo
        {
            get { return titulo; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El titulo no puede estar vacío");
                titulo = value;
            }
        }



        private Int16 anoPublicacion;

        public Int16 AnoPublicacion
        {
            get { return anoPublicacion; }
            set {
                if (value < 0) throw new Exception("El año de publicación no puede ser negativo.");
                anoPublicacion = value;
            }
        }


        private string isbn;

        public string Isbn
        {
            get { return isbn; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new Exception("El titulo no puede estar vacío");
                isbn = value;
            }
        }


        private Publicador publicador;

        public Publicador Publicador
        {
            get { return publicador; }
            set { publicador = value ?? throw new Exception("El publicador debe existir."); }
        }


        private double precio;

        public double Precio
        {
            get { return precio; }
            set {
                if (value < 0) throw new Exception("El año de publicación no puede ser negativo.");
                precio = value;
            }
        }



        private Autores autores;
        private int id;

        public Autores Autores
        {
            get { return autores; }
            set {
                autores = value ?? throw new Exception("El libro debe tener autores.");
            }
        }
    }

}
