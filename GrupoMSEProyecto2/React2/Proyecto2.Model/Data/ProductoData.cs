using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class ProductoData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public ProductoData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Producto> GetAll()
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select id, impuesto, nombre, descripcion, precio, cantidadDisponible from Producto";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            decimal impuesto = reader.GetDecimal(1);
                            string nombre = reader.GetString(2);
                            string descripcion = reader.GetString(3);
                            float precion = reader.GetFloat(4);
                            int cantidadDisponible = reader.GetInt32(5);

                            //productos.Add(new Producto(id_publicador, nombre_publicador, url_sitio_web));
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
