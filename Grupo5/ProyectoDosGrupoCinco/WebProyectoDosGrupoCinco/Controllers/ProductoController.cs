﻿using System;
using System.Collections.Generic;
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
        [Route("getAll")]
        [HttpGet("{indice}")]
        public IEnumerable<Producto> GetAll([FromBody]int indice)
        {

            return productoBusiness.CargarProductos(2);
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
        [HttpPut("{id}")]
        public void Put([FromBody] Producto productoActualizar)
        {

            productoData.actualizarProducto(productoActualizar.IdProducto, productoActualizar);
        }

        // DELETE: api/ApiWithActions/5
        [Route("delete")]
        [HttpDelete("{id}")]
        public void Delete(Producto producto)
        {
            productoData.Delete(producto.IdProducto);

        }
    }
}
