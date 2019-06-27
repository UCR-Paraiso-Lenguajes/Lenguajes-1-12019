using Microsoft.AspNetCore.Mvc.Rendering;
using OrbisB63685Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB63685Model.Data
{
    public class EditorialData
    {

        public IEnumerable<Editorial> GetAll()
        {
            List<Editorial> editoriales = new List<Editorial>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=Orbis[B63685]_l_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id_editorial, nombre from Editorial";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);




                            editoriales.Add(new Editorial(id, nombre));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return editoriales;
        }


    }
}


    

