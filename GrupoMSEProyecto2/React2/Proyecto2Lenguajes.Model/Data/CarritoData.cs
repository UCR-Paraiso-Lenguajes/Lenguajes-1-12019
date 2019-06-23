using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class CarritoData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public CarritoData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Carrito> GetAll()
        {
            List<Carrito> carrito = new List<Carrito>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select id, idUser from Carrito";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string id = reader.GetString(0);
                            int idUser = reader.GetInt32(1);

                            //carrito.Add(new Carrito(id_publicador, nombre_publicador, url_sitio_web));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return carrito;
        }
    }

    }
}
