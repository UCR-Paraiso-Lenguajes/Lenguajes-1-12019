using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ExamenPriscilla.Data;
using ExamenPriscilla.Domain;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ExamenPriscilla.Controllers
{

    [EnableCors("AllowMyOrigin")]
    [Route("api/[controller]")]
    [ApiController]
    public class DepartamentoController : ControllerBase
    {

        DepartamentoData departamentoData;

        public DepartamentoController(DepartamentoData departamentoData)
        {
            this.departamentoData = departamentoData;
        }



        // GET api/departamento
        [HttpGet]
        public ActionResult<IEnumerable<DevuelveDepartamento>> Get()
        {
            
            return this.departamentoData.obtenerDepartamentos() ;
        }

        // GET api/departamento/5
        [HttpGet("{id}")]
        public ActionResult<Departamento> Get(String id)
        {
            return this.departamentoData.obtenerDepartamento(id);
        }

        // POST api/values
        [HttpPost]
        public Departamento Post([FromBody] Departamento value)
        {
            return this.departamentoData.agregarDepartamento(value);
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public Departamento Put(String id, [FromBody] Departamento value)
        {
            return this.departamentoData.actualizarDepartamento(id, value);
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(String id)
        {
          this.departamentoData.eliminarDepartamento(id);
        }
    }
}