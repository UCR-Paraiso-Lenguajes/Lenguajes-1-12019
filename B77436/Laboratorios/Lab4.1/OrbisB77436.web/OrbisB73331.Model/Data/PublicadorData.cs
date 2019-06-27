using OrbisB77436.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB77436.Model.Data
{
    public class PublicadorData
    {

        private string connectionString;/*= "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B77436]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";*/

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

                            publicador.Add(new Publicador(id_publicador,nombre_publicador,url_sitio_web));
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
