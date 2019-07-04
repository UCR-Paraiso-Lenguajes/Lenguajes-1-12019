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
    public class ProductoController : ControllerBase
    {

        ProductoData productoData = new ProductoData();

        // GET: api/Producto
        [Route("getAll")]
        [HttpGet]
        public IEnumerable<Producto> Get()
        {

            return productoData.ListProducts();
        }

        // GET: api/Producto/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Producto
        [HttpPost]
        public void Post([FromBody] string value)
        {

        }

        // PUT: api/Producto/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [Route("delete")]
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            productoData.deleteProduct(id);

        }
    }
}
