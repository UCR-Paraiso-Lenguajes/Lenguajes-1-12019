
using OrbisB77436.Model.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace OrbisB77436.web.Models
{
    public class PublicadorLibro
    {
        private List<Libro> libros = new List<Libro>();
        private List<Publicador> publicadores = new List<Publicador>();

        public PublicadorLibro(List<Libro> libros, List<Publicador> publicadores)
        {
            this.libros = libros;
            this.publicadores = publicadores;
        }

        public PublicadorLibro()
        {
        }
        public List<Libro> Libros
        {
            get { return libros; }
            set
            {
                libros = value;
            }
        }
        public List<Publicador> Publicadores
        {
            get { return publicadores; }
            set
            {
                publicadores = value;
            }
        }
    }
}