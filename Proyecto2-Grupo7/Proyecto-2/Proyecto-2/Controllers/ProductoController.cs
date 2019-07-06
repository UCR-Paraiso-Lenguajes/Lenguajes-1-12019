using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;


namespace Proyecto_2.Controllers
{
    public class ProductoController : Controller
    {
         ProductoData productoData = new ProductoData();


        [HttpPost("api/insertarProducto")]
        public void AgregarProducto([FromBody] Producto producto)
        {

            productoData.Insertar(producto);

        }
        [HttpPut("api/actualizarProducto")]
        public void ActualizarProducto([FromBody] Producto producto)
        {

            productoData.Actualizar(producto);

        }
        [HttpGet("api/productos")]
        public IEnumerable<Producto> ListarProducto()
        {
            IEnumerable<Producto> products = productoData.ListProducts();
            return products;
        }
    }
}

    

