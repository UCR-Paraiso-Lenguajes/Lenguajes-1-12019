using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;

namespace Proyecto_2.Controllers
{
    public class CarritoController : ControllerBase
    {
        CarritoData carritoData = new CarritoData();
        [HttpPost("api/getCarrito")]
        public Carrito GetCarrito([FromBody] String idCarrito)
        {

           return carritoData.getCarritobyid(idCarrito);
        }
    }
}