using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Proyecto2.Model.Business;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace api.Controllers
{
    
    
    public class CarritoController : Controller
    {
        private CarritoBusiness carritoBusiness = new CarritoBusiness();
        // GET api/values
        [HttpGet("api/carritousuario/{idUsuario}")]
        public Object TraeCarritoPorIdUsuario(int idUsuario)
        {
            Object salida = carritoBusiness.ObtenerCarritoPorUsuario(idUsuario);
            if (salida is Carrito)
            {
                Carrito carrito = (Carrito)salida;
                return carrito;
            }
            else
            {
                return false;
            }
            
            
        }

        // GET api/values/5
        [HttpPost("api/carritoBaseDeDatos")]
        public void InsertarCarrito([FromBody] Carrito carrito)
        {
            carritoBusiness.InsertarCarrito(carrito);
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
