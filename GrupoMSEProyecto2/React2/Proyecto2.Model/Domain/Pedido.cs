using Proyecto2Lenguajes.Model.Exceptions;
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
        private List<ProductoCantidad> productos;

    }
}