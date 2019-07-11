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
    
    
    public class ProductoController : Controller
    {
        private static string sqlconnectc = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
        private ProductoData productoData = new ProductoData(sqlconnectc);
        // GET api/values
        [HttpGet("api/productosrango/{indice}")]
        public IEnumerable<Producto> TraeProductoPorIndice(int indice)
        {
            return productoData.ObtenerRango(indice);
        }

        /*
        [HttpPost("api/carritoBaseDeDatos")]
        public void InsertarCarrito([FromBody] Carrito carrito)
        {
            //carritoBusiness.InsertarCarrito(carrito);
        }*/

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
