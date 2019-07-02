using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ExamenPriscilla.Data;
using ExamenPriscilla.Domain;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ExamenPriscilla.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrganigramaController : ControllerBase
    {
        OrganigramaData organigramaData;

        public OrganigramaController(OrganigramaData organigramaData)
        {
            this.organigramaData = organigramaData;
        }



        // GET api/organigrama
        [HttpGet]
        public ActionResult<IEnumerable<Organigrama>> Get()
        {

            return this.organigramaData.obtenerOrganigramas();
        }

        // GET api/organigrama/5
        [HttpGet("{id}")]
        public ActionResult<Organigrama> Get(int id)
        {
            return this.organigramaData.obtenerOrganigrama(id);
        }

        // POST api/values
        [HttpPost]
        public Organigrama Post([FromBody] Organigrama value)
        {
            return this.organigramaData.agregarOrganigrama(value);
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public Organigrama Put(int id, [FromBody] Organigrama value)
        {
            return this.organigramaData.actualizarOrganigrama(id, value);
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            this.organigramaData.eliminarOrganigrama(id);
        }
    }
}