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
    
    
    public class MockUpController : ControllerBase
    {
        private MockUpBusiness mockUpBusiness = new MockUpBusiness();
        // GET api/values
        [HttpGet("api/carrito/{idCarrito}")]
        public Object TraeCarrito(string idCarrito)
        {
            Object salida = mockUpBusiness.traeCarrito(idCarrito);
            if (salida is Carrito)
            {
                Carrito carrito = (Carrito)mockUpBusiness.traeCarrito(idCarrito);
                return carrito;
            }
            else
            {
                return false;
            }
            
            
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<string> Get(int id)
        {
            return "value";
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
