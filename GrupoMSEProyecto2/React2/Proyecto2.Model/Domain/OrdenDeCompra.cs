using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections;
using System.Collections.Generic;

namespace Proyecto2.Model.Domain
{
    public class OrdenDeCompra
    {
        private List<ProductoCantidad> productosCantidad;
        public List<ProductoCantidad> ProductosCantidad
        {
            get { return productosCantidad; }
            set { productosCantidad = value ?? throw new CompanniaException("La lista con los productos y su cantidad no debe ser vacio"); }
        }
        private double totalCompra;
        public double TotalCompra
        {
            get { return totalCompra; }
            set
            {
                if(value<0) throw new CompanniaException("El total de Compra debe ser positivo");
                totalCompra = value;
            }
        }

        public OrdenDeCompra(List<ProductoCantidad> productosCantidad, double totalCompra)
        {
            ProductosCantidad = productosCantidad;
            TotalCompra = totalCompra;
        }
    }
   
}