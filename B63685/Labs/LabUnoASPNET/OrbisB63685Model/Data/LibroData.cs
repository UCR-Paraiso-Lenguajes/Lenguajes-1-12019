using Microsoft.AspNetCore.Mvc.Rendering;
using OrbisB63685Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace OrbisB63685Model.Data
{
    public class LibroData
    {

        public IEnumerable<Libro> GetByCodEditorial(String codPublicador)
        {

          

            List<Libro> libros = new List<Libro>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=Orbis[B63685]_l_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();

                                                                                                                                                                                                 if (codPublicador == null)
                                                                                                                                                                                                 {

                                                                                                                                                                                                 codPublicador = "2020202002";
                                                                                                                                                                                                 }
               



                  string   sql = "select id_libro, titulo, precio " +
                        "from Libro join Editorial on( Libro.id_editorial = Editorial.id_editorial)	" +
                        "where  Editorial.id_editorial=" + codPublicador.ToString();



                    using (SqlCommand command = new SqlCommand(sql, connection))
                    {
                        using (SqlDataReader reader = command.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                int idLibro = reader.GetInt32(0);
                                string titulo = reader.GetString(1);
                                double precio = reader.GetDouble(2);






                                libros.Add(new Libro(idLibro, titulo, precio));
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

