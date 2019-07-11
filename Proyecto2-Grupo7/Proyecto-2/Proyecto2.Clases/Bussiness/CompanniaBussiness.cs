﻿using System;
using System.Collections.Generic;
using System.Text;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;

namespace Proyecto2.Clases.Bussiness
{
    public class CompanniaBussiness
    {
        ProductoData productoData = new ProductoData();
        CarritoData carritoData = new CarritoData();
        PedidoData pedidoData = new PedidoData();

        public IEnumerable<Producto> ListarProducto(int indice)
        {
            int cont = 0;
            List<Producto> products = productoData.ListProducts();
            List<Producto> productsContados = new List<Producto>();
            if (products.Capacity >= indice)
            {
                foreach (Producto producto in products)
                {
                    if (productsContados.Capacity <= 50)
                    {
                        productsContados.Add(producto);
                    }
                }
            }
            else
            {
                return products;
            }
            return productsContados;
        }

        public Producto ProductoPorId(string id)
        {
            Producto productoTemp = new Producto();
            List<Producto> products = productoData.ListProducts();


            foreach (Producto producto in products)
            {
                if (producto.Id.Equals(id))
                {
                    productoTemp = producto;
                }
            }
            return productoTemp;
        }


        public void ActualizarInventario(Producto producto, int cantidad)
        {
            Producto productoActualizar = new Producto();
            producto = ProductoPorId(producto.Id);
            producto.CantidadDisponible=cantidad;
            productoData.Actualizar(producto);
        }


        public Carrito recuperarCarrito(string idComprador) {
            Carrito carritoRecuperado = new Carrito();
            List<Carrito> carritos  =carritoData.listarCarritos();


            foreach (Carrito carrito in carritos)
            {
                if (carrito.Comprador.Id.Equals(idComprador))
                {
                    carritoRecuperado = carrito;
                }
            }
            if (carritoRecuperado.Id == null) {

                List<ProductoCantidad> productosCantidad = new List<ProductoCantidad>();
                carritoRecuperado.Comprador= carritoData.ListCompradorbyid(idComprador);
                carritoData.InsertarCarrito(carritoRecuperado);


            };


            return carritoRecuperado;
        }


        public void AgregarProductoAlCarrito(Producto producto, int cantidadDisponible, string idCarrito) {


            ProductoCantidad productoCantidad = new ProductoCantidad(producto, cantidadDisponible);
            carritoData.InsertarProductoCantidad(productoCantidad, idCarrito);
        }
   

            public void comprarCarrito(int idCarrito, string email, string direccion){

            List<ProductoCantidad> productoCantidads = carritoData.ListProductCantidadbyCarrito(idCarrito.ToString());
            Pedido pedido = new Pedido(carritoData.getCarritobyid(idCarrito),"0",email,direccion,productoCantidads);
            pedidoData.Insertar(pedido);
            
            foreach (ProductoCantidad productoCantidad in productoCantidads)
            {
                Producto producto = productoData.ListProductsbyid(productoCantidad.Producto.Id);


                if (producto.CantidadDisponible > 0) {

                    producto.CantidadDisponible = producto.CantidadDisponible - 1;
                    productoData.Actualizar(producto);

                }
            }
          
        }

        public IEnumerable<Pedido> ListarPedido(int indice)
        {
            int cont = 0;
            List<Pedido> pedidos = pedidoData.ListaPedido();
            List<Pedido> pedidosContados = new List<Pedido>();
            if (pedidos.Capacity >= indice)
            {
                foreach (Pedido pedido in pedidos)
                {
                    if (pedidosContados.Capacity <= 50)
                    {
                        pedidosContados.Add(pedido);
                    }
                }
            }
            else
            {
                return pedidos;
            }
            return pedidosContados;
        }

        public Pedido PedidosPorId(string id)
        {
            Pedido pedidoTemp = new Pedido();
            List<Pedido> pedidos = pedidoData.ListaPedido();


            foreach (Pedido pedido in pedidos)
            {
                if (pedido.Id.Equals(id))
                {
                    pedidoTemp = pedido;
                }
            }
            return pedidoTemp;
        }





    }






    }

