using Examen2B73331.Model.Business;
using Examen2B73331.Model.Domain;
using Microsoft.AspNetCore.Mvc;

namespace Examen2B73331.Controllers
{
    public class OrganigramaController : Controller
    {
        public IActionResult Index()
        {

            OrganigramaBusiness organigramaBusiness = new OrganigramaBusiness();
            Organigrama organigrama = organigramaBusiness.traeOrganigrama();

            return View(organigrama.mostrarSinRaiz());
        }
        public DepartamentoAbstracta getRaiz()
        {
            OrganigramaBusiness organigramaBusiness = new OrganigramaBusiness();
            Organigrama organigrama = organigramaBusiness.traeOrganigrama();
            return organigrama.DepartamentoRaiz;
        }
    }
}
/*using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using core.Domain;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using model.Business;

namespace web.Controllers
{

    public class PeliculaController : Controller
    {
        readonly IConfiguration configuration;

        public PeliculaController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }

        public IActionResult Index()
        {
            string sql = configuration.GetConnectionString("sql");

            IEnumerable<Pelicula>  peliculas =  new PeliculaBussines(sql).List();

            return View(peliculas);
        }
    }
}*/
