using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections.Generic;

namespace Proyecto2.Model.Domain
{
    public abstract class Pedido
    {
        public Pedido() { }
        private int id;
        public int Id
        {
            get { return id; }
            set {
                if (value < 0) throw new CompanniaException("El id debe ser mayor a cero");
                id = value;
            }
        }
        private string email;
        public string Email
        {
            get { return email; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El email no puede estar vacío");
                email = value;
            }
        }
        private string direccion;
        public string Direccion
        {
            get { return direccion; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El direccion no puede estar vacío");
                direccion = value;
            }
        }
        private OrdenDeCompra ordenDeCompra;
        public OrdenDeCompra OrdenDeCompra
        {
            get { return ordenDeCompra; }
            set { ordenDeCompra = value ?? throw new CompanniaException("La orden de compra no debe estar vacia"); }
        }
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
        private DateTime fechaEntrega;
        public DateTime FechaEntrega
        {
            get { return fechaEntrega; }
            set
            {
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
            set
            {
                if (value <= 0) throw new CompanniaException("Un total de productos entregados debe ser mayor a cero");
                totalProductosEntregados = value;
            }
        }
        private DateTime fechaDespacho;
        public DateTime FechaDespacho
        {
            get { return fechaDespacho; }
            set
            {
                if (value == null) throw new CompanniaException("La fecha no debe ser nula");
                fechaDespacho = value;
            }
        }
        public Pedido(int id,string email, string direccion, OrdenDeCompra ordenDeCompra)
        {
            Id = id;
            Email = email;
            Direccion = direccion;
            OrdenDeCompra = ordenDeCompra;
        }

        public Pedido(int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaUltimoUso, DateTime fechaEntrega, double totalCompra, int totalProductosEntregados, DateTime fechaDespacho) : this(id, email, direccion, ordenDeCompra)
        {
            Id = id;
            Email = email;
            Direccion = direccion;
            OrdenDeCompra = ordenDeCompra;
            FechaUltimoUso = fechaUltimoUso;
            FechaEntrega = fechaEntrega;
            TotalCompra = totalCompra;
            TotalProductosEntregados = totalProductosEntregados;
            FechaDespacho = fechaDespacho;
        }

        /*
* Esta lista de productos ya esta encapsulada en Orden de Compra
   private List<ProductoCantidad> productos;
*/

    }
}