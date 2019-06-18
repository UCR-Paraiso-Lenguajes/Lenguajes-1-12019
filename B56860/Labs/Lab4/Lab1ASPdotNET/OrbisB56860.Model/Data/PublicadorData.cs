using OrbisB56860.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB56860.Model.Data
{
    public class PublicadorData
    {

        private String connectionString;

        public PublicadorData(String connectionString)
        {
            this.connectionString = connectionString;
        }

        
        public IEnumerable<Publicador> GetAll()
        {
            List<Publicador> publicadores = new List<Publicador>();

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "SELECT id_publicador,nombre,url_sitio_web FROM Publicador";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string url = reader.GetString(2);

                            publicadores.Add(new Publicador(id, nombre,url));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return publicadores;
        }

        public Publicador GetById(int idPublicador)
        {
            Publicador publicador = null;

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "SELECT id_publicador,nombre,url_sitio_web FROM Publicador WHERE id_publicador = " + idPublicador;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string url = reader.GetString(2);

                            publicador = new Publicador(id, nombre, url);
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
