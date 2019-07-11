using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto_2.Controllers
{
    public class OrganizacionController : ControllerBase
    {
        OrganizacionData data = new OrganizacionData();

        [HttpGet("api/organizacion")]
        public List<Organizacion> obtenerInfoOrganizacion()
        {
            return data.obtenerOrganizacion();
        }

        [HttpPut("api/actualizarOrganizacion")]
        public void actualizar([FromBody] Organizacion organizacion)
        {
            data.Actualizar(organizacion);
        }
    }
}
