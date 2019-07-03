using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class ProductoCantidad
    {


        public ProductoCantidad(Producto producto, int cantidad)
        {
            Producto = producto;
            Cantidad = cantidad;


        }

        public ProductoCantidad()
        {

        }
        private Producto producto;
        public Producto Producto
        {
            get
            {
                return producto;
            }
            set
            {
                if (producto == null) throw new Exception("El producto es requerido.");
                producto = value;
            }



        }

        private int cantidad;
        public int Cantidad
        {
            get
            {
                return cantidad;
            }
            set
            {
                if (value <= 0) throw new Exception("La cantidad debe ser positiva.");
                cantidad = value;
            }
        }
    } }
    
