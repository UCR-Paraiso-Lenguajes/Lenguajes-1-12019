using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB32915.Web.Business;
using OrbisB32915.Web.Data;
using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Controllers
{
    public class LibroController : Controller
    {
        readonly IConfiguration configuration;
        public LibroController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }
        
        private LibroBusiness libroBusiness = new LibroBusiness();
        private EditorialBusiness editorialBusiness = new EditorialBusiness();


        [HttpGet]
        public IActionResult Index()
        {
            IEnumerable<Libro> librosPorPublicador = libroBusiness.GetByPublicadorId();
            IEnumerable<Editorial> listaEditoriales = editorialBusiness.GetAll();

            dynamic Model = new ExpandoObject();

            Model.Editoriales = listaEditoriales;
            Model.Libros = librosPorPublicador;

            return View(Model);
        }
        [HttpPost]
        public IActionResult Index(int codEditorial)
        {
            IEnumerable<Libro> librosPorPublicador = libroBusiness.GetByPublicadorId(codEditorial);

            return View(librosPorPublicador);
        }
    }

}
