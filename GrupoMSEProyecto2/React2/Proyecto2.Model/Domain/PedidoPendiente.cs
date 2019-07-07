using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public sealed class PedidoPendiente : Pedido
    {
        public PedidoPendiente(int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaUltimoUso)
        {
            Id = id;
            Email = email;
            Direccion = direccion;
            OrdenDeCompra = ordenDeCompra;
            FechaUltimoUso = fechaUltimoUso;
        }

        public PedidoPendiente()
        {
        }
    }
}