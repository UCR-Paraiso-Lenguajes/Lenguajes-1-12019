using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public sealed class PedidoEntregado : Pedido
    {
        private DateTime fechaEntrega;
        public DateTime FechaEntrega
        {
            get { return fechaEntrega; }
            set {
                if (value == null) throw new CompanniaException("La fecha no debe ser nula");
                fechaEntrega = value;
            }
        }
        private double totalCompra;
        public double TotalCompra
        {
            get { return totalCompra; }
            set
            {
                if (value <= 0) throw new CompanniaException("Un total debe ser mayor a cero");
                totalCompra = value;
            }
        }
        private int totalProductosEntregados;
        public int TotalProductosEntregados
        {
            get { return totalProductosEntregados; }
            set {
                if (value <= 0) throw new CompanniaException("Un total de productos entregados debe ser mayor a cero");
                totalProductosEntregados = value;
            }
        }

        public PedidoEntregado(int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaEntrega, double totalCompra, int totalProductosEntregados)
        {
            Id = id;
            Email = email;
            Direccion = direccion;
            OrdenDeCompra = ordenDeCompra;
            FechaEntrega = fechaEntrega;
            TotalCompra = totalCompra;
            TotalProductosEntregados = totalProductosEntregados;
        }

        public PedidoEntregado()
        {
        }
    }
}