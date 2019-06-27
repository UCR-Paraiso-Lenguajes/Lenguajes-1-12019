using OrbisB74560.Model.ExceptionOrbis;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB74560.Model.Domain
{
    public class Libro
    {
        private int id_libro;
        private string titulo;
        private int ano;
        private String isbn;
        private int id_publicador;

        public int Id_libro
        {
            get { return id_libro; }
            set
            {
                if (value <= 0)
                    throw new ExceptionsOrbis("El id del libro debe ser positivo y mayor a cero");
                id_libro = value;
            }
        }
        public string Titulo
        {
            get { return titulo; }
            set
            {
                if (string.IsNullOrEmpty(value))
                    throw new ExceptionsOrbis("El nombre es requerido");
                titulo = value;
            }
        }
        public int Ano
        {
            get { return ano; }
            set
            {
                if (value <= 0)
                    throw new ExceptionsOrbis("El año debe ser un numero positivo y mayor a cero");
                ano = value;
            }
        }
        public String ISBN
        {
            get { return isbn; }
            set
            {
                if (string.IsNullOrEmpty(value))
                    throw new ExceptionsOrbis("El isbn debe ser un numero positivo y mayor que cero");
                isbn = value;
            }
        }
        public int Id_publicador
        {
            get { return id_publicador; }
            set
            {
                if (value <= 0)
                    throw new ExceptionsOrbis("El id de publicador debe ser un numero positivo y mayor a cero");
                id_publicador = value;
            }
        }

        public Libro(int id_libro, string titulo, int ano, String isbn, int id_publicador)
        {
            Id_libro = id_libro;
            Titulo = titulo;
            Ano = ano;
            ISBN = isbn;
            Id_publicador = id_publicador;
        }
        private Libro()
        {

        }
    }
}
