using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccesoDatos
{
    public class ConexionDatos
    {
        

        public SqlConnection conexionLab()
        {
            return new SqlConnection(System.Web.Configuration.WebConfigurationManager.ConnectionStrings["connectionString"].ConnectionString);
        }
        
 
    }
}
