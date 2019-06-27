using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Examen2_Clases.Business;
using Examen2_Clases.Domain;

namespace Examen2_Web.Controllers
{
    [ApiController]
    public class OrganigramasController : ControllerBase
    {
        OrganigramaBusiness organigramaBusiness = new OrganigramaBusiness();
        [HttpGet("api/organigramas")]
        public IEnumerable<Organigrama> Listar()
        {
            return organigramaBusiness.Listar();
        }
        [HttpPut("api/updateOrganigrama/{organigramaNuevo}")]
        public void Actualizar( [FromBody] Organigrama organigramaNuevo)
        {
            organigramaBusiness.Actualizar(organigramaNuevo);
        }
        [HttpDelete("api/deleteOrganigrama/{organigrama}")]
        public void Eliminar([FromBody] Organigrama organigrama)
        {
            organigramaBusiness.Eliminar(organigrama);
        }
        [HttpPost("api/agregarOrganigrama/{organigrama}")]
        public void Agregar([FromBody] Organigrama organigrama)
        {
            organigramaBusiness.Agregar(organigrama);
        }
    }
}