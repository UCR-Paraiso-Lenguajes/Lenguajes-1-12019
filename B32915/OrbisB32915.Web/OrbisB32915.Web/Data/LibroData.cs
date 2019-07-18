using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Data
{
    public class LibroData
    {

        public LibroData()
        {

        }

        public List<Libro> GetByPublicador(int id_publicador)
        {
            List<Libro> listaLibros = new List<Libro>();

            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=OrbisB32915_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))

            {
                connection.Open();
                string sql = "Select id_libro, titulo, ano," +
                             "precio,id_editorial,isbn " +
                             "from Libro where id_libro = @Id_publicador";

                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("@Id_publicador", id_publicador);

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_libro = reader.GetInt32(0);
                            string titulo = reader.GetString(1);
                            int ano = reader.GetInt32(2);
                            double precio = reader.GetDouble(3);
                            int id_editorial = reader.GetInt32(4);
                            int isbn = reader.GetInt32(5);

                            listaLibros.Add(new Libro(id_libro, titulo, ano, precio, id_editorial, isbn));
                        }
                        reader.Close();
                    };
                }
                connection.Close();

                return listaLibros;
            }
        }
    }
}

