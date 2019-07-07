using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public sealed class PedidoDespachado : Pedido
    {
        

        public PedidoDespachado(int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaDespacho, double totalCompra)
        {
            Id = id;
            Email = email;
            Direccion = direccion;
            OrdenDeCompra = ordenDeCompra;
            FechaDespacho = fechaDespacho;
            TotalCompra = totalCompra;
        }

        public PedidoDespachado()
        {
        }
    }
}