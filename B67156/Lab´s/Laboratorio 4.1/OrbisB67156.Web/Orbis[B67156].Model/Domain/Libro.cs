using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B67156_.Model.Domain
{
    public class Libro
    {

        private int id_libro;
        public int Id_libro
        {
            get
            {
                return id_libro;
            }
            set
            {
                if (value <= 0) throw new Exception("Id libro es requerido");
                id_libro = value;
            }
        }
        private string titulo;
        public string Titulo
        {
            get
            {
                return titulo;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Titulo es requerido");
                titulo = value;
            }
        }
        private int año;
        public int Año
        {
            get
            {
                return año;
            }
            set
            {
                if (value <= 0) throw new Exception("Año es requerido");
                año = value;
            }
        }
        private float precio;
        public float Precio
        {
            get
            {
                return precio;
            }
            set
            {
                if (value <= 0) throw new Exception("Precio es requerido");
                precio = value;
            }
        }
        private int id_editorial;
        public int Id_editorial
        {
            get
            {
                return id_editorial;
            }
            set
            {
                if (value <= 0) throw new Exception("Id editorial es requerido");
                id_editorial = value;
            }
        }


        public Libro(int id_libro, string titulo, int año, float precio, int id_editorial)
        {
            Id_libro = id_libro;
            Titulo = titulo;
            Año = año;
            Precio = precio;
            Id_editorial = id_editorial;
        }
    }
}
