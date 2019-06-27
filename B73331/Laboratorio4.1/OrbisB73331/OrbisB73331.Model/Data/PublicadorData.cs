using OrbisB73331.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;

namespace OrbisB73331.Model.Data
{
    public class PublicadorData
    {
        

        public PublicadorData()
        {
            
        }
        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicadores = new List<Publicador>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=Orbis[B73331]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id_publicador, nombre_publicador," +
                    " url_sitio_web from Publicador";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string urlSitioWeb = reader.GetString(2);

                            publicadores.Add(new Publicador(id, nombre, urlSitioWeb));
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
