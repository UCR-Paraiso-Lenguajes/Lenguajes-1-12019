using OrbisB40894.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;

namespace OrbisB40894.Model.Data
{
   public class PublicadorData
    {
        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicadores = new List<Publicador>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=Orbis[B63685]_l_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id_editorial,nombre from Editorial";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_publicador = reader.GetInt32(0);
                            string nombre = reader.GetString(1);

                            publicadores.Add(new Publicador(id_publicador, nombre));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return publicadores;
        }
    }
}
