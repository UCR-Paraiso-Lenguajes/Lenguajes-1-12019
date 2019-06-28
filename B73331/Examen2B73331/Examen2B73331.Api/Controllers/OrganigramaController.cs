using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Examen2B73331.Model.Business;
using Examen2B73331.Model.Domain;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Examen2B73331.Api.Controllers
{

    public class OrganigramaController : Controller
    {
        // GET: api/Organigrama
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Organigrama/5
        OrganigramaBusiness organigramaBusiness = new OrganigramaBusiness();
        [HttpGet("api/departamentos")]
        public List<DepartamentoAbstracta> departamentos()
        {
            
            return organigramaBusiness.traeOrganigrama().mostrar();
        }

        // POST: api/Organigrama
        [HttpPost("api/departamentos/actualizar/{nid}/{nnombre}/{nmarcado}/{nombreAntiguo}")]
        public void update(int nid, string nnombre, bool nmarcado, string nombreAntiguo)
        {
            organigramaBusiness.traeOrganigrama().actualizaDepartamento(nid, nnombre,nmarcado,nombreAntiguo);
        }
        // POST: api/Organigrama //int nid, string nnombre, bool nmarcado,string nombrePadre
        [HttpPost("api/departamentos/agregar/{nid}/{nnombre}/{nmarcado}/{nombrePadre}")]
        public void agregar(int nid, string nnombre, bool nmarcado, string nombrePadre)
        {
            organigramaBusiness.traeOrganigrama().setDepartamentoLista(nid, nnombre, nmarcado, nombrePadre);
        }

        // PUT: api/Organigrama/5
        [HttpPut("api/departamentos/marcar/{nodoAMarcar}")]
        public void marcar(string nodoAMarcar)
        {
            organigramaBusiness.traeOrganigrama().marcar(nodoAMarcar);
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("api/departamentos/eliminar/{nodoAEliminar}")]
        public void Delete(string nodoAEliminar)
        {
            organigramaBusiness.traeOrganigrama().eliminarDep(nodoAEliminar);
        }
    }
}
