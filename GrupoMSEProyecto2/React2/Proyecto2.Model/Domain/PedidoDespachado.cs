using Proyecto2Lenguajes.Model.Exceptions;
using System;

namespace Proyecto2.Model.Domain
{
    public class PedidoDespachado : Pedido
    {
        private DateTime fechaDespacho;
        public DateTime FechaDespacho
        {
            get { return fechaDespacho; }
            set {
                if (value == null) throw new CompanniaException("La fecha no debe ser nula");
                fechaDespacho = value;
            }
        }
        private float totalCompra;
        public float TotalCompra
        {
            get { return totalCompra; }
            set {
                if (value<=0) throw new CompanniaException("Un total debe ser mayor a cero");
                totalCompra = value;
            }
        }

        public PedidoDespachado(int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaDespacho, float totalCompra)
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