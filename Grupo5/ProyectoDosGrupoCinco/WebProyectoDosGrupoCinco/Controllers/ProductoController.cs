using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProyectoDosGrupoCinco.Business;
using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;

namespace WebProyectoDosGrupoCinco.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductoController : ControllerBase
    {

        ProductoData productoData = new ProductoData();
        ProductoBusiness productoBusiness = new ProductoBusiness();

        // GET: api/Producto
        [Route("getAllProducts")]
        [HttpGet]
        public IEnumerable<Producto> GetAll()
        {
            return productoBusiness.getAllProduct();
        }

        [Route("getAll")]
        [HttpPost]
        public IEnumerable<Producto> GetAll([FromBody]int indice)
        {
            return productoBusiness.CargarProductos(indice);
        }

        [Route("getProductByDescription")]
        [HttpGet("{descripcion}")]
        public IEnumerable<Producto> GetProductByDescription(string descripcion, int indice)
        {
            
            return productoBusiness.BuscarPorDescripcion(descripcion,indice);
        }

        // GET: api/Producto/5
        [Route("getById")]
        [HttpPost]
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
        [HttpPut]
        public void Put([FromBody] Producto productoActualizar)
        {

            productoData.actualizarProducto(productoActualizar.IdProducto, productoActualizar);
        }

        // DELETE: api/ApiWithActions/5
        [Route("delete")]
        [HttpDelete("{id}")]
        public int Delete([FromBody]int idProducto)
        {
            productoData.Delete(idProducto);

            return idProducto;

        }
    }
}
