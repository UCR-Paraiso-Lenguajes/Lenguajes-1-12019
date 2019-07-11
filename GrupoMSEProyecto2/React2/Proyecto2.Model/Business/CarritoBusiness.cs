using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Business
{
    public class CarritoBusiness
    {
        CarritoData carritoData = new CarritoData();
        public Object ObtenerCarritoPorUsuario(int idComprador)
        {
            return carritoData.ObtenerCarritoPorUsuario(idComprador);
        }
        public void InsertarCarrito(Carrito carrito)
        {
            carritoData.InsertarCarrito(carrito);
        }
        public void Actualiza(int idUser, ProductoCantidad productoCantidad)
        {
            carritoData.Actualiza(idUser, productoCantidad);
        }
        public void BorrarCarrito(Carrito carrito)
        {
            carritoData.BorrarCarrito(carrito);
        }
        public bool Comprar(Carrito carrito)
        {
            //Retorna False si hay problemas de cantidades en bodega
            //True si la compra fue exitosa
            return carritoData.Comprar(carrito);
        }
    }
}
