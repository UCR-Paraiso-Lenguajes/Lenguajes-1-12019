using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Domain
{
    /// <summary>
    /// Clase que gestiona un conjunto de productos
    /// </summary>
    public class Productos {
        private List<Producto> productos = new List<Producto>();

        public IEnumerator<Producto> GetProductos()
        {
            return productos.GetEnumerator();
        }
       
        public void AddProductos(Producto producto)
        {
            productos.Add(producto);
        }


    }



    /// <summary>
    /// Clase que administra los productos
    /// </summary>
    public class Producto
    {

        public Producto()
        {

        }
        /*Maes agregue este atributo, creo que es importante tenerlo*/
        private double precioUnitario;
        public double PrecioUnitario
        {
            get { return precioUnitario; }
            set
            {
                if (value < 0 || value == 0) throw new CompanniaException("El id debe ser mayor y distinto de cero");
                precioUnitario = value;
            }
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

        private double impuesto;
        public double Impuesto
        {
            get { return impuesto; }
            set {
                if (value < 0 || value >100) throw new CompanniaException("El impuesto no puede ser negativo y no puede exceder el 100%");
                impuesto = value;
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
        private double precioProductoConImpuesto;
        public double PrecioProductoConImpuesto
        {
            get { return precioProductoConImpuesto; }
            private set { if (value <= 0) throw new CompanniaException("El precio con impuesto debe ser positivo"); precioProductoConImpuesto = value; }
        }
        private string imagen;
        public String Imagen
        {
            get { return imagen; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("Debe haber una imagen para el producto");
                imagen = value;
            }
        }
        /*Para sacar el precio del producto con impuesto corresponde a ValorUnitario - (ValorUnitario * (PorcentajeImpuesto/(100)))*/
        public Producto(double precioUnitario, int idProducto, double impuestoC, string nombre, string descripcion, int cantidadDisponible, string imagen)
        {
            PrecioUnitario = precioUnitario;
            IdProducto = idProducto;
            Impuesto = impuestoC;
            Nombre = nombre;
            Descripcion = descripcion;
            CantidadDisponible = cantidadDisponible;
            Imagen = imagen;
            PrecioProductoConImpuesto = PrecioUnitario + (PrecioUnitario * Impuesto/100);
        }
    }
}
