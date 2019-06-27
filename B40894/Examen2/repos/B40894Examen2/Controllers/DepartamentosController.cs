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
    public class DepartamentosController : ControllerBase
    {
        public DepartamentosData departamentosData = new DepartamentosData();
        // GET: api/Departamentos
        [HttpGet]
        public IEnumerable<Departamentos> GetAll()
        {
            return departamentosData.GetListDepartamentos();
        }

        // GET: api/Departamentos/5
        [HttpGet("{id}")]
        public Departamentos GetByID(int id)
        {
            return departamentosData.GetDepartamentosByID(id);
        }

        // POST: api/Departamentos
        [HttpPost]
        public void Post([FromBody] Departamentos value, int idJefatura)
        {
            departamentosData.InsertDepartamentos(value, idJefatura);
        }

        // PUT: api/Departamentos/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Departamentos value)
        {
            departamentosData.EditDepartamento(value,id);
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            departamentosData.DeleteDepartamento(id);
        }
    }
}
