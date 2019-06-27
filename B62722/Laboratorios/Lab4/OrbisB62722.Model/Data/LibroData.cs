using OrbisB62722.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;

namespace OrbisB62722.Model.Data
{
    public class LibroData
    {
        String connectionString;

        public LibroData(string connectionString)
        {
            this.connectionString = connectionString;
        }

        public List<Libro> GetByCodPublicador(int cod_publicador)
        {

            String sqlSelect = "SELECT cod_libro, titulo_libro, ano_publicacion, isbn, precio " +
                "FROM Libro WHERE id_publicador = '" + cod_publicador + "'";
            Console.Write(sqlSelect);
            SqlDataAdapter daLibros = new SqlDataAdapter(sqlSelect, new SqlConnection(connectionString));

            DataSet dataSet = new DataSet();
            daLibros.Fill(dataSet, "Libro");
            Dictionary<Int32, Libro> dictionary = new Dictionary<Int32, Libro>();
            Libro libro = null;
            foreach (DataRow row in dataSet.Tables["Libro"].Rows)
            {
                Int32 cod_libro = Int32.Parse(row["cod_libro"].ToString());
                if (dictionary.ContainsKey(cod_libro) == false)
                {
                    libro = new Libro();
                    libro.cod_libro = cod_libro;
                    libro.titulo_libro = row["titulo_libro"].ToString();
                    libro.ano_publicacion = Int32.Parse(row["ano_publicacion"].ToString());
                    libro.isbn = row["isbn"].ToString();
                    libro.precio = float.Parse(row["precio"].ToString());
                    dictionary.Add(cod_libro, libro);
                }
            }
            return dictionary.Values.ToList<Libro>();
        }

    }
}
