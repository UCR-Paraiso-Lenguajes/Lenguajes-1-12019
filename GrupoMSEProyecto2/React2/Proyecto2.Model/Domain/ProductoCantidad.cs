using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Domain
{
    public class ProductoCantidad
    {
        private Producto producto;

        public Producto Producto
        {
            get { return producto; }
            set { producto = value ?? throw new CompanniaException("El producto debe existir"); }
        }

        private int cantidad;
        public int Cantidad
        {
            get { return cantidad; }
            set {
                if (value < 0) throw new CompanniaException("La cantidad no puede ser 0 o negativo");
                cantidad = value;
            }
        }
        private double compraTotalProducto;
        public double CompraTotalProducto
        {
            get { return compraTotalProducto; }
            private set
            {
                if (value <= 0) throw new CompanniaException("La compraTotalProducto debe ser mayor y diferente a cero");
                compraTotalProducto = value;
            }
        }
        private double compraSubTotalProducto;
        public double CompraSubTotalProducto
        {
            get { return compraSubTotalProducto; }
            private set
            {
                if (value <= 0) throw new CompanniaException("La compraSubTotalProducto debe ser mayor y diferente a cero");
                compraSubTotalProducto = value;
            }
        }
        private ProductoCantidad()
        {
        }

        public ProductoCantidad(Producto producto, int cantidad)
        {
            Producto = producto;
            Cantidad = cantidad;
            CompraTotalProducto = this.Producto.PrecioProductoConImpuesto * this.Cantidad;
            CompraSubTotalProducto = this.Producto.PrecioUnitario * this.Cantidad;
        }
    }
}
