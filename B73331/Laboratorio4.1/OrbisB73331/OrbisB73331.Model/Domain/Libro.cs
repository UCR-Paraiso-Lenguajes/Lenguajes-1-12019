using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB73331.Model.Domain
{
    public class Libro
    {
        private int id_libro;
        private string titulo;
        private int ano;
        private float precio;
        private int id_editorial;
        private int id_publicador;

        public int Id_libro
        {
            get { return id_libro; }
            set
            {
                if (value <= 0)
                    throw new Exception("El id del libro debe ser positivo y mayor a cero");
                id_libro = value;
            }
        }
        public string Titulo
        {
            get { return titulo; }
            set
            {
                if (string.IsNullOrEmpty(value))
                    throw new Exception("El nombre no puede ser vacio o nulo");
                titulo = value;
            }
        }
        public int Ano
        {
            get { return ano; }
            set
            {
                if (value <= 0)
                    throw new Exception("El ano debe ser positivo y mayor a cero");
                ano = value;
            }
        }
        public float Precio
        {
            get { return precio; }
            set
            {
                if (value <= 0)
                    throw new Exception("El precio debe ser positivo y mayor que cero");
                precio = value;
            }
        }
        public int Id_editorial
        {
            get { return id_editorial; }
            set
            {
                if (value <= 0)
                    throw new Exception("El id de editorial debe ser positivo y mayor a cero");
                id_editorial = value;
            }
        }
        public int Id_publicador
        {
            get { return id_publicador; }
            set
            {
                if (value <= 0)
                    throw new Exception("El id de publicador debe ser positivo y mayor a cero");
                id_publicador = value;
            }
        }

        public Libro(int id_libro, string titulo, int ano, float precio, int id_editorial, int id_publicador)
        {
            Id_libro = id_libro;
            Titulo = titulo;
            Ano = ano;
            Precio = precio;
            Id_editorial = id_editorial;
            Id_publicador = id_publicador;
        }
        public Libro()
        {

        }
    }
}
