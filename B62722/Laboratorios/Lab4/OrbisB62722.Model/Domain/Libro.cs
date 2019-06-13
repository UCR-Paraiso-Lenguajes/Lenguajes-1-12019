using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB62722.Model.Domain
{
    public class Libro
    {
        public Libro()
        {
        }

        public Libro(int cod_libro, string titulo_libro, int ano_publicacion, string isbn, float precio)
        {
            this.cod_libro = cod_libro;
            this.titulo_libro = titulo_libro;
            this.ano_publicacion = ano_publicacion;
            this.isbn = isbn;
            this.precio = precio;
            autores = new List<Autor>();
            publicador = new Publicador();
        }

        public int cod_libro
        {
            get { return cod_libro; }
            set { cod_libro = value; }
        }

        public string titulo_libro
        {
            get { return titulo_libro; }
            set { titulo_libro = value; }
        }

        public int ano_publicacion
        {
            get { return ano_publicacion; }
            set { ano_publicacion = value; }
        }

        public string isbn
        {
            get { return isbn; }
            set { isbn = value; }
        }

        public float precio
        {
            get { return precio; }
            set { precio = value; }
        }

        public List<Autor> autores
        {
            get { return autores; }
            set { autores = value; }
        }

        public Publicador publicador
        {
            get { return publicador; }
            set { publicador = value; }
        }
    }
}
