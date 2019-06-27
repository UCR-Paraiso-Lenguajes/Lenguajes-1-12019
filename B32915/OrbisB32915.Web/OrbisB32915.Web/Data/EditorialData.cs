using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Data
{
    public class EditorialData
    {
       public EditorialData()
        {

        } 

        public List<Editorial> GetAll()
        {
            List<Editorial> listaEditoriales = new List<Editorial>();
            
            using (SqlConnection connection = new SqlConnection("data source=" +
                            "163.178.173.148;initial " +
                            "catalog=OrbisB32915_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                            "multipleactiveresultsets=True"))

            {
                connection.Open();
                string sql = "Select id_editorial,nombre,direccion,telefono,url_sitio "+
                             "from Editorial";

                using (SqlCommand command = new SqlCommand(sql, connection))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_editorial = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string direccion = reader.GetString(2);
                            string telefono = reader.GetString(3);
                            string url_sitio = reader.GetString(4);
                           
                            listaEditoriales.Add(new Editorial(id_editorial,nombre,direccion,telefono,url_sitio));
                        }
                        reader.Close();
                    };
                }
                connection.Close();

                return listaEditoriales;
            }
        }
    }
}
