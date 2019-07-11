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

        [HttpGet("api/getProductosCarrito/{idCarrito}")]
        public IEnumerable<ProductoCantidad> GetProductosCarrito(int idCarrito)
        {

           return carritoData.getCarritobyid(idCarrito).ProductoCantidad;
        }
        [HttpPost("api/productoCarrito/{idCarrito}")]
        public Carrito ProductoCarrito([FromBody] ProductoCantidad producto,int idCarrito)
        {
            carrito = carritoData.getCarritobyid(idCarrito);
            carrito.Add(producto);
            return carrito;
        }

    }
}