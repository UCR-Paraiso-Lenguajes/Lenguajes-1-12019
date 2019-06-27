using Orbis_B67156_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Orbis_B67156_.Model.Data
{
    class PublicadorData
    {

        private string connectionString;

        public PublicadorData(string connectionstring)
        {
            this.connectionString = connectionstring;
        }

        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicador = new List<Publicador>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select id_publicador, nombre_publicador, url_sitio_web from Publicador";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_publicador = reader.GetInt32(0);
                            string nombre_publicador = reader.GetString(1);
                            string url_sitio_web = reader.GetString(2);

                            publicador.Add(new Publicador(id_publicador, nombre_publicador, url_sitio_web));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return publicador;
        }
    }
}
