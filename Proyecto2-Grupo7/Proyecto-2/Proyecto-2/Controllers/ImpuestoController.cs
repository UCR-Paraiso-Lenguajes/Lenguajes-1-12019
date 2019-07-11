using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto_2.Controllers
{
    public class ImpuestoController : ControllerBase
{
        ImpuestoData data = new ImpuestoData();

        [HttpGet("api/impuesto")]
        public List<Impuesto> obtenerValorImpuesto()
        {
            return data.obtenerImpuesto();
        }

        [HttpPut("api/actualizarImpuesto")]
        public void actualizar([FromBody] Impuesto impuesto)
        {
            data.Actualizar(impuesto);
        }

    }
}
