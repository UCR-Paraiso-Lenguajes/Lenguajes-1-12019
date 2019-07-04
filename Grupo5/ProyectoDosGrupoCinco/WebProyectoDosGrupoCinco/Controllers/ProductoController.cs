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
        [Route("getById")]
        [HttpGet("{id}", Name = "Get")]
        public Producto Get(int id)
        {
            return productoData.GetProductById(id);
        }

        // POST: api/Producto
        [Route("insert")]
        [HttpPost]
        public void Post([FromBody] Producto producto)
        {
            productoData.InsertarProducto(producto);

        }

        // PUT: api/Producto/5
        [Route("update")]
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Producto productoActualizar)
        {

            productoData.actualizarProducto(id, productoActualizar);
        }

        // DELETE: api/ApiWithActions/5
        [Route("delete")]
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            productoData.Delete(id);

        }
    }
}
