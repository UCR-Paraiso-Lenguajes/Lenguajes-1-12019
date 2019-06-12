using OrbisB54524.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;
using System.Data;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB54524.Model.Data
{
    public class PublicadorData
    {
        private SqlConnection connection;

        public PublicadorData(string connection)
        {
            this.connection = new SqlConnection(connection);
        }

        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicadores = new List<Publicador>();
            using (connection)
            {
                connection.Open();
                string sql = "SELECT id_publicador, nombre_publicador, url_sitio_web " +
                    "FROM Publicador ";

                using (SqlCommand commad = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = commad.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string sitioWeb = reader.GetString(2);
                            publicadores.Add(new Publicador(id, nombre, sitioWeb));
                        }
                        reader.Close();
                    }
                }
                connection.Close();
            }
            return publicadores;
        }
    }
}
