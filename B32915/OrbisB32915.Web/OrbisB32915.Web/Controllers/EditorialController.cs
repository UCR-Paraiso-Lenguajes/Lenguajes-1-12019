using Microsoft.AspNetCore.Mvc;
using OrbisB32915.Web.Data;
using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Controllers
{
    public class EditorialController : Controller
    {

        private EditorialData editorialData = new EditorialData();

        /*[HttpGet("api/libro")]
        public IEnumerable<Editorial> Editoriales()
        {
            return listaEditoriales;
        }*/

        [HttpGet]
        public ActionResult vistaEditorial()
        {
            IEnumerable<Editorial> listaEditoriales = editorialData.GetAll();

            return View(listaEditoriales);
        }

    }
}
