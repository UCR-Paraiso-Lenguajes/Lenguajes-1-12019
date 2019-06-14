using OrbisB73027.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace OrbisB73027.Model.Data
{
    public class LibroData
    {
        private string connectionString;

        public LibroData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Libro> GetByCodPublicador(int codPublicador)
        {
            List<Libro> libros = new List<Libro>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {

                string sql = "select id_libro, titulo, ano, precio,id_editorial, id_publicador from Libro where id_publicador = " + codPublicador;
                //
                DataSet librosBD = new DataSet();
                SqlDataAdapter adapter = new SqlDataAdapter();
                adapter.SelectCommand = new SqlCommand(
                    sql, connection);
                adapter.Fill(librosBD);

                //SqlDataAdapter adapterLibros = new SqlDataAdapter(sql, connection);

                //DataSet librosBD = new DataSet();
                //adapterLibros.Fill(librosBD, "Libro");
                //Object rows = librosBD.Tables["Libro"].Rows;

                foreach (DataRow pRow in librosBD.Tables[0].Rows)
                {
                    int id_Libro = (int)pRow["id_libro"];
                    string titulo = (string)pRow["titulo"];
                    Int32 ano = (Int16)pRow["ano"];
                    double precio = (double)pRow["precio"];
                    Int32 id_editorial = (Int32)pRow["id_editorial"];
                    Int32 id_publicador = (Int32)pRow["id_publicador"];
                    libros.Add(new Libro(id_Libro, titulo, ano, (float)precio, id_editorial, id_publicador));
                }

            }
            return libros;

        }
    }
}
