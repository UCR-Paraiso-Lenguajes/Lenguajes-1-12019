using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;

namespace Proyecto_2.Controllers
{
    public class CarritoController : ControllerBase
    {
        CarritoData carritoData = new CarritoData();
        Carrito carrito = new Carrito();

        [HttpPost("api/getCarrito/{idCarrito}")]
        public Carrito GetCarrito(int idCarrito)
        {

           return carritoData.getCarritobyid(idCarrito);
        }
        [HttpPost("api/productoCarrito")]
        public Carrito ProductoCarrito([FromBody] ProductoCantidad producto)
        {

            carrito.Add(producto);
            return carrito;
        }
    }
}