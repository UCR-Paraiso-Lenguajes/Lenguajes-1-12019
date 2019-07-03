using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
    public class ProductoData
    {
        public IEnumerable<Producto> ListProducts()
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=NombreDeLaBase;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select * from NombreDeLaTabla";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);


                            //  carritos.Add(new CarritoDisponible(id, nombre));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productos;
        }
    }
}
