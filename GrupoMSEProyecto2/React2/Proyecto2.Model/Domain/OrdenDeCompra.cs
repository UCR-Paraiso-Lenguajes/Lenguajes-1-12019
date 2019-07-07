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
            set {
                productosCantidad = value ?? throw new CompanniaException("La lista con los productos y su cantidad no debe ser vacio");
                calculaTotalYSubTotal(ProductosCantidad);
            }
        }
        private double totalCompra;
        public double TotalCompra
        {
            get { return totalCompra; }
            private set
            {
                if(value<0) throw new CompanniaException("El total de Compra debe ser positivo");
                totalCompra = value;
            }
        }
        private double subTotalCompra;
        public double SubTotalCompra
        {
            get { return subTotalCompra; }
            private set
            {
                if (value < 0) throw new CompanniaException("El sub total de Compra debe ser positivo");
                subTotalCompra = value;
            }
        }
        private void calculaTotalYSubTotal(List<ProductoCantidad> productosCantidad)
        {
            double total = 0;
            double subTotal = 0;
            foreach (ProductoCantidad productoCantidad in productosCantidad)
            {
                total = total + productoCantidad.CompraTotalProducto;
                subTotal = subTotal + productoCantidad.CompraSubTotalProducto;
            }
            TotalCompra = total;
            SubTotalCompra = subTotal;
        }
        //El total de compra y subtotal de compra se calculan en el momento que se ingresan los productos
        public OrdenDeCompra(List<ProductoCantidad> productosCantidad)
        {
            ProductosCantidad = productosCantidad;
            calculaTotalYSubTotal(ProductosCantidad);
        }
    }
   
}