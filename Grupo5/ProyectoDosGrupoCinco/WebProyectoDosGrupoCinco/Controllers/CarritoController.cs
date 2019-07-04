using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;

namespace WebProyectoDosGrupoCinco.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CarritoController : ControllerBase
    {

        CarritoData carritoData = new CarritoData();

        // GET: api/Carrito
        /* [Route("getCarrito")]
         [HttpGet]
         public Carrito Get()
         {
             return carritoData.CarritoDisponible();
         }
         */
        // GET: api/Carrito/5
        [Route("getCarritoId")]
        [HttpGet("{id}")]
        public Carrito Get(int id)
        {
            return carritoData.CarritoDisponible(id); ;
        }

        // POST: api/Carrito
        [Route("insertCarrito")]
        [HttpPost]
        public void Post([FromBody] CarritoDisponible carrito)
        {
            carritoData.crearCarrito(carrito);
        }

        [Route("insertProductoCarrito")]
        [HttpPost]
        public void PostProductoCarrito([FromBody] ProductoCarrito productoCarrito)
        {
            carritoData.carritoProducto(productoCarrito);
        }

        // PUT: api/Carrito/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
