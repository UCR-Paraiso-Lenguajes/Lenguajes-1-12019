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
        private List<ProductoCantidadPrecioCompraTotal> productosTotalCompra;
        public List<ProductoCantidadPrecioCompraTotal> ProductosTotalCompra
        {
            get { return productosTotalCompra; }
            private set
            {
                productosTotalCompra = value ?? throw new CompanniaException("La lista con los productos y su cantidad no debe ser vacio");
            }
        }
        private List<ProductoCantidadPrecioCompraTotal> setProductosTotalCompra(List<ProductoCantidad> productosCantidad)
        {
            if (productosCantidad.Count <= 0) throw new CompanniaException("La lista con los productos y su cantidad no debe ser vacio"); 
            foreach (ProductoCantidad productoCantidad in productosCantidad)
            {
                ProductoCantidadPrecioCompraTotal productoTotal = new ProductoCantidadPrecioCompraTotal(productoCantidad.Producto, productoCantidad.Cantidad);
                productosTotalCompra.Add(productoTotal);
            }
            return productosTotalCompra;
        }

            
       
        public OrdenDeCompra(List<ProductoCantidad> productosCantidad)
        {
            ProductosCantidad = productosCantidad;
            ProductosTotalCompra = setProductosTotalCompra(ProductosCantidad);
        }
    }
    public class ProductoCantidadPrecioCompraTotal : ProductoCantidad
    {
        private float compraTotalProducto;
        public float CompraTotalProducto
        {
            get { return compraTotalProducto; }
            private set
            {
                if (value <= 0) throw new CompanniaException("La compraTotalProducto debe ser menor y diferente a cero");
                compraTotalProducto = value;
            }
        }

        public ProductoCantidadPrecioCompraTotal(Producto producto, int cantidad)
        {
            Producto = producto;
            Cantidad = cantidad;
            CompraTotalProducto = this.Producto.PrecioUnitario*this.Cantidad;
        }
    }
}