using Entidades;
using Servicios;
using System;
using System.Collections.Generic;
using System.DirectoryServices;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Login : System.Web.UI.Page
    {
        #region variables globales
        ConexionServicios conexionServicios = new ConexionServicios();
        int rol;
        #endregion

        #region page load
        protected void Page_Load(object sender, EventArgs e)
        {
        
        }
        #endregion

    }
}