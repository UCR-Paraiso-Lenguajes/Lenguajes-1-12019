using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto.Error
{
    public partial class Error : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
           

            Exception ex = (Exception)Application["ERROR"];
            lblError.Text = ex.GetBaseException().Message;
        }
    }
}