using OrbisB56860.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB56860.Model.Data
{
    public class LibroData
    {

        private String connectionString;


        public LibroData(String connectionString)
        {
            this.connectionString = connectionString;
        }


        public IEnumerable<Libro> GetByCodPublicador(Publicador publicador)
        {
            Libros libros = new Libros();
            

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "SELECT l.id_libro,l.titulo,l.precio  FROM Libro l  WHERE id_publicador = "+publicador.IdPublicador;
                using (
                    SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string titulo = reader.GetString(1);
                            double precio = reader.GetDouble(2);


                            libros.ListaLibros.Add(new Libro(id,titulo,precio));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return libros.ListaLibros;
        }
    }
}
