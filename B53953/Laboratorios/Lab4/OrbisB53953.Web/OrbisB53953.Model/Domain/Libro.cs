using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB53953.Web.Domain
{
    public class Libro
    {

        private int codLibro;
        public int CodLibro
        {
            get
            {
                return codLibro;
            }
            set
            {
                if (value <= 0) throw new Exception("El codigo debe ser positivo.");
                codLibro = value;
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
                if (string.IsNullOrEmpty(value)) throw new Exception("Titulo es requerido.");
                titulo = value;
            }
        }

        private int añoPublicacion;
        public int AñoPublicacion
        {
            get
            {
                return añoPublicacion;
            }
            set
            {
                if (value <= 0) throw new Exception("El año debe ser positivo.");
                añoPublicacion = value;
            }
        }

        private int precio;
        public int Precio
        {
            get
            {
                return precio;
            }
            set
            {
                if (value <= 0) throw new Exception("El precio debe ser positivo.");
                precio = value;
            }
        }

        private int idPublicador;
        public int IdPublicador
        {
            get
            {
                return IdPublicador;
            }
            set
            {
                if (value <= 0) throw new Exception("El id del publicador debe ser positivo.");
                IdPublicador = value;
            }
        }

        public Libro(int codLibro, string titulo, int añoPublicacion, int precio, int idPublicador)
        {
            CodLibro = codLibro;
            Titulo = titulo;
            AñoPublicacion = añoPublicacion;
            Precio = precio;
            IdPublicador = idPublicador;
        }

        public Libro(int codLibro, string titulo,int precio)
        {
            CodLibro = codLibro;
            Titulo = titulo;
            Precio = precio;

        }
    }
}
