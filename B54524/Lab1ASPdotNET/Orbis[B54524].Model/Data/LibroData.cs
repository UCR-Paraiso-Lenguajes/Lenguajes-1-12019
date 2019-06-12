using OrbisB54524.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB54524.Model.Data
{
    public class LibroData
    {
        private SqlConnection connection;

        public LibroData(string connection)
        {
            this.connection = new SqlConnection(connection);
        }

        public IEnumerable<Libro> GetByCodPublicador(int codPüblicador)
        {
            List<Libro> libros = new List<Libro>();
            using (connection)
            {
                string sql = "SELECT cod_libro, titulo_libro, ano_publicacion, isbn, id_publicador " +
                    "FROM Libro WHERE id_publicador = @codPüblicador";

                using (SqlCommand commad = new SqlCommand(sql, connection))
                {
                    commad.Parameters.AddWithValue("@codPüblicador", codPüblicador);
                    connection.Open();
                    using (SqlDataReader reader = commad.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string titulo = reader.GetString(1);
                            short anio = reader.GetInt16(2);
                            string isbn = reader.GetString(3);
                            int idPublicador = reader.GetInt32(4);
                            Publicador publicador = new Publicador(idPublicador);
                            List<Autor> autores = new List<Autor>();
                            libros.Add(new Libro(id, titulo, anio, isbn, publicador, autores));
                        }
                        reader.Close();
                    }
                }
                connection.Close();
            }
            return libros;
        }
    }
}
