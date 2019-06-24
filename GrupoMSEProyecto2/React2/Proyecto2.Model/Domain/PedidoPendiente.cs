using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public class PedidoPendiente : Pedido
    {
        private DateTime fechaUltimoUso;
        public DateTime FechaUltimoUso
        {
            get { return fechaUltimoUso; }
            set
            {
                if (value == null) throw new CompanniaException("La fecha no debe ser nula");
                fechaUltimoUso = value;
            }
        }

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