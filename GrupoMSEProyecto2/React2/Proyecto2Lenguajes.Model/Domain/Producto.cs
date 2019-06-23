using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2Lenguajes.Model.Domain
{
    /// <summary>
    /// Clase que administra los productos
    /// </summary>
    public class Producto
    {

        public Producto()
        {

        }


        private int idProducto;
        public int IdProducto
        {
            get { return idProducto; }
            set {
                if (value < 0) throw new CompanniaException("El id del producto no puede ser 0 o negativo");    
                idProducto = value;
            }
        }

        private double porcentajeImpuesto;
        public double PorcentajeImpuesto
        {
            get { return porcentajeImpuesto; }
            set {
                if (value < 0 || value >100) throw new CompanniaException("El impuesto no puede ser negativo y no puede exceder el 100%");
                porcentajeImpuesto = value;
            }
        }


        private string nombre;
        public string Nombre
        {
            get { return nombre; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El nombre no puede estar vacío");
                nombre = value;
            }
        }


        private string descripcion;
        public string Descripcion
        {
            get { return descripcion; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("Debe haber una descripción");
                descripcion = value;
            }
        }


        private int cantidadDisponible;
        public int CantidadDisponible
        {
            get { return cantidadDisponible; }
            set {
                if (value < 0) throw new CompanniaException("La cantidad disponible de los productos no puede ser negativa");
                cantidadDisponible = value;
            }
        }



    }
}
