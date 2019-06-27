using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelExamen2.Data;
using ModelExamen2.Domain;


namespace Examen2B52265.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrganigramaJerarquicoController : ControllerBase
    {
        public OrganigramaJerarquicoData organigrama = new OrganigramaJerarquicoData();
        // GET: api/OrganigramaJerarquico
        [HttpGet]
        public IEnumerable<OrganigramaJerarquico> GetOrganigrama()
        {
            return this.organigrama.GetOrganigramasJerarquicos();
        }

        // GET: api/OrganigramaJerarquico/5
        [HttpGet("{id}", Name = "GetOrganigramaPorID")]
        public OrganigramaJerarquico GetOrganigramaPorId(int id)
        {
            return this.organigrama.GetOrganigramaPorId(id);
        }

        // POST: api/OrganigramaJerarquico
        [HttpPost]
        public void InsertatrOrganigrama([FromBody] OrganigramaJerarquico organigrama)
        {
            this.organigrama.InsertarOrganigrama(organigrama);
        }

        // PUT: api/OrganigramaJerarquico/5
        [HttpPut("{id}")]
        public void ActualizarOrganigrama(int id, [FromBody] OrganigramaJerarquico organigrama)
        {
            this.organigrama.ActualizarOrganigrama(organigrama,id);
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void BorrarOrganigrama(int id)
        {
            this.organigrama.BorrarOrganigrama(id);
        }
    }
}
