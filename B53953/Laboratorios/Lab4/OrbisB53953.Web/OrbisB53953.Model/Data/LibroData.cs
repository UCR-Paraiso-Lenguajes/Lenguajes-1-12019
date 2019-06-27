using OrbisB53953.Web.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB53953.Model.Data
{
    class LibroData
    {

        public IEnumerable<Libro> GetByPublicador(int idPublicador)
        {



            List<Libro> libros = new List<Libro>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=OrbisB53953_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();

                string sql = "select id_libro, titulo, precio " +
                      "from LIBRO join PUBLICADOR on( LIBRO.id_publicador = PUBLICADOR.id_publicador)	" +
                      "where  Publicador.id_publicador=" + idPublicador;



                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int codLibro = reader.GetInt32(0);
                            string titulo = reader.GetString(1);
                            int precio = reader.GetInt(2);


                            libros.Add(new Libro(codLibro, titulo, precio));
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
