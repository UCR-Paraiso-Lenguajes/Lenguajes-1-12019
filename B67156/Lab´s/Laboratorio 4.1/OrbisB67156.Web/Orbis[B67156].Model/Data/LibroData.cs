using Orbis_B67156_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Orbis_B67156_.Model.Data
{
    class LibroData
    {

        private string connectionString;

        public LibroData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Libro> GetByCodPublicador(int codPublicador)
        {
            List<Libro> libro = new List<Libro>();

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string sql = "select id_libro, titulo, ano, precio,id_editorial from Libro where id_editorial = " + codPublicador;
                //string sql = "select id_libro, titulo, ano, precio,id_editorial, id_publicador from Libro where id_publicador = " + codPublicador;

                DataSet librosBD = new DataSet();
                SqlDataAdapter adapter = new SqlDataAdapter();
                adapter.SelectCommand = new SqlCommand(
                    sql, connection);
                adapter.Fill(librosBD);

                foreach (DataRow pRow in librosBD.Tables[0].Rows)
                {
                    int id_Libro = (int)pRow["id_libro"];
                    string titulo = (string)pRow["titulo"];
                    Int32 ano = (Int16)pRow["ano"];
                    double precio = (double)pRow["precio"];
                    Int32 id_editorial = (Int32)pRow["id_editorial"];
                    libro.Add(new Libro(id_Libro, titulo, ano, (float)precio, id_editorial));
                }

            }
            return libro;
        }
    }
}
