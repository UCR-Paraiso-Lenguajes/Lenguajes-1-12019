using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using model.Data;
using model.Domain;

namespace B40894Examen2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrganigramaJerarquicoController : ControllerBase
    {
        public OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();
        // GET: api/OrganigramaJerarquico
        [HttpGet]
        public IEnumerable<Organigrama_Jerarquico> GetAll()
        {
            return organigramaJerarquicoData.GetListOrganigramaJerarquico();
        }

        // GET: api/OrganigramaJerarquico/5
        [HttpGet("{id}")]
        public Organigrama_Jerarquico GetById(int id)
        {
            return organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(id);
        }

        // POST: api/OrganigramaJerarquico
        [HttpPost]
        public void Post([FromBody] Organigrama_Jerarquico value)
        {
            organigramaJerarquicoData.InsertOrganigramaJerarquico(value);
        }

        // PUT: api/OrganigramaJerarquico/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Organigrama_Jerarquico value)
        {
            organigramaJerarquicoData.EditOrganigramaJerarquico(value, id);
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            organigramaJerarquicoData.DeleteOrganigramaJerarquico(id);
        }
    }
}
