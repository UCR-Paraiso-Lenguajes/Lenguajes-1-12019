using Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Data
{
    public class LibroData
    {
        private string connectionString;
        private string connection;

        public LibroData()
        {
        }

        public LibroData(string connectionString)
        {
            this.connectionString = connectionString;
        }

        public LibroData(string connectionString, string connection) : this(connectionString)
        {
            this.connection = connection;
        }

        public IEnumerable<Libro> GetLibrosByPublicadores(int cod_publicador)
        {
            List<Libro> libros = new List<Libro>();


            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select  cod_libro, titulo_libro, ano_publicacion, isbn, id_publicador, precio" +
                              "from Libro where id_publicador=" + cod_publicador;
                SqlDataAdapter adapter = new SqlDataAdapter(sql, connection);
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int cod_libro = reader.GetInt32(1);
                            string titulo = reader.GetString(2);
                            int ano = reader.GetInt32(3);
                            string isbn = reader.GetString(4);
                            int id_publicador = reader.GetInt32(5);
                            int precio = reader.GetInt32(6);

                            libros.Add(new Libro(cod_libro, titulo, ano, isbn, precio));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return libros;
        }

    }
}
