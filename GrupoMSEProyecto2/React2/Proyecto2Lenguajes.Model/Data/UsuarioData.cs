using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class UsuarioData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public UsuarioData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Usuario> GetAll()
        {
            List<Usuario> comprador = new List<Usuario>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select id, nombre, passwordComprador, emailPrincipal from Comprador";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string passwordComprador = reader.GetString(2);
                            string emailPrincipal = reader.GetString(3);

                            //comprador.Add(new Usuario(id_publicador, nombre_publicador, url_sitio_web));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return comprador;
        }
    }
}
