using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto_2.Controllers
{
    public class LoginController : ControllerBase
{
        CompradorData compradorData = new CompradorData();

        [HttpPost("api/logearComprador")]
        public bool validarComprador([FromBody] Comprador comprador)
        {

            return compradorData.validarUsuario(comprador);
        }

        [HttpPost("api/crearComprador")]
        public void insertarComprador([FromBody] Comprador comprador)
        {

            compradorData.insertarComprador(comprador);
        }
    }
}
