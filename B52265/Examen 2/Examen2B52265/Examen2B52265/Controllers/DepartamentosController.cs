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
    public class DepartamentosController : ControllerBase
    {
       public DepartamentosData departamentos = new DepartamentosData();
        // GET: api/Departamentos
        [HttpGet]
        public IEnumerable<Departamentos> GetDepartamentos()
        {
            return this.departamentos.GetDepartamentos();
        }

        // GET: api/Departamentos/5
        [HttpGet("{id}", Name = "GetDepartamentosPorID")]
        public Departamentos GetDepartamentosPorID(int id)
        {
            return this.departamentos.GetDepartamentosPorId(id);
        }

        // POST: api/Departamentos
        [HttpPost]
        public void IngresarDepartamento([FromBody] Departamentos departamento, int idJefatura)
        {
                this.departamentos.InsertarDepartamento(departamento, idJefatura);    
        }

        // PUT: api/Departamentos/5
        [HttpPut("{id}")]
        public void ActualizarDepartamentos(int id, [FromBody] Departamentos departamentos)
        {
            this.departamentos.ActualizarDepartamento(departamentos,id);
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void BorrarDepartamentos(int id)
        {
            this.departamentos.BorrarDepartamentos(id);
        }
    }
}
