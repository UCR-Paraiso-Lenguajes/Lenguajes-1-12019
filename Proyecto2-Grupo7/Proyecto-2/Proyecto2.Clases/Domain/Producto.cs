using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class Producto
    {
      
        public Producto(string id, decimal impuesto,string url_image, string nombre, string descripcion, int cantidadDisponible)
        {
            Id = id;
            Impuesto = impuesto;
            Nombre = nombre;
            Url_image = url_image;
            Descripcion = descripcion;
            CantidadDisponible = cantidadDisponible;

        }

        public Producto()
        {

        }

        private string url_image;
        public string Url_image
        {
            get
            {

                return url_image;
                }

            set
            {
                if(string.IsNullOrEmpty(value)) throw new Exception("El url es requerido");
                url_image = value;
            }
        }

        private string id;
        public string Id
        {
            get
            {
                return id;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El id es requerido");
                id = value;
            }
        }
    
        private decimal impuesto;
        public decimal Impuesto
        {
            get
            {
                return impuesto;
            }
            set
            {
                if (impuesto == null) throw new Exception("El impuesto es requerido");
                impuesto = value;
            }
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
                //if (string.IsNullOrEmpty(value)) throw new Exception("El nombre es requerido");
                nombre = value;
            }
        }
        private string descripcion;
        public string Descripcion
        {
            get
            {
                return descripcion;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("La descripcion es requerida");
                descripcion = value;
            }
        }
        private int cantidadDisponible;
        public int CantidadDisponible
        {
            get
            {
                return cantidadDisponible;
            }
            set
            {
                if (value <-1) { throw new Exception("La cantidad debe ser positiva."); }
                else
                {

                    cantidadDisponible = value;

                }
            }
        }




    }
}
