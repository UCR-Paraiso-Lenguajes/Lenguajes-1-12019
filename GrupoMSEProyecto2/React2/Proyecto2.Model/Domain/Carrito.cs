using Proyecto2Lenguajes.Model.Exceptions;
using System;
using System.Collections.Generic;

namespace Proyecto2.Model.Domain
{
    /// <summary>
    /// Clase que admnistra carrito
    /// </summary>
    public abstract class Carrito
    {

        private string id;
        public string Id
        {
            get { return id; }
            set {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value)) throw new CompanniaException("El id no puede estar vacío");
                id = value; }
        }
        private Usuario usuario;
        public Usuario Usuario
        {
            get { return usuario; }
            set { usuario = value ?? throw new CompanniaException("El usuario debe existir"); }
        }
        private decimal subtotal;
        public decimal Subtotal
        {
            get { return subtotal; }
            set {
                if(value < 0) throw new CompanniaException("El subtotal debe ser un numero positivo");
                subtotal = value;
            }
        }
        private int total;
        public int Total
        {
            get { return total; }
            set {
                if (value < 0) throw new CompanniaException("El total debe ser un numero positivo");
                total = value;
            }
        }
        /*
         * Proponer solo dejar la lista de productosCantidad, 
         * no veo eficiente tener la misma lista de productos dos veces 
         * una con cantidad y otra sin cantidad
        private Productos productos;
        public Productos Productos
        {
            get { return productos; }
            set { productos = value ?? throw new CompanniaException("Los productos no pueden estar vacios"); }
        }*/
        private Pedido pedido;
        public Pedido Pedido
        {
            get { return pedido; }
            set
            {
                pedido = value ?? throw new CompanniaException("El pedido tiene problemas");
            }
        }
        private Carrito() { }
        public Carrito(string id, Usuario usuario, decimal subtotal, int total, Pedido pedido)
        {
            Id = id;
            Usuario = usuario;
            Subtotal = subtotal;
            Total = total;
            Pedido = pedido;
        }
    }
}
