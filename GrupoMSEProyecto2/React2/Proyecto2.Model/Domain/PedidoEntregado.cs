using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public sealed class PedidoEntregado : Pedido
    {
        
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