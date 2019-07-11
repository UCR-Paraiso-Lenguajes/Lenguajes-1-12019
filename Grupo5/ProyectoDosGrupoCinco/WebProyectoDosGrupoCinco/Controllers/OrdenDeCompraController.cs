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
    public class OrdenDeCompraController : ControllerBase
    {


        OrdenDeCompraData ordenDeCompraData = new OrdenDeCompraData();

        // GET: api/OrdenDeCompra
        [HttpPost]
        [Route("comprarCarrito")]
        public OrdenDeCompra ComprarCarrito(OrdenDeCompra ordenDeCompra)
        {
           ordenDeCompraData.ComprarCarrito(ordenDeCompra);
            return ordenDeCompra;
        }

        // GET: api/OrdenDeCompra/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/OrdenDeCompra
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT: api/OrdenDeCompra/5
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
