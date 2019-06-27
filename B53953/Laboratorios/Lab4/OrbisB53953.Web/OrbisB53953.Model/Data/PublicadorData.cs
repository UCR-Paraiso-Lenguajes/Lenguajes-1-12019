
using OrbisB53953.Web.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB53953.Web.Data
{
    public class PublicadorData
    {
        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicadores = new List<Publicador>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=OrbisB53953_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id_publicador, nombre_publicador, url_sitio_web from PUBLICADOR";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string sitioWeb = reader.GetString(2);

                            publicadores.Add(new Publicador(id, nombre, sitioWeb));
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
